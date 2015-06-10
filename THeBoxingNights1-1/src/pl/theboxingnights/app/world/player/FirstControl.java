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
        setLeftKeyValue         (KeyInput.KEY_A);
        setRightKeyValue        (KeyInput.KEY_D);
        setUpKeyValue           (KeyInput.KEY_W);
        setDownKeyValue         (KeyInput.KEY_S);
        setLeftJabKeyValue      (KeyInput.KEY_Q);
        setRightJabKeyValue     (KeyInput.KEY_E);
        setLeftHookKeyValue     (KeyInput.KEY_Z);
        setRightHookKeyValue    (KeyInput.KEY_C);
        setLeftUppercutKeyValue (KeyInput.KEY_R);
        setRightUppercutKeyValue(KeyInput.KEY_F);
        setGuardKeyValue        (KeyInput.KEY_SPACE);
        setPositionKeyValue     (KeyInput.KEY_X);
    }

    @Override
    public void initClassName() {
        setClassName(FirstControl.class.getName());
    }
}
