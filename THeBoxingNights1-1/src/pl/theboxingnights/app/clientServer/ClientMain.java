package pl.theboxingnights.app.clientServer;

import com.jme3.app.SimpleApplication;
import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;
import com.jme3.system.JmeContext;
import pl.theboxingnights.app.clientServer.world.MultiplayerWorld;

import java.io.IOException;

/**
 * Created by filip / 19.06.15 / 04:46
 */
public class ClientMain extends SimpleApplication {

    private Client myClient = null;
    private MultiplayerWorld multiplayerWorld;

    public static void main (String [] args) {

        Serializer.registerClass(HelloMessage.class);

        ClientMain app = new ClientMain();
        app.start(JmeContext.Type.Display);
    }

    @Override
    public void simpleInitApp() {
        try {
            myClient = Network.connectToServer("localhost", 6143);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        myClient.addMessageListener(new ClientListener(), HelloMessage.class);
        myClient.start();

        multiplayerWorld = new MultiplayerWorld(this);

        Message message = new HelloMessage("Hello World!");
        myClient.send(message);
    }

    @Override
    public void simpleUpdate(float tpf) {
        multiplayerWorld.getPlayer("player1").update(tpf);
        multiplayerWorld.getPlayer("player2").update(tpf);
    }
}
