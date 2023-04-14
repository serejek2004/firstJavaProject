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
    public void testChargeBatteryIfTrueForElectroDrone() {
        firstDrone.chargeBattery(500);
        Assertions.assertEquals(750, firstDrone.getCurrentBatteryLevel());
    }

    @Test
    public void testChargeBattaryIfFalseForElectroDrone() {
        firstDrone.chargeBattery(7000);
        Assertions.assertEquals(250, firstDrone.getCurrentBatteryLevel());
    }

    @Test
    public void testUseBattaryIfTrueForElectroDrone() {
        firstDrone.useBattery(50);
        Assertions.assertEquals(200, firstDrone.getCurrentBatteryLevel());
    }

    @Test
    public void testUseBattaryIfFalseForElectroDrone() {
        firstDrone = new ElectroDrone(0, 6000, 500, 100, 500);
        firstDrone.useBattery(50);
        Assertions.assertEquals(0, firstDrone.getCurrentBatteryLevel());
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
        final int formulaNumber = 100;
        double expectedMaxFlyingDistance = (firstDrone.getCurrentBatteryLevel() / firstDrone.getConsumptionBattery())
                * formulaNumber;
        Assertions.assertEquals(expectedMaxFlyingDistance, firstDrone.getCurrentMaxFlyingDistance());
    }

    @Test
    public void testGetHeadersForElectroDrone() {
        String expectedString = ",currentSpeed," +
                "currentAltitude,currentBatteryLevel," +
                "batteryCapacity,consumptionBattery," +
                "currentMaxFlyingDistance";
        String actual = firstDrone.getHeaders();
        Assertions.assertEquals(expectedString, actual);
    }

    @Test
    public void testToCSVForElectroDrone() {
        String expectedString = "," + firstDrone.getCurrentSpeed() + ","
                + firstDrone.getCurrentAltitude() + ","
                + firstDrone.getCurrentBatteryLevel() + ","
                + firstDrone.getBatteryCapacity() + ","
                + firstDrone.getConsumptionBattery() + ","
                + firstDrone.getCurrentMaxFlyingDistance();
        String actual = firstDrone.toCSV();
        Assertions.assertEquals(expectedString, actual);
    }
}