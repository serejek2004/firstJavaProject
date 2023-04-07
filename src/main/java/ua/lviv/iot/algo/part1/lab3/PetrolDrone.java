package ua.lviv.iot.algo.part1.lab3;

public class PetrolDrone extends AbstractDrone {
    private final double fuelCapacityInLiters;
    private double currentFuelLevel;
    private final double consumptionFuelPerHundredKm;
    private final String typeFuel;
    private double currentMaxFlyingDistance;

    PetrolDrone(double fuelCapacityInLiters, double currentFuelLevel,
                double consumptionFuelPerHundredKm, String typeFuel, double currentSpeed, double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacityInLiters = fuelCapacityInLiters;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionFuelPerHundredKm = consumptionFuelPerHundredKm;
        this.typeFuel = typeFuel;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public double refuel(double amount) {
        if (currentFuelLevel < fuelCapacityInLiters) {
            currentFuelLevel += amount;
        }
        if (currentFuelLevel > fuelCapacityInLiters) {
            currentFuelLevel -= amount;
        }
        return currentFuelLevel;
    }

    public double useFuel(double amount) {
        if (currentFuelLevel > amount) {
            currentFuelLevel -= amount;
        }
        return currentFuelLevel;
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
        return "PetrolDrone - " + super.toString() + " fuelCapacity=" + fuelCapacityInLiters
                + "l, consumptionFuelPerHundredKm=" + consumptionFuelPerHundredKm + " typeFuel -- " + typeFuel
                + ", currentMaxFlyingDistance=" + currentMaxFlyingDistance;
    }
}


