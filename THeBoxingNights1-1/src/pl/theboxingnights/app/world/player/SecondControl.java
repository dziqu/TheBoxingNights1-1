package pl.theboxingnights.app.world.player;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;

/**
 * Created by filip / 10.06.15 / 10:36
 */
public class SecondControl extends AbstractControl {
    public SecondControl(SimpleApplication app) {
        super(app);

    }

    @Override
    public void initKeysValues() {
        setLeftKeyValue         (KeyInput.KEY_LEFT);
        setRightKeyValue        (KeyInput.KEY_RIGHT);
        setUpKeyValue           (KeyInput.KEY_UP);
        setDownKeyValue         (KeyInput.KEY_DOWN);
        setLeftJabKeyValue      (KeyInput.KEY_NUMPAD8);
        setRightJabKeyValue     (KeyInput.KEY_NUMPAD9);
        setLeftHookKeyValue     (KeyInput.KEY_NUMPAD5);
        setRightHookKeyValue    (KeyInput.KEY_NUMPAD6);
        setLeftUppercutKeyValue (KeyInput.KEY_NUMPAD2);
        setRightUppercutKeyValue(KeyInput.KEY_NUMPAD3);
        setGuardKeyValue        (KeyInput.KEY_NUMPAD0);
        setPositionKeyValue     (KeyInput.KEY_NUMPAD1);
    }

    @Override
    public void initClassName() {
        setClassName(SecondControl.class.getName());
    }
}
