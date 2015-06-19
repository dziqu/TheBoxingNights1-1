package pl.theboxingnights.app.clientServer.world;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.FlyByCamera;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
import pl.theboxingnights.app.world.AbstractPlayer;
import pl.theboxingnights.app.world.Scene;
import pl.theboxingnights.app.world.UserPlayer;
import pl.theboxingnights.app.world.WorldObject;
import pl.theboxingnights.app.world.player.FirstControl;
import pl.theboxingnights.app.world.player.SecondControl;

/**
 * Created by filip / 19.06.15 / 05:20
 */
public class MultiplayerWorld extends AbstractAppState {

    private final SimpleApplication app;
    private final AssetManager assetManager;
    private final Node rootNode;
    private final AppStateManager stateManager;
    private final FlyByCamera flyCam;
    private final BulletAppState bulletAppState;
    private final WorldObject scene;
    private final AbstractPlayer player1;
    private final AbstractPlayer player2;


    public MultiplayerWorld(SimpleApplication app) {
        this.app = app;
        this.assetManager = this.app.getAssetManager();
        this.rootNode = this.app.getRootNode();
        this.stateManager = this.app.getStateManager();
        this.flyCam = this.app.getFlyByCamera();
        bulletAppState = new BulletAppState();

        stateManager.attach(bulletAppState);
        flyCam.setMoveSpeed(60f);

        scene = new Scene(this.app, "ring" + "Scene", "pl/theboxingnights/app/assets/models/scene/ring/ring.blend");

        player1 = new UserPlayer(this.app, "Antek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend");
        player1.setScale(.4f);
        player1.setLocalTranslation(new Vector3f(9, 1, 9));
        player1.setKeyControl(new FirstControl(this.app));

        player2 = new UserPlayer(this.app, "Zenek" + "Player", "pl/theboxingnights/app/assets/models/player/greenPlayerArmature+Body+GhostControlCubes.blend");
        player2.setScale(.4f);
        player2.setLocalTranslation(new Vector3f(-9, 1, -9));
        player2.setKeyControl(new SecondControl(this.app));

        player1.setOpponent(player2);
        player2.setOpponent(player1);
    }

    public AbstractPlayer getPlayer(String playerInstanceName) {
        AbstractPlayer playerToReturn = null;
        if (playerInstanceName.compareTo("player1") == 0) {
            playerToReturn = player1;
        }
        if (playerInstanceName.compareTo("player2") == 0) {
            playerToReturn = player2;
        }

        return playerToReturn;
    }

}
