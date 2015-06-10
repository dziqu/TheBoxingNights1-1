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
    private final Camera cam;
    private final FlyByCamera flyCam;
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
        assetManager = this.app.getAssetManager();
        stateManager = this.app.getStateManager();
        rootNode = this.app.getRootNode();
        inputManager = this.app.getInputManager();
        cam = this.app.getCamera();
        flyCam = this.app.getFlyByCamera();
        loadPlayer();
        initAnimInstances();
    }

    private void loadPlayer() {
        playerNode = (com.jme3.scene.Node) assetManager.loadModel(location);
        playerNode.setLocalTranslation(new Vector3f(0, 1, 0));
        betterCharacterControl = new BetterCharacterControl(0.5f, 1f, 1f);
        playerNode.addControl(betterCharacterControl);
        stateManager.getState(BulletAppState.class).getPhysicsSpace().add(betterCharacterControl);
        rootNode.attachChild(playerNode);
    }

    private void initAnimInstances() {
        bodyNode = (Node) playerNode.getChild("Body");
        headNode = (Node) playerNode.getChild("Head");

        bodyAnimControl = bodyNode.getControl(AnimControl.class);
        headAnimControl = headNode.getControl(AnimControl.class);

        bodyAnimControl.addListener(this);
        headAnimControl.addListener(this);

        bodyAnimChannel = bodyAnimControl.createChannel();
        headAnimChannel = headAnimControl.createChannel();

        bodyAnimChannel.setAnim(animationName);
        headAnimChannel.setAnim(animationName);

    }

    @Override
    public void update (float tpf) {
        setKeysActions();
    }

    private void setKeysActions() {
        keyAction = null;
        if (keyControl.isUpKey()) {
            keyAction = new Up(this);
            this.animationName = "step";
        }
        else {
            keyAction = new Position(this);
            this.animationName = "position";
        }
        keyAction.make();
        setAnimation(bodyAnimChannel, animationName);
        setAnimation(headAnimChannel, animationName);
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

    public void setKeyControl(AbstractControl keyControl) {
        this.keyControl = keyControl;
    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

    }
}
