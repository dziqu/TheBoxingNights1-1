package pl.theboxingnights.app.world.player;

import com.jme3.animation.SkeletonControl;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 11.06.15 / 20:55
 */
public class PlayerBuilder {

    private final AbstractPlayer player;
    private final AssetManager assetManager;
    private final BulletAppState bulletAppState;
    private Geometry leftGloveGeo;
    private Geometry rightGloveGeo;
    private Geometry headGeo;
    private SkeletonControl skeletonControl;
    private Node headBone;
    private Node leftHandBone;
    private Node rightHandBone;
    private GhostControl leftHandGhostControl;
    private GhostControl headGhostControl;
    private GhostControl rightHandGhostControl;

    public PlayerBuilder(AbstractPlayer player) {
        this.player = player;
        SimpleApplication app = player.getApp();
        assetManager = app.getAssetManager();
        AppStateManager stateManger = app.getStateManager();
        bulletAppState = stateManger.getState(BulletAppState.class);

        initSkeletonControl();
        initGhostControls();
        buildBoxingGloves();
        buildBoxingHelmet();
        getBones();
        addBoxingItemsToBody();
        addGhostControlsToBoxingItems();
        addGhostControlsToBulletAppState();
    }

    public void initSkeletonControl() {
        skeletonControl = player.getPlayerNode().getChild("Body").getControl(SkeletonControl.class);
    }

    public void initGhostControls() {
        leftHandGhostControl = new GhostControl(new BoxCollisionShape(new Vector3f(.3f, .2f, .7f)));
        rightHandGhostControl = new GhostControl(new BoxCollisionShape(new Vector3f(.3f, .2f, .5f)));
        headGhostControl = new GhostControl(new BoxCollisionShape(new Vector3f(.6f, .6f, 1f)));
    }

    public void buildBoxingGloves() {
        Box cube1Mesh = new Box( .6f,.5f,1f);
        leftGloveGeo = new Geometry("My Textured Box", cube1Mesh);
        leftGloveGeo.setLocalTranslation(new Vector3f(leftGloveGeo.getLocalTranslation().getX(), leftGloveGeo.getLocalTranslation().getY(), leftGloveGeo.getLocalTranslation().getZ() - 2f));
        leftGloveGeo.setName("leftGloveGeo");
        Material cube1Mat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        cube1Mat.setColor("Color", ColorRGBA.Red);
        leftGloveGeo.setMaterial(cube1Mat);

        rightGloveGeo = new Geometry("My Textured Box", cube1Mesh);
        rightGloveGeo.setLocalTranslation(new Vector3f(rightGloveGeo.getLocalTranslation().getX(), rightGloveGeo.getLocalTranslation().getY(), rightGloveGeo.getLocalTranslation().getZ() - 2f));
        rightGloveGeo.setName("rightGloveGeo");
        Material cube1Mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        cube1Mat2.setColor("Color", ColorRGBA.Red);
        rightGloveGeo.setMaterial(cube1Mat2);
    }

    public void buildBoxingHelmet() {
        Box cube1Mesh = new Box( 1.3f,1f,1.2f);
        headGeo = new Geometry("My Textured Box", cube1Mesh);
        headGeo.setLocalTranslation(new Vector3f(headGeo.getLocalTranslation().getX(), headGeo.getLocalTranslation().getY(), headGeo.getLocalTranslation().getZ() - 2f));
        headGeo.setName("headGeo");
        Material headMat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        headMat.setColor("Color", ColorRGBA.Red);
        headGeo.setMaterial(headMat);
    }

    public void getBones() {
        leftHandBone = skeletonControl.getAttachmentsNode("Forearm.L");
        rightHandBone = skeletonControl.getAttachmentsNode("Forearm.R");
        headBone = skeletonControl.getAttachmentsNode("Head");
    }

    public void addBoxingItemsToBody() {
        leftHandBone.attachChild(leftGloveGeo);
        rightHandBone.attachChild(rightGloveGeo);
        headBone.attachChild(headGeo);
    }

    public void addGhostControlsToBoxingItems() {
        leftGloveGeo.addControl(leftHandGhostControl);
        rightGloveGeo.addControl(rightHandGhostControl);
        headGeo.addControl(headGhostControl);
    }

    public void addGhostControlsToBulletAppState() {
        bulletAppState.getPhysicsSpace().add(leftHandGhostControl);
        bulletAppState.getPhysicsSpace().add(rightHandGhostControl);
        bulletAppState.getPhysicsSpace().add(headGhostControl);
    }
}
