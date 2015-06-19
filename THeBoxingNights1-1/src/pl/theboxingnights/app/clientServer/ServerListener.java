package pl.theboxingnights.app.clientServer;

import com.jme3.network.HostedConnection;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;
import pl.theboxingnights.app.clientServer.world.MultiplayerWorld;
import pl.theboxingnights.app.world.MyWorld;

/**
 * Created by filip / 19.06.15 / 04:55
 */
public class ServerListener implements MessageListener<HostedConnection> {
    @Override
    public void messageReceived(HostedConnection source, Message message) {
        if (message instanceof HelloMessage) {
            // do something with the message
            HelloMessage helloMessage = (HelloMessage) message;
            System.out.println("SERVER LISTENER : client #"+source.getId() );
        }
    }
}
