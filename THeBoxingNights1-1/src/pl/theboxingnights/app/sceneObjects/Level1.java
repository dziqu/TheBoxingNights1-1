package pl.theboxingnights.app.sceneObjects;

/**
 * Created by filip / 07.06.15 / 13:49
 */
public class Level1 implements Level {
    private final float maxStrenght = 10;
    private final float maxSpeed = 1;
    private final float maxLife = 100;
    private final float maxStamina = 100;


    public float getMaxStrength() {
        return maxStrenght;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getMaxLife() {
        return maxLife;
    }

    public float getMaxStamina() {
        return maxStamina;
    }
}
