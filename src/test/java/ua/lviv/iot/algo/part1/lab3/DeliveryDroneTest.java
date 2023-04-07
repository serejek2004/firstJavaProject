package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;

class DeliveryDroneTest {

    @org.junit.jupiter.api.Test
    void testFlyAtForDeliveryDrone() {
        DeliveryDrone firstDrone= new DeliveryDrone(2500, 5000, 250, 20, 600);
        firstDrone.flyAt(50, 60);
        Assertions.assertEquals(50, firstDrone.getCurrentSpeed());
        Assertions.assertEquals(60, firstDrone.getCurrentAltitude());
    }

    @org.junit.jupiter.api.Test
    void testGetMaxFlyingDistanceAtCurrentSpeedForDeliveryDrone() {
        DeliveryDrone firstDrone = new DeliveryDrone(2500, 5000, 250, 20, 600);
        firstDrone.getMaxFlyingDistanceAtCurrentSpeed();
        String expected = "DeliveryDrone - currentSpeed=20.0, currentAltitude=600.0 currentBattaryLevelInMA=2500.0," +
                " battaryCapacity=5000.0, consumptionBattaryPerHundredKm=250.0, currentMaxFlyingDistance=1000.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testToStringForDeliveryDrone() {
        DeliveryDrone firstDrone = new DeliveryDrone(2500, 5000, 250, 20, 600);
        String expected = "DeliveryDrone - currentSpeed=20.0, currentAltitude=600.0 currentBattaryLevelInMA=2500.0," +
                " battaryCapacity=5000.0, consumptionBattaryPerHundredKm=250.0, currentMaxFlyingDistance=0.0";
        String actual = firstDrone.toString();
        Assertions.assertEquals(expected, actual);
    }
}