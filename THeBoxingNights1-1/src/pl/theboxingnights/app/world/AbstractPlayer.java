package pl.theboxingnights.app.world;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer extends AbstractAppState implements WorldObject {

    private final AssetManager assetManager;
    private final Node rootNode;
    private final InputManager inputManager;
    private final Camera cam;
    private final FlyByCamera flyCam;
    private SimpleApplication app;
    private AppStateManager stateManager;
    private Node playerNode;
    private String name;
    private String location;
    private Vector3f locationAtTheScene;
    private float scale;
    private BetterCharacterControl betterCharacterControl;
    private GhostControl ghostControl;
    private Node headNode;

    public AbstractPlayer(SimpleApplication app, String name, String location) {
        setName(name);
        setLocation(location);
        setApp(app);
        assetManager = this.app.getAssetManager();
        stateManager = this.app.getStateManager();
        rootNode = this.app.getRootNode();
        inputManager = this.app.getInputManager();
        cam = this.app.getCamera();
        flyCam = this.app.getFlyByCamera();
        load();
        initAnimations();

        flyCam.setEnabled(true);
        inputManager.setCursorVisible(false);
    }

    @Override
    public void update (float tpf) {

    }

    private void load() {
        playerNode = (Node) assetManager.loadModel(location);
        playerNode.setLocalTranslation(new Vector3f(0, 1, 0));
        betterCharacterControl = new BetterCharacterControl(0.5f, 1f, 1f);
        playerNode.addControl(betterCharacterControl);
        stateManager.getState(BulletAppState.class).getPhysicsSpace().add(betterCharacterControl);
        rootNode.attachChild(playerNode);
    }

    private void initAnimations() {
        String initAnimationName = "guard";
        initGhostControlCubeAnimations("Body", initAnimationName);
        initGhostControlCubeAnimations("Head", initAnimationName);

    }

    private void initGhostControlCubeAnimations(String childName, String animName ) {
        Node animNode = (Node) playerNode.getChild(childName);
        AnimControl animControl = animNode.getControl(AnimControl.class);
        System.out.println(animControl.getAnimationNames());
        AnimChannel animChannel = animControl.createChannel();
        animChannel.setAnim(animName);
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

    public Node getPlayerNode() {
        return playerNode;
    }

    public void setPlayerNode(Node playerNode) {
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
        return locationAtTheScene;
    }

    @Override
    public void setLocationAtTheScene(Vector3f locationAtTheScene) {
        this.locationAtTheScene = locationAtTheScene;
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
}
