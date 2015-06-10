package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:11
 */
public abstract class AbstractKeyAction implements KeyAction {

    private AbstractPlayer player = null;
    private Node playerNode;
    private Node bodyNode;
    private Node headNode;
    private AnimControl bodyAnimControl;
    private AnimControl headAnimControl;
    private AnimChannel bodyAnimChannel;
    private AnimChannel headAnimChannel;
    private String animationName = "position";

    public AbstractKeyAction(AbstractPlayer player) {
        this.setPlayer(player);
    }

    public void make() {
        getPlayer().getBetterCharacterControl().setWalkDirection(getWalkDirection());
    }

    public AbstractPlayer getPlayer() {
        return player;
    }

    public abstract Vector3f getWalkDirection();

    public void setPlayer(AbstractPlayer player) {
        this.player = player;
    }

    public Node getPlayerNode() {
        return playerNode;
    }

    public void setPlayerNode(Node playerNode) {
        this.playerNode = playerNode;
    }

    public Node getBodyNode() {
        return bodyNode;
    }

    public void setBodyNode(Node bodyNode) {
        this.bodyNode = bodyNode;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public AnimControl getBodyAnimControl() {
        return bodyAnimControl;
    }

    public void setBodyAnimControl(AnimControl bodyAnimControl) {
        this.bodyAnimControl = bodyAnimControl;
    }

    public AnimControl getHeadAnimControl() {
        return headAnimControl;
    }

    public void setHeadAnimControl(AnimControl headAnimControl) {
        this.headAnimControl = headAnimControl;
    }

    public AnimChannel getBodyAnimChannel() {
        return bodyAnimChannel;
    }

    public void setBodyAnimChannel(AnimChannel bodyAnimChannel) {
        this.bodyAnimChannel = bodyAnimChannel;
    }

    public AnimChannel getHeadAnimChannel() {
        return headAnimChannel;
    }

    public void setHeadAnimChannel(AnimChannel headAnimChannel) {
        this.headAnimChannel = headAnimChannel;
    }

    public String getAnimationName() {
        return animationName;
    }

    public void setAnimationName(String animationName) {
        this.animationName = animationName;
    }
}
