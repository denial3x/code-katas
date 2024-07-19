package christmas.lights.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LightsTest {

    @Test
    void turnOn280830Lights() {
        Lights lights = new Lights(1000, 1000);
        lights.turnOn(887, 9, 959, 629);
        lights.turnOn(454, 398, 844, 448);
        lights.turnOff(539, 243, 559, 965);
        lights.turnOff(370, 819, 676, 868);
        lights.turnOff(145, 40, 370, 997);
        lights.turnOff(301, 3, 808, 453);
        lights.turnOn(351, 678, 951, 908);
        lights.toggle(720, 196, 897, 994);
        lights.toggle(831, 394, 904, 860);

        assertEquals(280830, lights.getTurnedOnNumber());
        assertEquals(539560, lights.getTotalBrightness());
    }

    @Test
    void turnOn1Light() {
        Lights lights = new Lights(1000,1000);
        lights.turnOn(0,0,0,0);

        assertEquals(1, lights.getTurnedOnNumber());
        assertEquals(1, lights.getTotalBrightness());
    }

    @Test
    void toggleAllLights() {
        Lights lights = new Lights(1000, 1000);
        lights.toggle(0, 0, 999, 999);

        assertEquals(1_000_000, lights.getTurnedOnNumber());
        assertEquals(0, lights.getTurnedOffNumber());
        assertEquals(2_000_000, lights.getTotalBrightness());
    }

    @Test
    void turnOn900lights() {
        Lights lights = new Lights(50, 50);
        lights.turnOn(10, 10, 39, 39);

        assertEquals(900, lights.getTurnedOnNumber());
        assertEquals(900, lights.getTotalBrightness());
    }

    @Test
    void turnOff50lights() {
        Lights lights = new Lights(50, 50);
        lights.turnOn(0, 0, 49, 49);
        lights.turnOff(0, 0, 49, 0);

        assertEquals(50, lights.getTurnedOffNumber());
        assertEquals(2450, lights.getTotalBrightness());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "1,0", "-1,-1", "-1,1", "1,-1"})
    void wrongLightsSize(int lightColumns, int lightRows) {
        assertThrows(IllegalArgumentException.class, () -> new Lights(lightColumns, lightRows));
    }
}