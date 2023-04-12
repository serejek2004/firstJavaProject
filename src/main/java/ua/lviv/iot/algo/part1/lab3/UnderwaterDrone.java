package ua.lviv.iot.algo.part1.lab3;

public final class UnderwaterDrone extends AbstractDrone {
    private final double fuelCapacity;
    private double currentFuelLevel;
    private double consumptionFuel;
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
    public String toString() {
        return "UnderwaterDrone - " + super.toString()
                + " fuelCapacity=" + fuelCapacity
                + "l, consumptionFuel=" + consumptionFuel
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
