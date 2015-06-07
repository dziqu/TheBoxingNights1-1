package pl.theboxingnights.app.start;

import com.jme3.app.SimpleApplication;
import pl.theboxingnights.app.settings.Settings;

/**
 * Created by filip / 07.06.15 / 06:55
 */
public class Start extends SimpleApplication {

    public Start() {
        setSettings();
    }

    public static void main (String [] args) {
        Start app = new Start();
        app.start();
    }

    private void setSettings() {
        Settings settings = new Settings(this);
        settings.load();
        settings.getAll();
        settings.setAll();
        settings.save();
    }

    @Override
    public void simpleInitApp() {

    }

}
