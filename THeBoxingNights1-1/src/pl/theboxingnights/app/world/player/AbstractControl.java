package pl.theboxingnights.app.world.player;

import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;

/**
 * Created by filip / 10.06.15 / 11:03
 */
public abstract class AbstractControl implements Controls, ActionListener {

    private final SimpleApplication app;
    private String className;

    private String leftKeyName            = null;
    private String rightKeyName           = "right";
    private String upKeyName              = "up";
    private String downKeyName            = "down";
    private String leftJabKeyName         = "leftJab";
    private String rightJabKeyName        = "rightJab";
    private String leftHookKeyName        = "leftHook";
    private String rightHookKeyName       = "rightHook";
    private String leftUppercutKeyName    = "leftUppercut";
    private String rightUppercutKeyName   = "rightUppercut";
    private String guardKeyName           = "guard";
    private String positionKeyName        = "position";

    private int leftKeyValue            = 0;
    private int rightKeyValue           = 0;
    private int upKeyValue              = 0;
    private int downKeyValue            = 0;
    private int leftJabKeyValue         = 0;
    private int rightJabKeyValue        = 0;
    private int leftHookKeyValue        = 0;
    private int rightHookKeyValue       = 0;
    private int leftUppercutKeyValue    = 0;
    private int rightUppercutKeyValue   = 0;
    private int guardKeyValue           = 0;
    private int positionKeyValue        = 0;

    private boolean isLeftKey           = false;
    private boolean isRightKey          = false;
    private boolean isUpKey             = false;
    private boolean isDownKey           = false;
    private boolean isLeftJabKey        = false;
    private boolean isRightJabKey       = false;
    private boolean isLeftHookKey       = false;
    private boolean isRightHookKey      = false;
    private boolean isLeftUppercutKey   = false;
    private boolean isRightUppercutKey  = false;
    private boolean isGuardKey          = false;
    private boolean isPositionKey       = false;

    public AbstractControl(SimpleApplication app) {
        this.app = app;
        initClassName();
        initKeyNames();
        initKeysValues();
        initMapping();
        initActionListener();
    }

    @Override
    public void initKeyNames() {
        setLeftKeyName("leftKey" + getClassName());
        setRightKeyName("rightKey" + getClassName());
        setUpKeyName("upKey" + getClassName());
        setDownKeyName("downKey" + getClassName());
        setLeftJabKeyName("leftJabKey" + getClassName());
        setRightJabKeyName("rightJabKey" + getClassName());
        setLeftHookKeyName("leftHookKey" + getClassName());
        setRightHookKeyName("rightHookKey" + getClassName());
        setLeftUppercutKeyName("leftUppercutKey" + getClassName());
        setRightUppercutKeyName("rightUppercut" + getClassName());
        setGuardKeyName("guardKey" + getClassName());
        setPositionKeyName("positionKey" + getClassName());
    }

    @Override
    public void initMapping() {
        addMapping(getLeftKeyName(), initNewKeyTrigger(getLeftKeyValue()));
        addMapping(getRightKeyName(), initNewKeyTrigger(getRightKeyValue()));
        addMapping(getUpKeyName(), initNewKeyTrigger(getUpKeyValue()));
        addMapping(getDownKeyName(), initNewKeyTrigger(getDownKeyValue()));
        addMapping(getLeftJabKeyName(), initNewKeyTrigger(getLeftJabKeyValue()));
        addMapping(getRightJabKeyName(), initNewKeyTrigger(getRightJabKeyValue()));
        addMapping(getLeftHookKeyName(), initNewKeyTrigger(getLeftHookKeyValue()));
        addMapping(getRightHookKeyName(), initNewKeyTrigger(getRightHookKeyValue()));
        addMapping(getLeftUppercutKeyName(), initNewKeyTrigger(getLeftUppercutKeyValue()));
        addMapping(getRightUppercutKeyName(), initNewKeyTrigger(getRightUppercutKeyValue()));
        addMapping(getGuardKeyName(), initNewKeyTrigger(getGuardKeyValue()));
    }

