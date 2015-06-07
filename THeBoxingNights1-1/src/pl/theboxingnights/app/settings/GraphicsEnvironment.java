package pl.theboxingnights.app.settings;

import java.awt.*;
import java.util.List;

/**
 * Created by filip / 07.06.15 / 11:23
 */
public final class GraphicsEnvironment {

    private java.awt.GraphicsEnvironment localGraphicsEnvironment = null;
    private GraphicsDevice graphicsDevice = null;
    private DisplayMode[] displayModes = null;

    public GraphicsEnvironment() {
        localGraphicsEnvironment = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = localGraphicsEnvironment.getDefaultScreenDevice();
        displayModes = graphicsDevice.getDisplayModes();
    }

    public int getMaxHeight() {
        return displayModes[displayModes.length - 1].getHeight();
    }

    public int getMaxWidth() {
        return displayModes[displayModes.length - 1].getWidth();
    }

    public int getMaxRefreshRate() {
        return displayModes[displayModes.length - 1].getRefreshRate();
    }

    public int getMaxBitDepth() {
        return displayModes[displayModes.length - 1].getBitDepth();
    }
}
