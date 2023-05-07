package ua.lviv.iot.spring.first.rest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.first.rest.model.DeliveryDrone;

class DeliveryDroneTest {
    DeliveryDrone firstDrone;

    @BeforeEach
    public void setUpAll() {
        firstDrone = new DeliveryDrone(2500, 5000, 250, 20, 600);
    }

    @Test
    public void testGetHeadersForDeliveryDrone() {
        String expectedString = "currentSpeed," +
                "currentAltitude,currentBatteryLevel," +
                "batteryCapacity,consumptionBattery," +
                "currentMaxFlyingDistance";
        String actual = firstDrone.getHeaders();
        Assertions.assertEquals(expectedString, actual);
    }

    @Test
    public void testToCSVForDeliveryDrone() {
        String expectedString = firstDrone.getCurrentSpeed() + ","
                + firstDrone.getCurrentAltitude() + ","
                + firstDrone.getCurrentBatteryLevel() + ","
                + firstDrone.getBatteryCapacity() + ","
                + firstDrone.getConsumptionBattery() + ","
                + firstDrone.getCurrentMaxFlyingDistance();
        String actual = firstDrone.toCSV();
        Assertions.assertEquals(expectedString, actual);
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
        final int formulaNumber = 100;
        double expectedMaxFlyingDistance = (firstDrone.getCurrentBatteryLevel() / firstDrone.getConsumptionBattery())
                * formulaNumber;
        Assertions.assertEquals(expectedMaxFlyingDistance, firstDrone.getCurrentMaxFlyingDistance());
    }
}