    private KeyTrigger initNewKeyTrigger(int value) {
        return new KeyTrigger(value);
    }

    private void addMapping(String keyName, KeyTrigger keyTrigger) {
        getInputManager().addMapping(keyName, keyTrigger);
    }

    @Override
    public void initActionListener() {
        addInputListener(getLeftKeyName(), getRightKeyName());
        addInputListener(getUpKeyName(), getDownKeyName());
        addInputListener(getLeftJabKeyName(), getRightJabKeyName());
        addInputListener(getLeftHookKeyName(), getRightHookKeyName());
        addInputListener(getLeftUppercutKeyName(), getRightUppercutKeyName());
        addInputListener(getGuardKeyName());
    }

    private void addInputListener(String ... values) {
        getInputManager().addListener(this, values);
    }

    @Override
    public void onAction(String name, boolean value, float tpf) {
        initBooleanKeys(name, value, tpf);
    }

    private void initBooleanKeys(String name, boolean value, float tpf) {
        if (compare(name, getLeftKeyName()) == 0) {
            if (value) {
                isLeftKey(true);
            } else {
                isLeftKey(false);
            }
        }

        if (compare(name, getRightKeyName()) == 0) {
            if (value) {
                isRightKey(true);
            } else {
                isRightKey(false);
            }
        }

        if (compare(name, getUpKeyName()) == 0) {
            if (value) {
                isUpKey(true);
            } else {
                isUpKey(false);
            }
        }

        if (compare(name, getDownKeyName()) == 0) {
            if (value) {
                isDownKey(true);
            } else {
                isDownKey(false);
            }
        }

        if (compare(name, getLeftJabKeyName()) == 0) {
            if (value) {
                isLeftJabKey(true);
            } else {
                isLeftJabKey(false);
            }
        }

        if (compare(name, getRightJabKeyName()) == 0) {
            if (value) {
                isRightJabKey(true);
            } else {
                isRightJabKey(false);
            }
        }

        if (compare(name, getLeftHookKeyName()) == 0) {
            if (value) {
                isLeftHookKey(true);
            } else {
                isLeftHookKey(false);
            }
        }

        if (compare(name, getRightHookKeyName()) == 0) {
            if (value) {
                isRightHookKey(true);
            } else {
                isRightHookKey(false);
            }
        }

        if (compare(name, getLeftUppercutKeyName()) == 0) {
            if (value) {
                isLeftUppercutKey(true);
            } else {
                isLeftUppercutKey(false);
            }
        }

        if (compare(name, getRightUppercutKeyName()) == 0) {
            if (value) {
                isRightUppercutKey(true);
            } else {
                isRightUppercutKey(false);
            }
        }

        if (compare(name, getGuardKeyName()) == 0) {
            if (value) {
                isGuardKey(true);
            } else {
                isGuardKey(false);
            }
        }

        if (compare(name, getPositionKeyName()) == 0) {
            if (value) {
                isPositionKey(true);
            } else {
                isPositionKey(false);
            }
        }
    }

    private int compare(String msg1, String msg2) {
        return msg1.compareTo(msg2);
    }

    public SimpleApplication getSimpleApplication() {
        return getApp();
    }

    public InputManager getInputManager() {
        return getApp().getInputManager();
    }

    public String getLeftKeyName() {
        return leftKeyName;
    }


    public String getRightKeyName() {
        return rightKeyName;
    }

    public String getUpKeyName() {
        return upKeyName;
    }

    public String getDownKeyName() {
        return downKeyName;
    }

    public String getLeftJabKeyName() {
        return leftJabKeyName;
    }

    public String getRightJabKeyName() {
        return rightJabKeyName;
    }

    public String getLeftHookKeyName() {
        return leftHookKeyName;
    }

    public String getRightHookKeyName() {
        return rightHookKeyName;
    }

    public String getLeftUppercutKeyName() {
        return leftUppercutKeyName;
    }

