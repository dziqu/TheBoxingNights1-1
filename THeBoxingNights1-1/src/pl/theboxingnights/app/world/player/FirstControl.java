package pl.theboxingnights.app.world.player;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;

/**
 * Created by filip / 10.06.15 / 10:36
 */
public class FirstControl extends AbstractControl {

    public FirstControl(SimpleApplication app) {
        super(app);
    }

    @Override
    public void initKeysValues() {
        setLeftKey(KeyInput.KEY_A);
        setRightKey(KeyInput.KEY_D);
        setUpKey(KeyInput.KEY_W);
        setDownKey(KeyInput.KEY_S);
        setLeftJabKey(KeyInput.KEY_Q);
        setRightJabKey(KeyInput.KEY_E);
        setLeftHookKey(KeyInput.KEY_Z);
        setRightHookKey(KeyInput.KEY_C);
        setLeftUppercutKey(KeyInput.KEY_R);
        setRightUppercutKey(KeyInput.KEY_F);
        setGuardKey(KeyInput.KEY_SPACE);
    }
}
