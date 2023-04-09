package ua.lviv.iot.algo.part1.lab3;

public final class DeliveryDrone extends AbstractDrone {
    private final double battaryCapacity;
    private double currentBattaryLevel;
    private double consumptionBattary;
    private double currentMaxFlyingDistance;

    DeliveryDrone(final double currentBattaryLevel,
                  final double battaryCapacity,
                  final double consumptionBattary,
                  final double currentSpeed,
                  final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBattaryLevel = currentBattaryLevel;
        this.battaryCapacity = battaryCapacity;
        this.consumptionBattary = consumptionBattary;

    }

    @Override
    public void flyAt(final double speedMetersPerMinute,
                      final double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public void getMaxFlyingDistanceAtCurrentSpeed() {
        final int formulaNumber = 100;
        currentMaxFlyingDistance =
                (currentBattaryLevel / consumptionBattary)
                        * formulaNumber;
    }

    @Override
    public String toString() {
        return "DeliveryDrone - " + super.toString()
                + " currentBattaryLevel=" + currentBattaryLevel
                + ", battaryCapacity=" + battaryCapacity
                + ", consumptionBattary=" + consumptionBattary
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