    public String getRightUppercutKeyName() {
        return rightUppercutKeyName;
    }

    public String getGuardKeyName() {
        return guardKeyName;
    }

    public int getLeftKeyValue() {
        return leftKeyValue;
    }

    public void setLeftKeyValue(int leftKeyValue) {
        this.leftKeyValue = leftKeyValue;
    }

    public int getRightKeyValue() {
        return rightKeyValue;
    }

    public void setRightKeyValue(int rightKeyValue) {
        this.rightKeyValue = rightKeyValue;
    }

    public int getUpKeyValue() {
        return upKeyValue;
    }

    public void setUpKeyValue(int upKeyValue) {
        this.upKeyValue = upKeyValue;
    }

    public int getDownKeyValue() {
        return downKeyValue;
    }

    public void setDownKeyValue(int downKeyValue) {
        this.downKeyValue = downKeyValue;
    }

    public int getLeftJabKeyValue() {
        return leftJabKeyValue;
    }

    public void setLeftJabKeyValue(int leftJabKeyValue) {
        this.leftJabKeyValue = leftJabKeyValue;
    }

    public int getRightJabKeyValue() {
        return rightJabKeyValue;
    }

    public void setRightJabKeyValue(int rightJabKeyValue) {
        this.rightJabKeyValue = rightJabKeyValue;
    }

    public int getLeftHookKeyValue() {
        return leftHookKeyValue;
    }

    public void setLeftHookKeyValue(int leftHookKeyValue) {
        this.leftHookKeyValue = leftHookKeyValue;
    }

    public int getRightHookKeyValue() {
        return rightHookKeyValue;
    }

    public void setRightHookKeyValue(int rightHookKeyValue) {
        this.rightHookKeyValue = rightHookKeyValue;
    }

    public int getLeftUppercutKeyValue() {
        return leftUppercutKeyValue;
    }

    public void setLeftUppercutKeyValue(int leftUppercutKeyValue) {
        this.leftUppercutKeyValue = leftUppercutKeyValue;
    }

    public int getRightUppercutKeyValue() {
        return rightUppercutKeyValue;
    }

    public void setRightUppercutKeyValue(int rightUppercutKeyValue) {
        this.rightUppercutKeyValue = rightUppercutKeyValue;
    }

    public int getGuardKeyValue() {
        return guardKeyValue;
    }

    public void setGuardKeyValue(int guardKeyValue) {
        this.guardKeyValue = guardKeyValue;
    }

    public void isLeftKey(boolean isLeftKey) {
        this.setIsLeftKey(isLeftKey);
    }

    public boolean isRightKey() {
        return isRightKey;
    }

    public void isRightKey(boolean isRightKey) {
        this.setIsRightKey(isRightKey);
    }

    public boolean isUpKey() {
        return isUpKey;
    }

    public void isUpKey(boolean isUpKey) {
        this.setIsUpKey(isUpKey);
    }

    public boolean isDownKey() {
        return isDownKey;
    }

    public void isDownKey(boolean isDownKey) {
        this.setIsDownKey(isDownKey);
    }

    public boolean isLeftJabKey() {
        return isLeftJabKey;
    }

    public void isLeftJabKey(boolean isLeftJabKey) {
        this.setIsLeftJabKey(isLeftJabKey);
    }

    public boolean isRightJabKey() {
        return isRightJabKey;
    }

    public void isRightJabKey(boolean isRightJabKey) {
        this.setIsRightJabKey(isRightJabKey);
    }

    public boolean isLeftHookKey() {
        return isLeftHookKey;
    }

    public void isLeftHookKey(boolean isLeftHookKey) {
        this.setIsLeftHookKey(isLeftHookKey);
    }

    public boolean isRightHookKey() {
        return isRightHookKey;
    }

    public void isRightHookKey(boolean isRightHookKey) {
        this.setIsRightHookKey(isRightHookKey);
    }

    public boolean isLeftUppercutKey() {
        return isLeftUppercutKey;
    }

