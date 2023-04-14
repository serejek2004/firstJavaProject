package ua.lviv.iot.algo.part1.lab3;

public final class PetrolDrone extends AbstractDrone {
    private final double fuelCapacity;
    private final String typeFuel;
    private double consumptionFuel;
    private double currentMaxFlyingDistance;
    private double currentFuelLevel;

    PetrolDrone(final double fuelCapacity,
                final double currentFuelLevel,
                final double consumptionFuel,
                final String typeFuel,
                final double currentSpeed,
                final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacity = fuelCapacity;
        this.consumptionFuel = consumptionFuel;
        this.typeFuel = typeFuel;
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
    public String toString() {
        return "PetrolDrone - " + super.toString()
                + " fuelCapacity=" + fuelCapacity
                + "l, consumptionFuel=" + consumptionFuel
                + " typeFuel - " + typeFuel
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}


