package pl.theboxingnights.app.sceneObjects;

/**
 * Created by filip / 07.06.15 / 13:41
 */
public class ComputerPlayerLvl1 extends ComputerPlayer {

    private Level level;

    public ComputerPlayerLvl1(String name) {
        super(name);
        level = new Level1();
        setFields();
    }

    private void setFields() {
        setLife(level.getMaxLife());
        setSpeed(level.getMaxSpeed());
        setStamina(level.getMaxStamina());
        setStenght(level.getMaxStrength());
    }

}
