package pl.theboxingnights.app.world;

import com.jme3.animation.*;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import pl.theboxingnights.app.other.*;
import pl.theboxingnights.app.world.player.AbstractControl;
import pl.theboxingnights.app.world.player.AnimationsNames;
import pl.theboxingnights.app.world.player.PlayerBuilder;
import pl.theboxingnights.app.world.player.controls.*;

import java.lang.Math;

/**
 * Created by filip / 08.06.15 / 03:45
 */
public abstract class AbstractPlayer extends AbstractAppState implements WorldObject, AnimEventListener, PhysicsTickListener {

    private final AssetManager assetManager;
    private final com.jme3.scene.Node rootNode;
    private final SimpleApplication app;
    private final AppStateManager stateManager;
    private com.jme3.scene.Node playerNode;
    private String name;
    private String location;
    private BetterCharacterControl betterCharacterControl;
    private AbstractControl keyControl;
    private AbstractKeyAction keyAction;
    private Node bodyNode;
    private AnimControl bodyAnimControl;
    private AnimChannel bodyAnimChannel;
    private String animationName = "position";
    private AbstractPlayer opponent;
    private int points = 0;

    public AbstractPlayer(SimpleApplication app, String name, String location) {
        this.app = app;
        this.setName(name);
        this.setLocation(location);
        assetManager = this.getApp().getAssetManager();
        stateManager = this.getApp().getStateManager();
        rootNode = this.getApp().getRootNode();
        loadPlayer();
        initAnimInstances();

        new PlayerBuilder(this);
    }

    private void loadPlayer() {
        setPlayerNode((Node) getAssetManager().loadModel(getLocation()));
        getPlayerNode().setLocalTranslation(new Vector3f(0, 1, 0));
        setBetterCharacterControl(new BetterCharacterControl(.5f, 3f, 1f));
        getBetterCharacterControl().setGravity(new Vector3f(0, -10, 0));
        getPlayerNode().addControl(getBetterCharacterControl());
        getStateManager().getState(BulletAppState.class).getPhysicsSpace().add(getBetterCharacterControl());
        getRootNode().attachChild(getPlayerNode());
    }

    private void initAnimInstances() {
        setBodyNode((Node) getPlayerNode().getChild("Body"));
        setBodyAnimControl(getBodyNode().getControl(AnimControl.class));

        getBodyAnimControl().addListener(this);

        setBodyAnimChannel(getBodyAnimControl().createChannel());
        getBodyAnimChannel().setAnim(getAnimationName());
    }

    @Override
    public void update (float tpf) {
        setKeysActionsAndAnimations();
        lookAt(getOpponent().getPlayerNode().getWorldTranslation());
        checkCollisions();
    }

    private void setKeysActionsAndAnimations() {
        setKeyAction(null);
        setAnimationName(null);
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
        } else if (getKeyControl().isLeftJabKey()) {
            setKeyAction(new LeftJab(this));
            setAnimationName(AnimationsNames.getLeftJabAnimationName());
        } else if (getKeyControl().isRightJabKey()) {
            setKeyAction(new RightJab(this));
            setAnimationName(AnimationsNames.getRightJabAnimationName());
        } else if (getKeyControl().isLeftHookKey()) {
            setKeyAction(new LeftHook(this));
            setAnimationName(AnimationsNames.getLeftHookAnimationName());
        } else if (getKeyControl().isRightHookKey()) {
            setKeyAction(new RightHook(this));
            setAnimationName(AnimationsNames.getRightHookAnimationName());
        } else if (getKeyControl().isLeftUppercutKey()) {
            setKeyAction(new LeftUppercut(this));
            setAnimationName(AnimationsNames.getLeftUppercutAnimationName());
        } else if (getKeyControl().isRightUppercutKey()) {
            setKeyAction(new RightUppercut(this));
            setAnimationName(AnimationsNames.getRightUppercutAnimationName());
        } else {
            setKeyAction(new Position(this));
            setAnimationName(AnimationsNames.getPositionAnimationName());
        }
        if (getKeyAction()  != null) getKeyAction().make();
        if (getAnimationName() != null) setAnimation(getBodyAnimChannel(), getAnimationName());
    }

    private void setAnimation(AnimChannel animationChannel, String animationName) {
        if (!animationChannel.getAnimationName().equals(animationName)) {
            animationChannel.setAnim(animationName);
        }
    }

    private void checkCollisions() {
        CollisionResults results = new CollisionResults();
        Spatial node1 = getPlayerNode().getChild("leftGloveGeo");
        Spatial node2 = getOpponent().getPlayerNode().getChild("headGeo");
        node1.collideWith(node2.getWorldBound(), results);
        if (results.size() > 0) {
            if (getAnimationName().compareTo(AnimationsNames.getLeftJabAnimationName()) == 0) {
                setPoints(getPoints() + 1);
                System.out.println(getName() + ": " + getPoints());
            }
        }
    }

    public SimpleApplication getApp() {
        return app;
    }

    public AppStateManager getStateManager() {
        return stateManager;
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
    public void setLocalTranslation(Vector3f locationAtTheScene) {
        getPlayerNode().getControl(BetterCharacterControl.class).warp(locationAtTheScene);
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

    public void lookAt(Vector3f direction) {
        setBodyNode((Node) getPlayerNode().getChild("Body"));

        float xDistance = Calculator.calculate((x,y)->x-y, getPlayerNode().getWorldTranslation().getX(),  getOpponent().getPlayerNode().getWorldTranslation().getX() );
        float zDistance = Calculator.calculate((x, y) -> x-y, getPlayerNode().getWorldTranslation().getZ(),getOpponent().getPlayerNode().getWorldTranslation().getZ() );
        float maxDifference = 6.0f;
        float denominator = 1.8f;
        float difference = Calculator.calculate((x, y)->x+y, xDistance, zDistance);
        if (difference < 0) difference *= -1;
        difference = (float) Math.sqrt(difference);
        getBodyNode().lookAt(new Vector3f(direction.getX(), Calculator.calculate((x, y) -> x/y, (maxDifference - difference), denominator), direction.getZ()), Vector3f.UNIT_Y);
        getBodyNode().rotate(0, 3.2f, 0);
    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void prePhysicsTick(PhysicsSpace space, float tpf){

    }
    @Override
    public void physicsTick(PhysicsSpace space, float tpf){

    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public AbstractControl getKeyControl() {
        return keyControl;
    }

    public void setKeyControl(AbstractControl keyControl) {
        this.keyControl = keyControl;
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

    public AnimChannel getBodyAnimChannel() {
        return bodyAnimChannel;
    }

    public void setBodyAnimChannel(AnimChannel bodyAnimChannel) {
        this.bodyAnimChannel = bodyAnimChannel;
    }

    public String getAnimationName() {
        return animationName;
    }

    public void setAnimationName(String animationName) {
        this.animationName = animationName;
    }

    public AbstractPlayer getOpponent() {
        return opponent;
    }

    public void setOpponent(AbstractPlayer opponent) {
        this.opponent = opponent;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
