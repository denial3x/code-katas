package christmas.lights.kata;

import static java.lang.Integer.*;

public class Light {
    private int brightness;

    public void turnOn() {
        brightness = Math.min(MAX_VALUE, brightness + 1);
    }

    public void turnOff() {
        brightness = Math.max(0, brightness - 1);
    }

    public void toggle() {
        brightness = Math.min(MAX_VALUE, brightness + 2);
    }

    public boolean isOn() {
        return brightness > 0;
    }

    public boolean isOff() {
        return brightness == 0;
    }

    public int getBrightness() {
        return brightness;
    }
}
