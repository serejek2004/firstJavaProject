package ua.lviv.iot.algo.part1.lab2;

public class UnderwaterDrone extends AbstractDrone{
    private double fuelCapacityInLiters;
    private double currentFuelLevel;
    private double consumptionFuelPerHundredKm;
    private double currentMaxFlyingDistance;

    UnderwaterDrone(double fuelCapacityInLiters, double currentFuelLevel, double consumptionFuelPerHundredKm){
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
    public String toString() {
        return "UnderwaterDrone - " + super.toString() + " fuelCapacity=" + fuelCapacityInLiters
                + "l, consumptionFuelPerHundredkm=" + consumptionFuelPerHundredKm
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}
