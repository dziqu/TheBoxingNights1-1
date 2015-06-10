package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.InputListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 10.06.15 / 11:03
 */
public abstract class AbstractControl implements Controls, ActionListener, AnimEventListener {

    private final SimpleApplication app;

    private String leftKeyName          = "left";
    private String rightKeyName         = "right";
    private String upKeyName            = "up";
    private String downKeyName          = "down";
    private String leftJabKeyName       = "leftJab";
    private String rightJabKeyName      = "rightJab";
    private String leftHookKeyName      = "leftHook";
    private String rightHookKeyName     = "rightHook";
    private String leftUppercutKeyName  = "leftUppercut";
    private String rightUppercutKeyName = "rightUppercut";
    private String guardKeyName         = "guard";

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
    public void onAction(String s, boolean b, float v) {

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

    public void setLeftKeyName(String leftKeyName) {
        this.leftKeyName = leftKeyName;
    }

    public String getRightKeyName() {
        return rightKeyName;
    }

    public void setRightKeyName(String rightKeyName) {
        this.rightKeyName = rightKeyName;
    }

    public String getUpKeyName() {
        return upKeyName;
    }

    public void setUpKeyName(String upKeyName) {
        this.upKeyName = upKeyName;
    }

    public String getDownKeyName() {
        return downKeyName;
    }

    public void setDownKeyName(String downKeyName) {
        this.downKeyName = downKeyName;
    }

    public String getLeftJabKeyName() {
        return leftJabKeyName;
    }

    public void setLeftJabKeyName(String leftJabKeyName) {
        this.leftJabKeyName = leftJabKeyName;
    }

    public String getRightJabKeyName() {
        return rightJabKeyName;
    }

    public void setRightJabKeyName(String rightJabKeyName) {
        this.rightJabKeyName = rightJabKeyName;
    }

    public String getLeftHookKeyName() {
        return leftHookKeyName;
    }

    public void setLeftHookKeyName(String leftHookKeyName) {
        this.leftHookKeyName = leftHookKeyName;
    }

    public String getRightHookKeyName() {
        return rightHookKeyName;
    }

    public void setRightHookKeyName(String rightHookKeyName) {
        this.rightHookKeyName = rightHookKeyName;
    }

    public String getLeftUppercutKeyName() {
        return leftUppercutKeyName;
    }

    public void setLeftUppercutKeyName(String leftUppercutKeyName) {
        this.leftUppercutKeyName = leftUppercutKeyName;
    }

    public String getRightUppercutKeyName() {
        return rightUppercutKeyName;
    }

    public void setRightUppercutKeyName(String rightUppercutKeyName) {
        this.rightUppercutKeyName = rightUppercutKeyName;
    }

    public String getGuardKeyName() {
        return guardKeyName;
    }

    public void setGuardKeyName(String guardKeyName) {
        this.guardKeyName = guardKeyName;
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

    public boolean isLeftKey() {
        return isLeftKey;
    }

    public void setIsLeftKey(boolean isLeftKey) {
        this.isLeftKey = isLeftKey;
    }

    public boolean isRightKey() {
        return isRightKey;
    }

    public void setIsRightKey(boolean isRightKey) {
        this.isRightKey = isRightKey;
    }

    public boolean isUpKey() {
        return isUpKey;
    }

    public void setIsUpKey(boolean isUpKey) {
        this.isUpKey = isUpKey;
    }

    public boolean isDownKey() {
        return isDownKey;
    }

    public void setIsDownKey(boolean isDownKey) {
        this.isDownKey = isDownKey;
    }

    public boolean isLeftJabKey() {
        return isLeftJabKey;
    }

    public void setIsLeftJabKey(boolean isLeftJabKey) {
        this.isLeftJabKey = isLeftJabKey;
    }

    public boolean isRightJabKey() {
        return isRightJabKey;
    }

    public void setIsRightJabKey(boolean isRightJabKey) {
        this.isRightJabKey = isRightJabKey;
    }

    public boolean isLeftHookKey() {
        return isLeftHookKey;
    }

    public void setIsLeftHookKey(boolean isLeftHookKey) {
        this.isLeftHookKey = isLeftHookKey;
    }

    public boolean isRightHookKey() {
        return isRightHookKey;
    }

    public void setIsRightHookKey(boolean isRightHookKey) {
        this.isRightHookKey = isRightHookKey;
    }

    public boolean isLeftUppercutKey() {
        return isLeftUppercutKey;
    }

    public void setIsLeftUppercutKey(boolean isLeftUppercutKey) {
        this.isLeftUppercutKey = isLeftUppercutKey;
    }

    public boolean isRightUppercutKey() {
        return isRightUppercutKey;
    }

    public void setIsRightUppercutKey(boolean isRightUppercutKey) {
        this.isRightUppercutKey = isRightUppercutKey;
    }

    public boolean isGuardKey() {
        return isGuardKey;
    }

    public void setIsGuardKey(boolean isGuardKey) {
        this.isGuardKey = isGuardKey;
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
}
