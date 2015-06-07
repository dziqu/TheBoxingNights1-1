package pl.theboxingnights.app.world;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.scene.plugins.blender.BlenderModelLoader;

/**
 * Created by filip / 07.06.15 / 18:25
 */
public class MyWorld extends AbstractAppState {


    private SimpleApplication app;
    private AppStateManager stateManager;
    private AssetManager assetManager;
    private WorldObject scene;

    @Override
    public void initialize (AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.stateManager = stateManager;
        assetManager = this.app.getAssetManager();
        stateManager.attach(new BulletAppState());
        assetManager.registerLoader(BlenderModelLoader.class, "blend");
        scene = new Scene(this.app, "ring", "pl/theboxingnights/app/assets/models/scene/ring/ring.blend");
    }

    public BulletAppState getBulletAppState() {
        return stateManager.getState(BulletAppState.class);
    }

    @Override
    public void update(float tpf) {

    }

}
