package pl.theboxingnights.app.world;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;

/**
 * Created by filip / 08.06.15 / 03:43
 */
public class UserPlayer extends AbstractPlayer {
    public UserPlayer(SimpleApplication app,String name, String location) {
        super(app, name, location);
    }
}
