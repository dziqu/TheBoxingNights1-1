package pl.theboxingnights.app.world;

import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 18:46
 */
public interface WorldObject {

    String getLocation();

    void setLocation(String location);

    void setLocalTranslation(Vector3f locationAtTheScene);

    void setScale(float scale);

}
