package pl.theboxingnights.app.world;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.GhostControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer implements PlayerWorldObject {

    private SimpleApplication app;
    private AppStateManager stateManager;
    private Node playerNode;
    private String name;
    private String location;
    private Vector3f locationAtTheScene;
    private float scale;
    private BetterCharacterControl betterCharacterControl;
    private GhostControl ghostControl;

    public AbstractPlayer(SimpleApplication app, String name, String location) {
        setName(name);
        setLocation(location);
        setApp(app);
        load();
    }

    private void load() {
        setPlayerNode((Node) app.getAssetManager().loadModel(location));
        betterCharacterControl = new BetterCharacterControl(1f, 4f, 1f);
        getPlayerNode().addControl(betterCharacterControl);
        app.getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(betterCharacterControl);
        app.getRootNode().attachChild(getPlayerNode());
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
