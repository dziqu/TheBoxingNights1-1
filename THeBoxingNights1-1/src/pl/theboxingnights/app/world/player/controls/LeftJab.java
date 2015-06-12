package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 12.06.15 / 11:16
 */
public class LeftJab extends AbstractKeyAction {
    public LeftJab(AbstractPlayer player) {
        super(player);
    }

    @Override
    public Vector3f getWalkDirection() {
        Node opponentNode = getPlayer().getOpponent().getPlayerNode();
        AbstractPlayer opponent = getPlayer().getOpponent();

        float x = opponent.getLocationAtTheScene().getX();
        float y = opponentNode.getWorldTranslation().getY();
        float z = opponentNode.getWorldTranslation().getZ();

        float myX = getPlayer().getPlayerNode().getWorldTranslation().getX();
        float myZ = getPlayer().getPlayerNode().getWorldTranslation().getZ();

        float distX = myX - x;
        float distZ = myZ - z;

        float doubleDistX = distX * distX;
        float doubleDistZ = distZ * distZ;

        float dist = (float) Math.sqrt(doubleDistX + doubleDistZ);

        float speed = 4f;
        float speedRatio = speed / dist;

        Vector3f dirVector = new Vector3f(distX * speedRatio, y, distZ * speedRatio).negate();
        dirVector = new Vector3f(dirVector.getX(), y, dirVector.getZ());

        return null;
    }

    @Override
    public Quaternion getRotation() {
        return new Quaternion().fromAngles(0, 1f, 0);
    }
}
