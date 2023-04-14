package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeliveryDroneTest {
    DeliveryDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new DeliveryDrone(2500, 5000, 250, 20, 600);
    }

    @Test
    public void testFlyAtForDeliveryDrone() {
        firstDrone.flyAt(50, 60);
        Assertions.assertEquals(50, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(60, firstDrone.getCurrentAltitude());
    }

    @Test
    public void testCalculateMaxFlyingDistanceAtCurrentSpeedForDeliveryDrone() {
        firstDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
        String expectedString = "DeliveryDrone - currentSpeed=20.0, currentAltitude=600.0 currentBatteryLevel=2500.0," +
                " batteryCapacity=5000.0, consumptionBattery=250.0, currentMaxFlyingDistance=1000.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expectedString, actual);
    }

    @Test
    public void testToStringForDeliveryDrone() {
        String expectedString = "DeliveryDrone - currentSpeed=20.0, currentAltitude=600.0 currentBatteryLevel=2500.0," +
                " batteryCapacity=5000.0, consumptionBattery=250.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expectedString, actual);
    }
}