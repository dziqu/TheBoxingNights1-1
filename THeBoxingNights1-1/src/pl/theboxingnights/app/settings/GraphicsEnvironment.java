package pl.theboxingnights.app.settings;

import java.awt.*;

/**
 * Created by filip / 07.06.15 / 11:23
 */
public final class GraphicsEnvironment {

    private java.awt.GraphicsEnvironment localGraphicsEnvironment = null;
    private GraphicsDevice graphicsDevice = null;
    private DisplayMode[] displayModes = null;

    public GraphicsEnvironment() {
        setLocalGraphicsEnvironment(java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment());
        setGraphicsDevice(getLocalGraphicsEnvironment().getDefaultScreenDevice());
        setDisplayModes(getGraphicsDevice().getDisplayModes());
    }

    public int getMaxHeight() {
        return getDisplayModes()[getDisplayModeNumber()].getHeight();
    }

    public int getMaxWidth() {
        return getDisplayModes()[getDisplayModeNumber()].getWidth();
    }

    public int getMaxRefreshRate() {
        return getDisplayModes()[getDisplayModeNumber()].getRefreshRate();
    }

    public int getMaxBitDepth() {
        return getDisplayModes()[getDisplayModeNumber()].getBitDepth();
    }

    public java.awt.GraphicsEnvironment getLocalGraphicsEnvironment() {
        return localGraphicsEnvironment;
    }

    public void setLocalGraphicsEnvironment(java.awt.GraphicsEnvironment localGraphicsEnvironment) {
        this.localGraphicsEnvironment = localGraphicsEnvironment;
    }

    public GraphicsDevice getGraphicsDevice() {
        return graphicsDevice;
    }

    public void setGraphicsDevice(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }

    public DisplayMode[] getDisplayModes() {
        return displayModes;
    }

    public void setDisplayModes(DisplayMode[] displayModes) {
        this.displayModes = displayModes;
    }

    public int getDisplayModeNumber() {
        return 0;
    }

}
