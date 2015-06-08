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
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer extends AbstractAppState implements WorldObject {

    private final AssetManager assetManager;
    private final Node rootNode;
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
        load();
        initGhostControl();
        initAnimations();
    }

    private void load() {
        playerNode = (Node) assetManager.loadModel(location);
        playerNode.setLocalTranslation(new Vector3f(0, 1, 0));
        betterCharacterControl = new BetterCharacterControl(0.5f, 4f, 1f);
        playerNode.addControl(betterCharacterControl);
        stateManager.getState(BulletAppState.class).getPhysicsSpace().add(betterCharacterControl);
        rootNode.attachChild(playerNode);
    }

    private void initGhostControl() {
        Node stomachNode = (Node) playerNode.getChild("Brzuch");
        System.out.println(stomachNode);
        GhostControl ghost = new GhostControl(
                new BoxCollisionShape(new Vector3f(2f, 2f, 2f)));
        stomachNode.addControl(ghost);
        stateManager.getState(BulletAppState.class).getPhysicsSpace().add(ghost);
    }

    private void initAnimations() {
        Node animNode = (Node) playerNode.getChild("Body");
        AnimControl animControl = animNode.getControl(AnimControl.class);
        System.out.println(animControl);
        AnimChannel animChannel = animControl.createChannel();
        animChannel.setAnim("pajacyk2");
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
