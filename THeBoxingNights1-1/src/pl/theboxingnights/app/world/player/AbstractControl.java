package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 10.06.15 / 11:03
 */
public abstract class AbstractControl implements Controls, ActionListener, AnimEventListener {

    private final SimpleApplication app;

    private final String leftKeyName            = "left";
    private final String rightKeyName           = "right";
    private final String upKeyName              = "up";
    private final String downKeyName            = "down";
    private final String leftJabKeyName         = "leftJab";
    private final String rightJabKeyName        = "rightJab";
    private final String leftHookKeyName        = "leftHook";
    private final String rightHookKeyName       = "rightHook";
    private final String leftUppercutKeyName    = "leftUppercut";
    private final String rightUppercutKeyName   = "rightUppercut";
    private final String guardKeyName           = "guard";
    private final String positionKeyName        = "position";

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

    private Vector3f goDown             = new Vector3f(4, 0, 0);
    private Vector3f goLeft             = new Vector3f(0, 0, 4);
    private Vector3f goRight            = new Vector3f(0, 0, -4);

    public AbstractControl(SimpleApplication app) {
        this.app = app;
        initKeysValues();
        initMapping();
        initActionListener();
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
        switch(name) {
            case leftKeyName: {
                isLeftKey(value);
                break;
            }case rightKeyName: {
                isRightKey(value);
                break;
            }case upKeyName: {
                isUpKey(value);
                break;
            }case downKeyName: {
                isDownKey(value);
                break;
            }case leftJabKeyName: {
                isLeftJabKey(value);
                break;
            }case rightJabKeyName: {
                isRightJabKey(value);
                break;
            }case leftHookKeyName: {
                isLeftHookKey(value);
                break;
            }case rightHookKeyName: {
                isRightHookKey(value);
                break;
            }case leftUppercutKeyName: {
                isLeftUppercutKey(value);
                break;
            }case rightUppercutKeyName: {
                isRightUppercutKey(value);
                break;
            }case guardKeyName: {
                isGuardKey(value);
                break;
            }case positionKeyName: {
                isPositionKey(value);
                break;
            } default: {
                isLeftKey(value);
                isRightKey(value);
                isUpKey(value);
                isDownKey(value);
                isLeftJabKey(value);
                isRightJabKey(value);
                isLeftHookKey(value);
                isRightHookKey(value);
                isLeftUppercutKey(value);
                isRightUppercutKey(value);
                isGuardKey(value);
                isPositionKey(value);
                break;
            }
        }
    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

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

    public Vector3f getGoDown() {
        return goDown;
    }

    public void setGoDown(Vector3f goDown) {
        this.goDown = goDown;
    }

    public Vector3f getGoLeft() {
        return goLeft;
    }

    public void setGoLeft(Vector3f goLeft) {
        this.goLeft = goLeft;
    }

    public Vector3f getGoRight() {
        return goRight;
    }

    public void setGoRight(Vector3f goRight) {
        this.goRight = goRight;
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
        this.isPositionKey = isPositionKey;
    }
}
