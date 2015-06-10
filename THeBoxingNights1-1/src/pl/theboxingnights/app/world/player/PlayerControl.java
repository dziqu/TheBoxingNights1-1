package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.input.controls.ActionListener;
import pl.theboxingnights.app.world.UserPlayer;

/**
 * Created by filip / 10.06.15 / 10:27
 */
public class PlayerControl {

    private UserPlayer userPlayer;
    private int controlNumber;
    private Controls playerControl;

    public PlayerControl(UserPlayer userPlayer, int controlNumber) {
        this.userPlayer = userPlayer;
        initControlNumber(controlNumber);
        initControl();
    }

    private void initControlNumber(int controlNumber) {
        if (controlNumber > 1 || controlNumber < 0) this.controlNumber = 0;
        else this.controlNumber = controlNumber;
    }

    private void initControl() {
        if (controlNumber == 0)  {
            playerControl = new FirstControl(userPlayer.getApp());
        }
        else if (controlNumber == 1) {
            playerControl = new SecondControl();
        }
        else {
            playerControl = null;
            try {
                throw new Exception("Incorrect control number");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void up() {

    }
}
