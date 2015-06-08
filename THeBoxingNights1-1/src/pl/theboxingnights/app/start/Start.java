package pl.theboxingnights.app.start;

import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;
import pl.theboxingnights.app.settings.Settings;
import pl.theboxingnights.app.world.MyWorld;

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
        settings.setRenderer(AppSettings.LWJGL_OPENGL2);
        settings.setFrequency(60);
        settings.setFrameRate(60);
        settings.setvSync(false);
        settings.setAll();
        settings.save();
    }

    @Override
    public void simpleInitApp() {
        stateManager.attach(new MyWorld());
    }

}
