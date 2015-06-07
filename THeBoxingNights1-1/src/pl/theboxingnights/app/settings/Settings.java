package pl.theboxingnights.app.settings;

import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;

import java.util.prefs.BackingStoreException;

/**
 * Created by filip / 07.06.15 / 10:19
 */
public class Settings {

    private final SimpleApplication application;
    private final AppSettings appSettings;
    private String title            = "The Boxing Nights";
    private boolean fullscreen      = false;
    private int depthBits           = 16;
    private int stencilBits         = 0;
    private int bitsPerPixel        = 32;
    private String audioRenderer    = AppSettings.LWJGL_OPENAL;
    private int frameRate           = 60;
    private int frequency           = 60;
    private int height              = 768;
    private int width               = 1024;
    private String renderer         = AppSettings.LWJGL_OPENGL1;
    private int samples             = 4;
    private boolean vSync           = true;
    private boolean showSettings    = true;
    private String appSettingsName  = "pl.theboxingnights.settings";


    public Settings(SimpleApplication application) {
        appSettings = new AppSettings(true);
        this.application = application;
    }

    public void getAll() {
        try {
            setTitle(getAppSettings().getTitle());
            setFullscreen(getAppSettings().isFullscreen());
            setDepthBits(getAppSettings().getDepthBits());
            setStencilBits(getAppSettings().getStencilBits());
            setBitsPerPixel(getAppSettings().getBitsPerPixel());
            setAudioRenderer(getAppSettings().getAudioRenderer());
            setFrameRate(getAppSettings().getFrameRate());
            setFrequency(getAppSettings().getFrequency());
            setHeight(getAppSettings().getHeight());
            setWidth(getAppSettings().getWidth());
            setRenderer(getAppSettings().getRenderer());
            setSamples(getAppSettings().getSamples());
            setvSync(getAppSettings().isVSync());
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public void setAll() {
        getAppSettings().setTitle(getTitle());
        getAppSettings().setFullscreen(isFullscreen());
        getAppSettings().setDepthBits(getDepthBits());
        getAppSettings().setStencilBits(getStencilBits());
        getAppSettings().setBitsPerPixel(getBitsPerPixel());
        getAppSettings().setAudioRenderer(getAudioRenderer());
        getAppSettings().setFrameRate(getFrameRate());
        getAppSettings().setFrequency(getFrequency());
        getAppSettings().setHeight(getHeight());
        getAppSettings().setWidth(getWidth());
        getAppSettings().setRenderer(getRenderer());
        getAppSettings().setSamples(getSamples());
        getAppSettings().setVSync(isvSync());
        application.setShowSettings(showSettings);
        application.setSettings(appSettings);
    }

    public void save() {
        try {
            appSettings.save(appSettingsName);
        }
        catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            appSettings.load(appSettingsName);
        }
        catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public int getDepthBits() {
        return depthBits;
    }

    public void setDepthBits(int depthBits) {
        this.depthBits = depthBits;
    }

    public int getStencilBits() {
        return stencilBits;
    }

    public void setStencilBits(int stencilBits) {
        this.stencilBits = stencilBits;
    }

    public int getBitsPerPixel() {
        return bitsPerPixel;
    }

    public void setBitsPerPixel(int bitsPerPixel) {
        this.bitsPerPixel = bitsPerPixel;
    }

    public String getAudioRenderer() {
        return audioRenderer;
    }

    public void setAudioRenderer(String audioRenderer) {
        this.audioRenderer = audioRenderer;
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public boolean isvSync() {
        return vSync;
    }

    public void setvSync(boolean vSync) {
        this.vSync = vSync;
    }
}