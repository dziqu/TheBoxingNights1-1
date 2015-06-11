package pl.theboxingnights.app.world;

import com.jme3.animation.*;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CompoundCollisionShape;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.KinematicRagdollControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
import pl.theboxingnights.app.world.player.*;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer extends AbstractAppState implements WorldObject, AnimEventListener, PhysicsTickListener {

    private final AssetManager assetManager;
    private final com.jme3.scene.Node rootNode;
    private final InputManager inputManager;
    private final BulletAppState bulletAppState;
    private SimpleApplication app;
    private AppStateManager stateManager;
    private com.jme3.scene.Node playerNode;
    private String name;
    private String location;
    private Vector3f locationAtTheScene;
    private float scale;
    private BetterCharacterControl betterCharacterControl;
    private GhostControl ghostControl;
    private AbstractControl keyControl;
    private AbstractKeyAction keyAction;
    private Node bodyNode;
    private AnimControl bodyAnimControl;
    private AnimChannel bodyAnimChannel;
    private String animationName = "position";
    private AbstractPlayer opponent;
    private double yDistance;
    private float counter;

    public AbstractPlayer(SimpleApplication app, String name, String location) {
        setName(name);
        setLocation(location);
        setApp(app);
        assetManager = this.getApp().getAssetManager();
        setStateManager(this.getApp().getStateManager());
        rootNode = this.getApp().getRootNode();
        inputManager = this.getApp().getInputManager();
        bulletAppState = getStateManager().getState(BulletAppState.class);
        loadPlayer();
        initAnimInstances();

        new PlayerBuilder(this);

//        SkeletonControl skeletonControl = getPlayerNode().getChild("Body").getControl(SkeletonControl.class);
//
//        Box cube1Mesh = new Box( .6f,.5f,1f);
//        Geometry cube1Geo = new Geometry("My Textured Box", cube1Mesh);
//        cube1Geo.setLocalTranslation(new Vector3f(cube1Geo.getLocalTranslation().getX(), cube1Geo.getLocalTranslation().getY(), cube1Geo.getLocalTranslation().getZ() - 2f));
////        cube1Geo.scale(1f, 0f, 0f);
//        cube1Geo.setName("cubeGeo");
//        Material cube1Mat = new Material(assetManager,
//                "Common/MatDefs/Misc/Unshaded.j3md");
//        cube1Mat.setColor("Color", ColorRGBA.Red);
//        cube1Geo.setMaterial(cube1Mat);
//
//        GhostControl ghost = new GhostControl(
//                new BoxCollisionShape(new Vector3f(.3f, .2f, .5f)));
//
//        Node n = skeletonControl.getAttachmentsNode("Bone.003");
//        n.attachChild(cube1Geo);
//        cube1Geo.addControl(ghost);
//        bulletAppState.getPhysicsSpace().add(ghost);
//
//        Geometry cube1Geo2 = new Geometry("My Textured Box", cube1Mesh);
//        cube1Geo2.setName("cubeGeo2");
//        Material cube1Mat2 = new Material(assetManager,
//                "Common/MatDefs/Misc/Unshaded.j3md");
//        cube1Mat2.setColor("Color", ColorRGBA.Red);
//        cube1Geo2.setMaterial(cube1Mat2);
//
//        GhostControl ghost2 = new GhostControl(
//                new BoxCollisionShape(new Vector3f(.5f,.5f,.5f)));
//
//        Node n2 = skeletonControl.getAttachmentsNode("Bone.006");
//        n2.attachChild(cube1Geo2);
//        cube1Geo2.addControl(ghost2);
//        bulletAppState.getPhysicsSpace().add(ghost2);
    }

    private void loadPlayer() {
        setPlayerNode((Node) getAssetManager().loadModel(getLocation()));
        getPlayerNode().setLocalTranslation(new Vector3f(0, 1, 0));
        setBetterCharacterControl(new BetterCharacterControl(.5f, 3f, 1f));
        getBetterCharacterControl().setGravity(new Vector3f(0, -10, 0));
        getPlayerNode().addControl(getBetterCharacterControl());
        getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(getBetterCharacterControl());
        getRootNode().attachChild(getPlayerNode());
    }

    private void initAnimInstances() {
        setBodyNode((Node) getPlayerNode().getChild("Body"));
        setBodyAnimControl(getBodyNode().getControl(AnimControl.class));

        getBodyAnimControl().addListener(this);

        setBodyAnimChannel(getBodyAnimControl().createChannel());
        getBodyAnimChannel().setAnim(getAnimationName());
    }

    @Override
    public void update (float tpf) {
        setKeysActions();
        lookAt(opponent.getPlayerNode().getWorldTranslation());
        checkCollisions();
    }

    private void setKeysActions() {
        setKeyAction(null);
        if (getKeyControl().isUpKey()) {
            setKeyAction(new Up(this));
            setAnimationName(AnimationsNames.getStepAnimationName());
        } else if (getKeyControl().isDownKey()) {
            setKeyAction(new Down(this));
            setAnimationName(AnimationsNames.getStepAnimationName());
        } else if (getKeyControl().isLeftKey()) {
            setKeyAction(new Left(this));
            setAnimationName(AnimationsNames.getStepAnimationName());
        } else if (getKeyControl().isRightKey()) {
            setKeyAction(new Right(this));
            setAnimationName(AnimationsNames.getStepAnimationName());
        } else {
            setKeyAction(new Position(this));
            this.setAnimationName(AnimationsNames.getPositionAnimationName());
        }
        getKeyAction().make();
        setAnimation(getBodyAnimChannel(), getAnimationName());
    }

    private void setAnimation(AnimChannel animationChannel, String animationName) {
        if (!animationChannel.getAnimationName().equals(animationName)) {
            animationChannel.setAnim(animationName);
        }
    }

    private void checkCollisions() {
        CollisionResults results = new CollisionResults();
//        Spatial n1 = playerNode.getChild("cubeGeo");
//        Spatial n2 = opponent.getPlayerNode().getChild("cubeGeo2");
//        n1.collideWith((Collidable) n2.getWorldBound(), results);
//        System.out.println(results.size());
    }

    public SimpleApplication getApp() {
        return app;
    }

    public void setApp(SimpleApplication app) {
        this.app = app;
    }

    public AppStateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(AppStateManager stateManager) {
        this.stateManager = stateManager;
    }

    public com.jme3.scene.Node getPlayerNode() {
        return playerNode;
    }

    public void setPlayerNode(com.jme3.scene.Node playerNode) {
        this.playerNode = playerNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public Vector3f getLocationAtTheScene() {
        return getPlayerNode().getWorldTranslation();
    }

    @Override
    public void setLocalTranslation(Vector3f locationAtTheScene) {
        getPlayerNode().getControl(BetterCharacterControl.class).warp(locationAtTheScene);
    }

    @Override
    public float getScale() {
        return scale;
    }

    @Override
    public void setScale(float scale) {
        getPlayerNode().setLocalScale(scale);
    }

    public BetterCharacterControl getBetterCharacterControl() {
        return betterCharacterControl;
    }

    public void setBetterCharacterControl(BetterCharacterControl betterCharacterControl) {
        this.betterCharacterControl = betterCharacterControl;
    }

    public GhostControl getGhostControl() {
        return ghostControl;
    }

    public void setGhostControl(GhostControl ghostControl) {
        this.ghostControl = ghostControl;
    }

    public void setKeyControl(AbstractControl keyControl) {
        this.keyControl = keyControl;
    }

    public void lookAt(Vector3f direction) {
        bodyNode = (Node) getPlayerNode().getChild("Body");

        float xDistance = playerNode.getWorldTranslation().getX() - opponent.getPlayerNode().getWorldTranslation().getX();
        float zDistance = playerNode.getWorldTranslation().getZ() - opponent.getPlayerNode().getWorldTranslation().getZ();
        float maxDifference = 6.0f;
        float denominator = 1.75f;
        float difference = xDistance + zDistance;
        if (difference < 0) difference *= -1;
        difference = (float) Math.sqrt(difference);

        bodyNode.lookAt(new Vector3f(direction.getX(), (maxDifference - difference) / denominator , direction.getZ()), Vector3f.UNIT_Y);
        bodyNode.rotate(0, 3.2f, 0);
    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void prePhysicsTick(PhysicsSpace space, float tpf){
        // apply state changes ...
    }
    @Override
    public void physicsTick(PhysicsSpace space, float tpf){
        // poll game state ...
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public void setLocationAtTheScene(Vector3f locationAtTheScene) {
        this.locationAtTheScene = locationAtTheScene;
    }

    public AbstractControl getKeyControl() {
        return keyControl;
    }

    public AbstractKeyAction getKeyAction() {
        return keyAction;
    }

    public void setKeyAction(AbstractKeyAction keyAction) {
        this.keyAction = keyAction;
    }

    public Node getBodyNode() {
        return bodyNode;
    }

    public void setBodyNode(Node bodyNode) {
        this.bodyNode = bodyNode;
    }

    public AnimControl getBodyAnimControl() {
        return bodyAnimControl;
    }

    public void setBodyAnimControl(AnimControl bodyAnimControl) {
        this.bodyAnimControl = bodyAnimControl;
    }

    public AnimChannel getBodyAnimChannel() {
        return bodyAnimChannel;
    }

    public void setBodyAnimChannel(AnimChannel bodyAnimChannel) {
        this.bodyAnimChannel = bodyAnimChannel;
    }

    public String getAnimationName() {
        return animationName;
    }

    public void setAnimationName(String animationName) {
        this.animationName = animationName;
    }

    public void setOpponent(AbstractPlayer opponent) {
        this.opponent = opponent;
    }
}
