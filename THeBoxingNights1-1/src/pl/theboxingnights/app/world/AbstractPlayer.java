package pl.theboxingnights.app.world;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import pl.theboxingnights.app.world.player.*;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer extends AbstractAppState implements WorldObject, AnimEventListener {

    private final AssetManager assetManager;
    private final com.jme3.scene.Node rootNode;
    private final InputManager inputManager;
    private SimpleApplication app;
    private AppStateManager stateManager;
    private com.jme3.scene.Node playerNode;
    private String name;
    private String location;
    private Vector3f locationAtTheScene;
    private float scale;
    private BetterCharacterControl betterCharacterControl;
    private GhostControl ghostControl;
    private com.jme3.scene.Node headNode;
    private AbstractControl keyControl;
    private AbstractKeyAction keyAction;
    private Node bodyNode;
    private AnimControl bodyAnimControl;
    private AnimControl headAnimControl;
    private AnimChannel bodyAnimChannel;
    private AnimChannel headAnimChannel;
    private String animationName = "position";

    public AbstractPlayer(SimpleApplication app, String name, String location) {
        setName(name);
        setLocation(location);
        setApp(app);
        assetManager = this.getApp().getAssetManager();
        setStateManager(this.getApp().getStateManager());
        rootNode = this.getApp().getRootNode();
        inputManager = this.getApp().getInputManager();
        loadPlayer();
        initAnimInstances();
    }

    private void loadPlayer() {
        setPlayerNode((Node) getAssetManager().loadModel(getLocation()));
        getPlayerNode().setLocalTranslation(new Vector3f(0, 1, 0));
        setBetterCharacterControl(new BetterCharacterControl(1f, 2f, 1f));
        getBetterCharacterControl().setGravity(new Vector3f(0, -10, 0));
        getPlayerNode().addControl(getBetterCharacterControl());
        getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(getBetterCharacterControl());
        getRootNode().attachChild(getPlayerNode());
    }

    private void initAnimInstances() {
        setBodyNode((Node) getPlayerNode().getChild("Body"));
        setHeadNode((Node) getPlayerNode().getChild("Head"));

        setBodyAnimControl(getBodyNode().getControl(AnimControl.class));
        setHeadAnimControl(getHeadNode().getControl(AnimControl.class));

        getBodyAnimControl().addListener(this);
        getHeadAnimControl().addListener(this);

        setBodyAnimChannel(getBodyAnimControl().createChannel());
        setHeadAnimChannel(getHeadAnimControl().createChannel());

        getBodyAnimChannel().setAnim(getAnimationName());
        getHeadAnimChannel().setAnim(getAnimationName());
    }

    @Override
    public void update (float tpf) {
        setKeysActions();
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
        setAnimation(getHeadAnimChannel(), getAnimationName());
    }

    private void setAnimation(AnimChannel animationChannel, String animationName) {
        if (!animationChannel.getAnimationName().equals(animationName)) {
            animationChannel.setAnim(animationName);
        }
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

//    TODO: naprawić problem z rotacjami
    public void lookAt(Vector3f direction) {
        Node bodyNode = (Node) getPlayerNode().getChild("Body");
        bodyNode.lookAt(new Vector3f(direction), bodyNode.getWorldTranslation());
    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

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

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
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

    public AnimControl getHeadAnimControl() {
        return headAnimControl;
    }

    public void setHeadAnimControl(AnimControl headAnimControl) {
        this.headAnimControl = headAnimControl;
    }

    public AnimChannel getBodyAnimChannel() {
        return bodyAnimChannel;
    }

    public void setBodyAnimChannel(AnimChannel bodyAnimChannel) {
        this.bodyAnimChannel = bodyAnimChannel;
    }

    public AnimChannel getHeadAnimChannel() {
        return headAnimChannel;
    }

    public void setHeadAnimChannel(AnimChannel headAnimChannel) {
        this.headAnimChannel = headAnimChannel;
    }

    public String getAnimationName() {
        return animationName;
    }

    public void setAnimationName(String animationName) {
        this.animationName = animationName;
    }
}