    public void isLeftUppercutKey(boolean isLeftUppercutKey) {
        this.setIsLeftUppercutKey(isLeftUppercutKey);
    }

    public boolean isRightUppercutKey() {
        return isRightUppercutKey;
    }

    public void isRightUppercutKey(boolean isRightUppercutKey) {
        this.setIsRightUppercutKey(isRightUppercutKey);
    }

    public boolean isGuardKey() {
        return isGuardKey;
    }

    public void isGuardKey(boolean isGuardKey) {
        this.setIsGuardKey(isGuardKey);
    }

    public SimpleApplication getApp() {
        return app;
    }

    public String getPositionKeyName() {
        return positionKeyName;
    }

    public int getPositionKeyValue() {
        return positionKeyValue;
    }

    public void setPositionKeyValue(int positionKeyValue) {
        this.positionKeyValue = positionKeyValue;
    }

    public boolean isLeftKey() {
        return isLeftKey;
    }

    public void setIsLeftKey(boolean isLeftKey) {
        this.isLeftKey = isLeftKey;
    }

    public void setIsRightKey(boolean isRightKey) {
        this.isRightKey = isRightKey;
    }

    public void setIsUpKey(boolean isUpKey) {
        this.isUpKey = isUpKey;
    }

    public void setIsDownKey(boolean isDownKey) {
        this.isDownKey = isDownKey;
    }

    public void setIsLeftJabKey(boolean isLeftJabKey) {
        this.isLeftJabKey = isLeftJabKey;
    }

    public void setIsRightJabKey(boolean isRightJabKey) {
        this.isRightJabKey = isRightJabKey;
    }

    public void setIsLeftHookKey(boolean isLeftHookKey) {
        this.isLeftHookKey = isLeftHookKey;
    }

    public void setIsRightHookKey(boolean isRightHookKey) {
        this.isRightHookKey = isRightHookKey;
    }

    public void setIsLeftUppercutKey(boolean isLeftUppercutKey) {
        this.isLeftUppercutKey = isLeftUppercutKey;
    }

    public void setIsRightUppercutKey(boolean isRightUppercutKey) {
        this.isRightUppercutKey = isRightUppercutKey;
    }

    public void setIsGuardKey(boolean isGuardKey) {
        this.isGuardKey = isGuardKey;
    }

    public boolean isPositionKey() {
        return isPositionKey;
    }

    public void isPositionKey(boolean isPositionKey) {
        this.setIsPositionKey(isPositionKey);
    }

    public void setLeftKeyName(String leftKeyName) {
        this.leftKeyName = leftKeyName;
    }

    public void setRightKeyName(String rightKeyName) {
        this.rightKeyName = rightKeyName;
    }

    public void setUpKeyName(String upKeyName) {
        this.upKeyName = upKeyName;
    }

    public void setDownKeyName(String downKeyName) {
        this.downKeyName = downKeyName;
    }

    public void setLeftJabKeyName(String leftJabKeyName) {
        this.leftJabKeyName = leftJabKeyName;
    }

    public void setRightJabKeyName(String rightJabKeyName) {
        this.rightJabKeyName = rightJabKeyName;
    }

    public void setLeftHookKeyName(String leftHookKeyName) {
        this.leftHookKeyName = leftHookKeyName;
    }

    public void setRightHookKeyName(String rightHookKeyName) {
        this.rightHookKeyName = rightHookKeyName;
    }

    public void setLeftUppercutKeyName(String leftUppercutKeyName) {
        this.leftUppercutKeyName = leftUppercutKeyName;
    }

    public void setRightUppercutKeyName(String rightUppercutKeyName) {
        this.rightUppercutKeyName = rightUppercutKeyName;
    }

    public void setGuardKeyName(String guardKeyName) {
        this.guardKeyName = guardKeyName;
    }

    public void setPositionKeyName(String positionKeyName) {
        this.positionKeyName = positionKeyName;
    }

    public void setIsPositionKey(boolean isPositionKey) {
        this.isPositionKey = isPositionKey;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
