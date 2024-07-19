package christmas.lights.kata;

import java.util.Arrays;

public class Lights {
    private final Light[][] grid;

    public Lights(int lightColumns, int lightRows) {
        if (lightColumns <= 0 || lightRows <= 0)
            throw new IllegalArgumentException("Light columns number and light rows number must be positive");

        this.grid = new Light[lightColumns][lightRows];

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Light();
            }
        }
    }

    public void turnOn(final int startX, final int startY, final int endX, final int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                grid[x][y].turnOn();
            }
        }
    }

    public void turnOff(final int startX, final int startY, final int endX, final int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                grid[x][y].turnOff();
            }
        }
    }

    public void toggle(final int startX, final int startY, final int endX, final int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                grid[x][y].toggle();
            }
        }
    }

    public long getTurnedOnNumber() {
        return Arrays.stream(grid).flatMap(Arrays::stream).filter(Light::isOn).count();
    }

    public long getTurnedOffNumber() {
        return Arrays.stream(grid).flatMap(Arrays::stream).filter(Light::isOff).count();
    }

    public int getTotalBrightness() {
        return Arrays.stream(grid).flatMap(Arrays::stream).mapToInt(Light::getBrightness).sum();
    }
}
