package pl.theboxingnights.app.start;

import com.jme3.app.SimpleApplication;
import pl.theboxingnights.app.settings.Settings;
import pl.theboxingnights.app.world.MyWorld;

/**
 * Created by filip / 07.06.15 / 06:55
 */
public class Start extends SimpleApplication {
    public static void main (String [] args) {
        Start app = new Start();
        app.start();
        app.setSettings();
    }

    private void setSettings() {
        Settings settings = new Settings(this);
        settings.load();
        settings.getSettingsFromFile();
        settings.setAllSettings();
        settings.save();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(new MyWorld());
    }

}
