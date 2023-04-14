package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetrolDroneTest {
    PetrolDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
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
        String expected = "PetrolDrone - currentSpeed=60.0, currentAltitude=350.0 fuelCapacity=700.0l, " +
                "consumptionFuel=50.0 typeFuel - React, currentMaxFlyingDistance=1200.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringForPetrolDrone() {
        String expected = "PetrolDrone - currentSpeed=60.0, currentAltitude=350.0 fuelCapacity=700.0l, " +
                "consumptionFuel=50.0 typeFuel - React, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}