package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 10.06.15 / 15:01
 */
public interface KeyAction {

    public void make();

    public Vector3f getWalkDirection();

    public Quaternion getRotation();

}
