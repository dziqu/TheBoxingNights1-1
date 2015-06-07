package pl.theboxingnights.app.sceneObjects;

import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 13:28
 */
public class NormalPlayerDecorator extends SceneObjectDecorator {

    private String name;
    private Vector3f location;
    private float scale;
    private float stenght;
    private float speed;
    private float life;
    private float stamina;
    private final float maxLife = 100;
    private final float minLife = 0;
    private final float maxStamina = 100;


    public NormalPlayerDecorator(SceneObject sceneObject) {
        this.sceneObject = sceneObject;
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

    public float getStenght() {
        return stenght;
    }

    public void setStenght(float stenght) {
        this.stenght = stenght;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getStamina() {
        return stamina;
    }

    public void setStamina(float stamina) {
        this.stamina = stamina;
    }

    public float getMaxLife() {
        return maxLife;
    }

    public float getMinLife() {
        return minLife;
    }

    public float getMaxStamina() {
        return maxStamina;
    }
}
