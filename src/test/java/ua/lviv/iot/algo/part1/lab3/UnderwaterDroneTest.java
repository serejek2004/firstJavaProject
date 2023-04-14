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
        final int formulaNumber = 100;
        double expectedMaxFlyingDistance = (firstDrone.getCurrentFuelLevel() / firstDrone.getConsumptionFuel())
                * formulaNumber;
        Assertions.assertEquals(expectedMaxFlyingDistance, firstDrone.getCurrentMaxFlyingDistance());
    }

    @Test
    public void testGetHeadersForUnderwaterDrone() {
        String expectedString = ",currentSpeed," +
                "currentAltitude,currentFuelLevel," +
                "fuelCapacity,consumptionFuel," +
                "currentMaxFlyingDistance";
        String actual = firstDrone.getHeaders();
        Assertions.assertEquals(expectedString, actual);
    }

    @Test
    public void testToCSVForUnderwaterDrone() {
        String expectedString = "," + firstDrone.getCurrentSpeed() + ","
                + firstDrone.getCurrentAltitude() + ","
                + firstDrone.getCurrentFuelLevel() + ","
                + firstDrone.getFuelCapacity() + ","
                + firstDrone.getConsumptionFuel() + ","
                + firstDrone.getCurrentMaxFlyingDistance();
        String actual = firstDrone.toCSV();
        Assertions.assertEquals(expectedString, actual);
    }
}