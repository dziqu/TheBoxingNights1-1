package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 10.06.15 / 11:03
 */
public abstract class AbstractControl implements Controls, ActionListener, AnimEventListener {

    private SimpleApplication app;

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

    private int leftKey                 = 0;
    private int rightKey                = 0;
    private int upKey                   = 0;
    private int downKey                 = 0;
    private int leftJabKey              = 0;
    private int rightJabKey             = 0;
    private int leftHookKey             = 0;
    private int rightHookKey            = 0;
    private int leftUppercutKey         = 0;
    private int rightUppercutKey        = 0;
    private int guardKey                = 0;

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

    }

    @Override
    public void initMapping() {

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

    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public int getLeftJabKey() {
        return leftJabKey;
    }

    public void setLeftJabKey(int leftJabKey) {
        this.leftJabKey = leftJabKey;
    }

    public int getRightJabKey() {
        return rightJabKey;
    }

    public void setRightJabKey(int rightJabKey) {
        this.rightJabKey = rightJabKey;
    }

    public int getLeftHookKey() {
        return leftHookKey;
    }

    public void setLeftHookKey(int leftHookKey) {
        this.leftHookKey = leftHookKey;
    }

    public int getRightHookKey() {
        return rightHookKey;
    }

    public void setRightHookKey(int rightHookKey) {
        this.rightHookKey = rightHookKey;
    }

    public int getLeftUppercutKey() {
        return leftUppercutKey;
    }

    public void setLeftUppercutKey(int leftUppercutKey) {
        this.leftUppercutKey = leftUppercutKey;
    }

    public int getRightUppercutKey() {
        return rightUppercutKey;
    }

    public void setRightUppercutKey(int rightUppercutKey) {
        this.rightUppercutKey = rightUppercutKey;
    }

    public int getGuardKey() {
        return guardKey;
    }

    public void setGuardKey(int guardKey) {
        this.guardKey = guardKey;
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
}
