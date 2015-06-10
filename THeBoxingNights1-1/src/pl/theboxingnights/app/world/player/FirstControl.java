package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;

/**
 * Created by filip / 10.06.15 / 10:36
 */
public class FirstControl implements Controls, ActionListener, AnimEventListener {

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

    private int leftKey                 = KeyInput.KEY_A;
    private int rightKey                = KeyInput.KEY_D;
    private int upKey                   = KeyInput.KEY_W;
    private int downKey                 = KeyInput.KEY_S;
    private int leftJabKey              = KeyInput.KEY_Q;
    private int rightJabKey             = KeyInput.KEY_E;
    private int leftHookKey             = KeyInput.KEY_Z;
    private int rightHookKey            = KeyInput.KEY_C;
    private int leftUppercutKey         = KeyInput.KEY_R;
    private int rightUppercutKey        = KeyInput.KEY_F;
    private int guardKey                = KeyInput.KEY_SPACE;

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

    @Override
    public void onAction(String s, boolean b, float v) {

    }

    @Override
    public void onAnimCycleDone(AnimControl animControl, AnimChannel animChannel, String s) {

    }

    @Override
    public void onAnimChange(AnimControl animControl, AnimChannel animChannel, String s) {

    }
}
