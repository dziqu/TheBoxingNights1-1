package pl.theboxingnights.app.sceneObjects;

import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 13:17
 */
public interface SceneObject {

    Vector3f getLocation();

    void setLocation(Vector3f location);

    float getScale();

    void setScale(float scale);

    String getName();

    void setName(String name);

}
