package pl.theboxingnights.app.sceneObjects;

import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 13:17
 */
public class Scene implements SceneObject {

    private String name;
    private Vector3f location;
    private float scale;

    public Scene() {}

    public Scene(String name) {
        this.setName(name);
    }

    public Scene(String name, Vector3f location) {
        this.setName(name);
        this.setLocation(location);
    }

    public Scene(String name, Vector3f location, float scale) {
        this.setName(name);
        this.setLocation(location);
        this.setScale(scale);
    }

    @Override
    public Vector3f getLocation() {
        return location;
    }

    @Override
    public void setLocation(Vector3f location) {
        this.location = location;
    }

    @Override
    public float getScale() {
        return scale;
    }

    @Override
    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
