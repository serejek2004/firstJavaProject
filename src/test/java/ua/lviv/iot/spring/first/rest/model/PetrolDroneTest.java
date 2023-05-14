package ua.lviv.iot.spring.first.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;

class PetrolDroneTest {
    PetrolDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new PetrolDrone(700, 600, 50, 60, 350);
    }

    @Test
    public void testRefuelIfTrueForPetrolDrone() {
        firstDrone.refuel(50);
        Assertions.assertEquals(650, firstDrone.getCurrentFuelLevel());
    }

    @Test
    public void testRefuelIfFalseForPetrolDrone() {
        firstDrone.refuel(500);
        Assertions.assertEquals(600, firstDrone.getCurrentFuelLevel());
    }

    @Test
    public void testUseFuelIfTrueForPetrolDrone() {
        firstDrone.useFuel(50);
        Assertions.assertEquals(550, firstDrone.getCurrentFuelLevel());
    }

    @Test
    public void testUseFuelIfFalseForPetrolDrone() {
        firstDrone.useFuel(700);
        Assertions.assertEquals(600, firstDrone.getCurrentFuelLevel());
    }

    @Test
    public void testFlyAtForPetrolDrone() {
        firstDrone.flyAt(150, 300);
        Assertions.assertEquals(150, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(300, firstDrone.getCurrentAltitude());
    }

    @Test
    public void testGetMaxFlyingDistanceAtCurrentSpeedForPetrolDrone() {
        firstDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
        final int formulaNumber = 100;
        double expectedMaxFlyingDistance = (firstDrone.getCurrentFuelLevel() / firstDrone.getConsumptionFuel())
                * formulaNumber;
        Assertions.assertEquals(expectedMaxFlyingDistance, firstDrone.getCurrentMaxFlyingDistance());
    }

    @Test
    public void testGetHeadersForPetrolDrone() {
        String expectedString = "currentSpeed," +
                "currentAltitude,currentFuelLevel," +
                "fuelCapacity,consumptionFuel," +
                "currentMaxFlyingDistance";
        String actual = firstDrone.getHeaders();
        Assertions.assertEquals(expectedString, actual);
    }

    @Test
    public void testToCSVForPetrolDrone() {
        String expectedString = firstDrone.getCurrentSpeed() + ","
                + firstDrone.getCurrentAltitude() + ","
                + firstDrone.getCurrentFuelLevel() + ","
                + firstDrone.getFuelCapacity() + ","
                + firstDrone.getConsumptionFuel() + ","
                + firstDrone.getCurrentMaxFlyingDistance();
        String actual = firstDrone.toCSV();
        Assertions.assertEquals(expectedString, actual);
    }
}