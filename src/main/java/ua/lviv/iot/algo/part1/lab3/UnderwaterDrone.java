package ua.lviv.iot.algo.part1.lab3;

public class UnderwaterDrone extends AbstractDrone {
    private final double fuelCapacityInLiters;
    private double currentFuelLevel;
    private final double consumptionFuelPerHundredKm;
    private double currentMaxFlyingDistance;

    UnderwaterDrone(double fuelCapacityInLiters, double currentFuelLevel, double consumptionFuelPerHundredKm,
                    double currentSpeed, double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacityInLiters = fuelCapacityInLiters;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionFuelPerHundredKm = consumptionFuelPerHundredKm;
    }

    @Override
    public void flyAt(double speedMetersPerMinute, double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public void getMaxFlyingDistanceAtCurrentSpeed() {
        currentMaxFlyingDistance = (currentFuelLevel / consumptionFuelPerHundredKm) * 100;
    }

    @Override
    public String toString() {
        return "UnderwaterDrone - " + super.toString() + " fuelCapacity=" + fuelCapacityInLiters
                + "l, consumptionFuelPerHundredKm=" + consumptionFuelPerHundredKm
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
