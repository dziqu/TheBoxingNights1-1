package pl.theboxingnights.app.settings;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;
import pl.theboxingnights.app.start.Start;

import java.util.prefs.BackingStoreException;

/**
 * Created by filip / 07.06.15 / 10:19
 */
public final class Settings {

    private Start app;
    private AppSettings settings;
    private GraphicsEnvironment graphicsEnvironment;
    private boolean fullscreen;
    private int depthBits;
    private int stencilBits;
    private int bitsPerPixel;
    private String audioRenderer;
    private int frameRate;
    private int frequency;
    private int height;
    private int width;
    private String renderer;
    private int samples;
    private boolean vSync;


    public Settings(Start app) {
        this.app = app;
        if (settings == null) {
            settings = new AppSettings(true);
        }
    }

    public void getSettingsFromFile() {
        fullscreen = settings.isFullscreen();
        depthBits = settings.getDepthBits();
        stencilBits = settings.getStencilBits();
        bitsPerPixel = settings.getBitsPerPixel();
        audioRenderer = settings.getAudioRenderer();
        frameRate = settings.getFrameRate();
        frequency = settings.getFrequency();
        height = settings.getHeight();
        width = settings.getWidth();
        renderer = settings.getRenderer();
        samples = settings.getSamples();
        vSync = settings.isVSync();
    }

    public void setAllSettings() {
        settings.setFullscreen(fullscreen);
        settings.setDepthBits(depthBits);
        settings.setStencilBits(stencilBits);
        settings.setBitsPerPixel(bitsPerPixel);
        settings.setAudioRenderer(audioRenderer);
        settings.setFrameRate(frameRate);
        settings.setFrequency(frequency);
        settings.setHeight(height);
        settings.setWidth(width);
        settings.setRenderer(renderer);
        settings.setSamples(samples);
        settings.setVSync(vSync);
        settings.setTitle(getTitle());
        app.setSettings(settings);
    }

    public Start getApp() {
        return app;
    }

    public void setApp(Start app) {
        this.app = app;
    }

    public AppSettings getSettings() {
        return settings;
    }

    public void setSettings(AppSettings settings) {
        this.settings = settings;
    }

    public GraphicsEnvironment getGraphicsEnvironment() {
        return graphicsEnvironment;
    }

    public void setGraphicsEnvironment(GraphicsEnvironment graphicsEnvironment) {
        this.graphicsEnvironment = graphicsEnvironment;
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

    public String getTitle() {
        return "The Boxing Nights";
    }

    public String getSettingsPath() {
        return "pl.theboxingnights.setting";
    }

    public void save() {
        try {
            settings.save(getSettingsPath());
        }
        catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            settings.load(getSettingsPath());
        }
        catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }
}
