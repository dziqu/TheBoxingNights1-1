package pl.theboxingnights.app.sceneObjects;

import com.jme3.math.Vector3f;

/**
 * Created by filip / 07.06.15 / 13:38
 */
public abstract class ComputerPlayer extends SceneObjectDecorator {

    private String name;
    private Vector3f location;
    private float scale;
    private float stenght;
    private float speed;
    private float life;
    private float stamina;
    private final float maxStrenght = 10;
    private final float maxSpeed = 1;
    private final float maxLife = 100;
    private final float maxStamina = 100;

    public ComputerPlayer() {}

    public ComputerPlayer(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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

    public float getMaxStamina() {
        return maxStamina;
    }

    public float getMaxStrenght() {
        return maxStrenght;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }
}
