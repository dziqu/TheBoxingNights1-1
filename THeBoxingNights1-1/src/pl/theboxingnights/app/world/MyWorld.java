package pl.theboxingnights.app.world;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.FlyByCamera;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.plugins.blender.BlenderModelLoader;
import pl.theboxingnights.app.world.player.FirstControl;
import pl.theboxingnights.app.world.player.SecondControl;

/**
 * Created by filip / 07.06.15 / 18:25
 */
public class MyWorld extends AbstractAppState {


    private SimpleApplication app;
    private AppStateManager stateManager;
    private AssetManager assetManager;
    private WorldObject scene;
    private AbstractPlayer player1;
    private AbstractPlayer player2;
    private BulletAppState bulletAppState;
    private com.jme3.scene.Node rootNode;
    private FlyByCamera flyCam;
    private Camera cam;
    private Geometry cube1Geo;
    private RigidBodyControl rbc;

    public MyWorld() {

    }

    @Override
    public void initialize (AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.setApp((SimpleApplication) app);
        this.setStateManager(stateManager);
        setAssetManager(this.getApp().getAssetManager());
        setBulletAppState(new BulletAppState());
        setRootNode(this.getApp().getRootNode());

        setCam(this.getApp().getCamera());
        getCam().setLocation(new Vector3f(.5043195f, 21.533813f, 18.173557f));
        getCam().setRotation(new Quaternion().set(6.101522E-4f, 0.90909696f, -0.41658196f, 0.0013310789f));

        setFlyCam(this.getApp().getFlyByCamera());
        getFlyCam().setEnabled(false);

        setBulletAppState(new BulletAppState());
        stateManager.attach(getBulletAppState());
        getBulletAppState().setDebugEnabled(true);
        getAssetManager().registerLoader(BlenderModelLoader.class, "blend");

        setScene(new Scene(this.getApp(), "ring" + "Scene", "pl/theboxingnights/app/assets/models/scene/ring/ring.blend"));

        setPlayer1(new UserPlayer(this.getApp(), "Antek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend"));
        getPlayer1().setScale(.4f);
        getPlayer1().setLocalTranslation(new Vector3f(9, 5, 9));
        getPlayer1().setKeyControl(new FirstControl(this.getApp()));

        setPlayer2(new UserPlayer(this.getApp(), "Zenek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend"));
        getPlayer2().setScale(.4f);
        getPlayer2().setLocalTranslation(new Vector3f(-9, 5, -9));
        getPlayer2().setKeyControl(new SecondControl(this.getApp()));

        getPlayer1().setOpponent(getPlayer2());
        getPlayer2().setOpponent(getPlayer1());

    }

    @Override
    public void update(float tpf) {
        getPlayer1().update(tpf);
        getPlayer2().update(tpf);
    }

    public BulletAppState getBulletAppState() {
        return bulletAppState;
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

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public WorldObject getScene() {
        return scene;
    }

    public void setScene(WorldObject scene) {
        this.scene = scene;
    }

    public AbstractPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(AbstractPlayer player1) {
        this.player1 = player1;
    }

    public AbstractPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(AbstractPlayer player2) {
        this.player2 = player2;
    }

    public void setBulletAppState(BulletAppState bulletAppState) {
        this.bulletAppState = bulletAppState;
    }

    public com.jme3.scene.Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(com.jme3.scene.Node rootNode) {
        this.rootNode = rootNode;
    }

    public FlyByCamera getFlyCam() {
        return flyCam;
    }

    public void setFlyCam(FlyByCamera flyCam) {
        this.flyCam = flyCam;
    }

    public Camera getCam() {
        return cam;
    }

    public void setCam(Camera cam) {
        this.cam = cam;
    }

    public Geometry getCube1Geo() {
        return cube1Geo;
    }

    public void setCube1Geo(Geometry cube1Geo) {
        this.cube1Geo = cube1Geo;
    }

    public RigidBodyControl getRbc() {
        return rbc;
    }

    public void setRbc(RigidBodyControl rbc) {
        this.rbc = rbc;
    }
}
