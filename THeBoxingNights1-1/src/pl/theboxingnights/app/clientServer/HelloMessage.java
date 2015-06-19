package pl.theboxingnights.app.clientServer;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 * Created by filip / 19.06.15 / 04:50
 */
@Serializable
public class HelloMessage extends AbstractMessage {
    private String hello;       // custom message data
    public HelloMessage() {}    // empty constructor
    public HelloMessage(String s) { hello = s; } // custom constructor
}
