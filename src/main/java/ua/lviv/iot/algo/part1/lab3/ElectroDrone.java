package ua.lviv.iot.algo.part1.lab3;

public final class ElectroDrone extends AbstractDrone {
    private final double battaryCapacity;
    private double consumptionBattary;
    private double currentBattaryLevel;
    private double currentMaxFlyingDistance;

    ElectroDrone(final double currentBattaryLevel,
                 final double battaryCapacity,
                 final double consumptionBattary,
                 final double currentSpeed,
                 final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBattaryLevel = currentBattaryLevel;
        this.battaryCapacity = battaryCapacity;
        this.consumptionBattary = consumptionBattary;
    }

    public double getCurrentBattaryLevelInMA() {
        return currentBattaryLevel;
    }

    public double chargeBattary(final double amount) {
        if (currentBattaryLevel < battaryCapacity) {
            currentBattaryLevel += amount;
        }
        if (currentBattaryLevel > battaryCapacity) {
            currentBattaryLevel -= amount;
        }
        return currentBattaryLevel;
    }

    public double useBattary(final double amount) {
        if (currentBattaryLevel > 0) {
            currentBattaryLevel -= amount;
        }
        return currentBattaryLevel;
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
                (currentBattaryLevel / consumptionBattary)
                        * formulaNumber;
    }

    @Override
    public String toString() {
        return "ElectroDrone - " + super.toString()
                + " currentBattaryLevel=" + currentBattaryLevel
                + ", battaryCapacity=" + battaryCapacity
                + ", consumptionBattary=" + consumptionBattary
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
