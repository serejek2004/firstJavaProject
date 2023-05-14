package ua.lviv.iot.spring.first.rest.model;

import lombok.Getter;

@Getter

public final class UnderwaterDrone extends AbstractDrone {
    private final double fuelCapacity;
    private final double currentFuelLevel;
    private final double consumptionFuel;
    private double currentMaxFlyingDistance;

    public UnderwaterDrone(final double fuelCapacity,
                           final double currentFuelLevel,
                           final double consumptionFuel,
                           final double currentSpeed,
                           final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionFuel = consumptionFuel;
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
                (currentFuelLevel / consumptionFuel) * formulaNumber;
    }


    @Override
    public String getHeaders() {
        return super.getHeaders()
                + ",currentFuelLevel,fuelCapacity,consumptionFuel,currentMaxFlyingDistance";
    }

    @Override
    public String toCSV() {
        return super.toCSV()
                + currentFuelLevel + ","
                + fuelCapacity + ","
                + consumptionFuel + ","
                + currentMaxFlyingDistance;
    }
}
