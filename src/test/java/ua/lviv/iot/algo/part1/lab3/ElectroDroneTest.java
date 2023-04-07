package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ElectroDroneTest {

    @Test
    void testChargeBattaryIfTrueForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(250, 6000, 500, 100, 500);
        firstDrone.chargeBattary(500);
        Assertions.assertEquals(750, firstDrone.getCurrentBattaryLevelInMA());
    }
    @Test
    void testChargeBattaryIfFalseForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        firstDrone.chargeBattary(7000);
        Assertions.assertEquals(2000, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    void testUseBattaryIfTrueForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        firstDrone.useBattary(50);
        Assertions.assertEquals(1950, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    void testUseBattaryIfFalseForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(0, 6000, 500, 100, 500);
        firstDrone.useBattary(50);
        Assertions.assertEquals(0, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    void testFlyAtForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        firstDrone.flyAt(150, 600);
        Assertions.assertEquals(150, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(600, firstDrone.getCurrentAltitude());
    }

    @Test
    void testGetMaxFlyingDistanceAtCurrentSpeedForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        firstDrone.getMaxFlyingDistanceAtCurrentSpeed();
        String expected = "ElectroDrone - currentSpeed=100.0, currentAltitude=500.0 currentBattaryLevelInMA=2000.0, " +
                "battaryCapacity=6000.0, consumptionBattaryPerHundredKm=500.0, currentMaxFlyingDistance=400.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToStringForElectroDrone() {
        ElectroDrone firstDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        String expected = "ElectroDrone - currentSpeed=100.0, currentAltitude=500.0 currentBattaryLevelInMA=2000.0, " +
                "battaryCapacity=6000.0, consumptionBattaryPerHundredKm=500.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}