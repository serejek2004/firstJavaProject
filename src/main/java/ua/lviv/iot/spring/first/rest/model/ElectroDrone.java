package ua.lviv.iot.spring.first.rest.model;

import lombok.Getter;

@Getter

public final class ElectroDrone extends AbstractDrone {
    private final double batteryCapacity;
    private double consumptionBattery;
    private double currentBatteryLevel;
    private double currentMaxFlyingDistance;

    public ElectroDrone(final double currentBatteryLevel,
                        final double batteryCapacity,
                        final double consumptionBattery,
                        final double currentSpeed,
                        final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBatteryLevel = currentBatteryLevel;
        this.batteryCapacity = batteryCapacity;
        this.consumptionBattery = consumptionBattery;
    }

    public double getCurrentBatteryLevel() {
        return currentBatteryLevel;
    }

    public double chargeBattery(final double amount) {
        if (currentBatteryLevel < batteryCapacity) {
            currentBatteryLevel += amount;
        }
        if (currentBatteryLevel > batteryCapacity) {
            currentBatteryLevel -= amount;
        }
        return currentBatteryLevel;
    }

    public double useBattery(final double amount) {
        if (currentBatteryLevel > 0) {
            currentBatteryLevel -= amount;
        }
        return currentBatteryLevel;
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
