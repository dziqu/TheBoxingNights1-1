package pl.theboxingnights.app.world;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.control.Control;

/**
 * Created by filip / 07.06.15 / 18:46
 */
public abstract class AbstractScene extends AbstractAppState implements WorldObject {

    private SimpleApplication app;
    private AppStateManager stateManager;
    private Node sceneNode;
    private String name;
    private String location;
    private RigidBodyControl rigidBodyControl;

    public AbstractScene(SimpleApplication app, String name, String location) {
        setName(name);
        setLocation(location);
        setApp(app);
        load();
    }

    private void load() {
        setSceneNode(loadModel());
        getSceneNode().setName(getName());
        setRigidBodyControl(new RigidBodyControl((0f)));
        addControl(getRigidBodyControl());
        setStateManager(getApp().getStateManager());
        getBulletAppState().getPhysicsSpace().add(getRigidBodyControl());
        getRootNode().attachChild(getSceneNode());
    }

    private BulletAppState getBulletAppState() {
        return getStateManager().getState(BulletAppState.class);
    }

    private void addControl(Control control) {
        getSceneNode().addControl(control);
    }

    private Node loadModel() {
        return (Node) getAssetManager().loadModel(getLocation());
    }

    private AssetManager getAssetManager() {
        return getApp().getAssetManager();
    }

    private Node getRootNode() {
        return getApp().getRootNode();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLocalTranslation(Vector3f locationAtTheScene) {
    }

    public void setScale(float scale) {
    }

    public RigidBodyControl getRigidBodyControl() {
        return rigidBodyControl;
    }

    public void setRigidBodyControl(RigidBodyControl rigidBodyControl) {
        this.rigidBodyControl = rigidBodyControl;
    }

    public Node getSceneNode() {
        return sceneNode;
    }

    public void setSceneNode(Node sceneNode) {
        this.sceneNode = sceneNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
