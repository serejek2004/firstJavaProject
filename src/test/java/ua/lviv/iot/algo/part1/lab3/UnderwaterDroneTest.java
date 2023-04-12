package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnderwaterDroneTest {
    UnderwaterDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new UnderwaterDrone(60.0, 50, 10, 30, -400);
    }

    @Test
    public void testFlyAtForUnderwaterDrone() {
        firstDrone.flyAt(50, -60);
        Assertions.assertEquals(50, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(-60, firstDrone.getCurrentAltitude());
    }

    @Test
    public void testGetMaxFlyingDistanceAtCurrentSpeedForUnderwaterDrone() {
        firstDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
        String expected = "UnderwaterDrone - currentSpeed=30.0, currentAltitude=-400.0 fuelCapacity=60.0l," +
                " consumptionFuel=10.0, currentMaxFlyingDistance=500.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringForUnderwaterDrone() {
        String expected = "UnderwaterDrone - currentSpeed=30.0, currentAltitude=-400.0 fuelCapacity=60.0l," +
                " consumptionFuel=10.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}