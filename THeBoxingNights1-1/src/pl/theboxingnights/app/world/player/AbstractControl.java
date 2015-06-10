package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 10.06.15 / 11:03
 */
public abstract class AbstractControl implements Controls, ActionListener, AnimEventListener {

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

    private Vector3f goUp               = new Vector3f(-4, 0, 0);
    private Vector3f goDown             = new Vector3f(4, 0, 0);
    private Vector3f goLeft             = new Vector3f(0, 0, 4);
    private Vector3f goRight            = new Vector3f(0, 0, -4);

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
