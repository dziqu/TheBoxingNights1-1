package pl.theboxingnights.app.clientServer;

import com.jme3.app.SimpleApplication;
import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.Network;
import com.jme3.network.Server;
import com.jme3.network.serializing.Serializer;
import com.jme3.scene.Geometry;
import com.jme3.system.JmeContext;
import pl.theboxingnights.app.clientServer.world.MultiplayerWorld;
import pl.theboxingnights.app.world.MyWorld;

import java.io.IOException;

/**
 * Created by filip / 18.06.15 / 20:32
 */
public class ServerMain extends SimpleApplication {

    private Server myServer = null;

    public static void main (String [] args) {

        Serializer.registerClass(HelloMessage.class);

        ServerMain app = new ServerMain();
        app.start(JmeContext.Type.Headless);
    }


    @Override
    public void simpleInitApp() {
        try {
            myServer = Network.createServer(6143);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        myServer.addMessageListener(new ServerListener(), HelloMessage.class);
        myServer.start();

        MultiplayerWorld multiplayerWorld = new MultiplayerWorld(this);

        Message message = new HelloMessage("Welcome!");
        myServer.broadcast(message);
    }

    @Override
    public void simpleUpdate(float tpf) {

    }
}
