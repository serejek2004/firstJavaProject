package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;

@Getter

public final class PetrolDrone extends AbstractDrone {
    private final double fuelCapacity;
    private double consumptionFuel;
    private double currentMaxFlyingDistance;
    private double currentFuelLevel;

    PetrolDrone(final double fuelCapacity,
                final double currentFuelLevel,
                final double consumptionFuel,
                final double currentSpeed,
                final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacity = fuelCapacity;
        this.consumptionFuel = consumptionFuel;
        this.currentFuelLevel = currentFuelLevel;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public double refuel(final double amount) {
        if (currentFuelLevel < fuelCapacity) {
            currentFuelLevel += amount;
        }
        if (currentFuelLevel > fuelCapacity) {
            currentFuelLevel -= amount;
        }
        return currentFuelLevel;
    }

    public double useFuel(final double amount) {
        if (currentFuelLevel > amount) {
            currentFuelLevel -= amount;
        }
        return currentFuelLevel;
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
                (currentFuelLevel / consumptionFuel)
                        * formulaNumber;
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


