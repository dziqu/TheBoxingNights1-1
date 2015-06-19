package pl.theboxingnights.app.clientServer;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

/**
 * Created by filip / 19.06.15 / 04:51
 */
public class ClientListener implements MessageListener<Client> {

    public ClientListener() {

    }

    @Override
    public void messageReceived(Client source, Message message) {
        if (message instanceof HelloMessage) {
            // do something with the message
            HelloMessage helloMessage = (HelloMessage) message;
            System.out.println("Client #"+source.getId());
        }
    }
}
