package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;

@Getter

public final class DeliveryDrone extends AbstractDrone {
    private final double batteryCapacity;
    private double currentBatteryLevel;
    private double consumptionBattery;
    private double currentMaxFlyingDistance;

    DeliveryDrone(final double currentBatteryLevel,
                  final double batteryCapacity,
                  final double consumptionBattery,
                  final double currentSpeed,
                  final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBatteryLevel = currentBatteryLevel;
        this.batteryCapacity = batteryCapacity;
        this.consumptionBattery = consumptionBattery;

    }

    @Override
    public void flyAt(final double speedMetersPerMinute,
                      final double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public void calculateMaxFlyingDistanceAtCurrentSpeed() {
        final int formulaNumber = 100;
        currentMaxFlyingDistance =
                (currentBatteryLevel / consumptionBattery)
                        * formulaNumber;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders()
                + ",currentBatteryLevel,batteryCapacity,consumptionBattery,currentMaxFlyingDistance";
    }

    @Override
    public String toCSV() {
        return super.toCSV()
                + currentBatteryLevel + ","
                + batteryCapacity + ","
                + consumptionBattery + ","
                + currentMaxFlyingDistance;
    }
}
