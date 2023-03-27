package ua.lviv.iot.algo.part1.lab2;

public class ElectroDrone extends AbstractDrone {
    private double currentBattaryLevelInMA;
    private double battaryCapacity;
    private double consumptionBattaryPerHundredKm;
    private double currentMaxFlyingDistance;

    ElectroDrone(double currentBattaryLevelInMA, double battaryCapacity, double consumptionBattaryPerHundredKm) {
        this.currentBattaryLevelInMA = currentBattaryLevelInMA;
        this.battaryCapacity = battaryCapacity;
        this.consumptionBattaryPerHundredKm = consumptionBattaryPerHundredKm;
    }

    public double chargeBattary(double amount) {
        if (currentBattaryLevelInMA < battaryCapacity) {
            currentBattaryLevelInMA += amount;
        }
        if (currentBattaryLevelInMA > battaryCapacity) {
            System.out.println("Error");
            return chargeBattary(amount);
        }
        System.out.println("Success");
        return currentBattaryLevelInMA;
    }

    public double useBattary(double amount) {
        if (currentBattaryLevelInMA > 0) {
            currentBattaryLevelInMA -= amount;
        } else {
            System.out.println("Error");
            return useBattary(amount);
        }
        System.out.println("Success");
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

    public String toString() {
        return "ElectroDrone - " + super.toString() + " currentBattaryLevelInMA=" + currentBattaryLevelInMA + ", battaryCapacity="
                + battaryCapacity + ", consumptionBattaryPerHundredKm=" + consumptionBattaryPerHundredKm
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
