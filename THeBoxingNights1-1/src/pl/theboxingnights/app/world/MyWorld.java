package pl.theboxingnights.app.world;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.FlyByCamera;
import com.jme3.material.Material;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.plugins.blender.BlenderModelLoader;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
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
        this.app = (SimpleApplication) app;
        this.stateManager = stateManager;
        assetManager = this.app.getAssetManager();
        bulletAppState = new BulletAppState();
        rootNode = this.app.getRootNode();

        cam = this.app.getCamera();
        cam.setLocation(new Vector3f(.5043195f, 21.533813f, 18.173557f));
        cam.setRotation(new Quaternion().set(6.101522E-4f, 0.90909696f, -0.41658196f, 0.0013310789f));

        flyCam = this.app.getFlyByCamera();
        flyCam.setEnabled(false);

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(true);
        assetManager.registerLoader(BlenderModelLoader.class, "blend");

        scene = new Scene(this.app, "ring" + "Scene", "pl/theboxingnights/app/assets/models/scene/ring/ring.blend");

        player1 = new UserPlayer(this.app, "Antek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend");
        player1.setScale(.4f);
        player1.setLocalTranslation(new Vector3f(9, 5, 9));
        player1.setKeyControl(new FirstControl(this.app));

        player2 = new UserPlayer(this.app, "Zenek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend");
        player2.setScale(.4f);
        player2.setLocalTranslation(new Vector3f(-9, 5, -9));
        player2.setKeyControl(new SecondControl(this.app));

        player1.setOpponent(player2);
        player2.setOpponent(player1);

    }

    @Override
    public void update(float tpf) {
        player1.update(tpf);
        player2.update(tpf);
    }

    public BulletAppState getBulletAppState() {
        return stateManager.getState(BulletAppState.class);
    }

}
