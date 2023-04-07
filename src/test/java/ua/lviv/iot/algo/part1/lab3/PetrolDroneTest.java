package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PetrolDroneTest {

    @Test
    void testRefuelIfTrueForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.refuel(50);
        Assertions.assertEquals(650, firstDrone.getCurrentFuelLevel());
    }

    @Test
    void testRefuelIfFalseForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.refuel(500);
        Assertions.assertEquals(600, firstDrone.getCurrentFuelLevel());
    }

    @Test
    void testUseFuelIfTrueForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.useFuel(50);
        Assertions.assertEquals(550, firstDrone.getCurrentFuelLevel());
    }

    @Test
    void testUseFuelIfFalseForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.useFuel(700);
        Assertions.assertEquals(600, firstDrone.getCurrentFuelLevel());
    }

    @Test
    void testFlyAtForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.flyAt(150, 300);
        Assertions.assertEquals(150, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(300, firstDrone.getCurrentAltitude());
    }

    @Test
    void testGetMaxFlyingDistanceAtCurrentSpeedForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        firstDrone.getMaxFlyingDistanceAtCurrentSpeed();
        String expected = "PetrolDrone - currentSpeed=60.0, currentAltitude=350.0 fuelCapacity=700.0l, " +
                "consumptionFuelPerHundredKm=50.0 typeFuel -- React, currentMaxFlyingDistance=1200.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringForPetrolDrone() {
        PetrolDrone firstDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        String expected = "PetrolDrone - currentSpeed=60.0, currentAltitude=350.0 fuelCapacity=700.0l, " +
                "consumptionFuelPerHundredKm=50.0 typeFuel -- React, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}