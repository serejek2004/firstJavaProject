package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectroDroneTest {
    ElectroDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new ElectroDrone(250, 6000, 500, 100, 500);
    }

    @Test
    public void testChargeBattaryIfTrueForElectroDrone() {
        firstDrone.chargeBattary(500);
        Assertions.assertEquals(750, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    public void testChargeBattaryIfFalseForElectroDrone() {
        firstDrone.chargeBattary(7000);
        Assertions.assertEquals(250, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    public void testUseBattaryIfTrueForElectroDrone() {
        firstDrone.useBattary(50);
        Assertions.assertEquals(200, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    public void testUseBattaryIfFalseForElectroDrone() {
        firstDrone = new ElectroDrone(0, 6000, 500, 100, 500);
        firstDrone.useBattary(50);
        Assertions.assertEquals(0, firstDrone.getCurrentBattaryLevelInMA());
    }

    @Test
    public void testFlyAtForElectroDrone() {
        firstDrone.flyAt(150, 600);
        Assertions.assertEquals(150, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(600, firstDrone.getCurrentAltitude());
    }

    @Test
    public void testGetMaxFlyingDistanceAtCurrentSpeedForElectroDrone() {
        firstDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
        String expected = "ElectroDrone - currentSpeed=100.0, currentAltitude=500.0 currentBattaryLevel=250.0, " +
                "battaryCapacity=6000.0, consumptionBattary=500.0, currentMaxFlyingDistance=50.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToStringForElectroDrone() {
        String expected = "ElectroDrone - currentSpeed=100.0, currentAltitude=500.0 currentBattaryLevel=250.0, " +
                "battaryCapacity=6000.0, consumptionBattary=500.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}