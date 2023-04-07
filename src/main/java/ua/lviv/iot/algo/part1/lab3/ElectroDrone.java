package ua.lviv.iot.algo.part1.lab3;

public class ElectroDrone extends AbstractDrone {
    private double currentBattaryLevelInMA;
    private final double battaryCapacity;
    private final double consumptionBattaryPerHundredKm;
    private double currentMaxFlyingDistance;

    ElectroDrone(double currentBattaryLevelInMA, double battaryCapacity, double consumptionBattaryPerHundredKm,
                 double currentSpeed, double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBattaryLevelInMA = currentBattaryLevelInMA;
        this.battaryCapacity = battaryCapacity;
        this.consumptionBattaryPerHundredKm = consumptionBattaryPerHundredKm;
    }

    public double getCurrentBattaryLevelInMA() {
        return currentBattaryLevelInMA;
    }

    public double chargeBattary(double amount) {
        if (currentBattaryLevelInMA < battaryCapacity) {
            currentBattaryLevelInMA += amount;
        }
        if (currentBattaryLevelInMA > battaryCapacity) {
            currentBattaryLevelInMA -= amount;
        }
        return currentBattaryLevelInMA;
    }

    public double useBattary(double amount) {
        if (currentBattaryLevelInMA > 0) {
            currentBattaryLevelInMA -= amount;
        }
        return currentBattaryLevelInMA;
    }

    @Override
    public void flyAt(double speedMetersPerMinute, double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public void getMaxFlyingDistanceAtCurrentSpeed() {
        currentMaxFlyingDistance = (currentBattaryLevelInMA / consumptionBattaryPerHundredKm) * 100;
    }

    @Override
    public String toString() {
        return "ElectroDrone - " + super.toString() + " currentBattaryLevelInMA=" + currentBattaryLevelInMA + ", battaryCapacity="
                + battaryCapacity + ", consumptionBattaryPerHundredKm=" + consumptionBattaryPerHundredKm
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
