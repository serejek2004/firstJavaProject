package ua.lviv.iot.algo.part1.lab2;

public class DeliveryDrone extends AbstractDrone {
    private double currentBattaryLevelInMA;
    private double battaryCapacity;
    private double consumptionBattaryPerHundredKm;
    private double currentMaxFlyingDistance;

    DeliveryDrone(double currentBattaryLevelInMA, double battaryCapacity, double consumptionBattaryPerHundredKm
            , double currentSpeed, double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.currentBattaryLevelInMA = currentBattaryLevelInMA;
        this.battaryCapacity = battaryCapacity;
        this.consumptionBattaryPerHundredKm = consumptionBattaryPerHundredKm;

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
        return "DeliveryDrone - " + super.toString()
                + " currentBattaryLevelInMA=" + currentBattaryLevelInMA
                + ", battaryCapacity=" + battaryCapacity
                + ", consumptionBattaryPerHundredKm=" + consumptionBattaryPerHundredKm
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}