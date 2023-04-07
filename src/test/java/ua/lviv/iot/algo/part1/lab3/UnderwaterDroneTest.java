package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnderwaterDroneTest {

    @Test
    void testFlyAtForUnderwaterDrone() {
        UnderwaterDrone firstDrone= new UnderwaterDrone(60.0, 50, 10, 30, -400);
        firstDrone.flyAt(50, -60);
        Assertions.assertEquals(50, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(-60, firstDrone.getCurrentAltitude());
    }

    @Test
    void testGetMaxFlyingDistanceAtCurrentSpeedForUnderwaterDrone() {
        UnderwaterDrone firstDrone = new UnderwaterDrone(60.0, 50, 10, 30, -400);
        firstDrone.getMaxFlyingDistanceAtCurrentSpeed();
        String expected = "UnderwaterDrone - currentSpeed=30.0, currentAltitude=-400.0 fuelCapacity=60.0l," +
                " consumptionFuelPerHundredKm=10.0, currentMaxFlyingDistance=500.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringForUnderwaterDrone() {
        UnderwaterDrone firstDrone = new UnderwaterDrone(60.0, 50, 10, 30, -400);
        String expected = "UnderwaterDrone - currentSpeed=30.0, currentAltitude=-400.0 fuelCapacity=60.0l," +
                " consumptionFuelPerHundredKm=10.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}