package pl.theboxingnights.app.world;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 18:46
 */
public interface WorldObject {

    public String getLocation();

    public void setLocation(String location);

    public Vector3f getLocationAtTheScene();

    public void setLocalTranslation(Vector3f locationAtTheScene);

    public float getScale();

    public void setScale(float scale);

}
