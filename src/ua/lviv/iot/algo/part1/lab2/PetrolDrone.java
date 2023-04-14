package ua.lviv.iot.algo.part1.lab2;

public class PetrolDrone extends AbstractDrone {
    private double fuelCapacityInLiters;
    private double currentFuelLevel;
    private double consumptionFuelPerHundredKm;
    private String typeFuel;
    private double currentMaxFlyingDistance;

    PetrolDrone(double fuelCapacityInLiters, double currentFuelLevel, double consumptionFuelPerHundredKm, String typeFuel
            , double currentSpeed, double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacityInLiters = fuelCapacityInLiters;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionFuelPerHundredKm = consumptionFuelPerHundredKm;
        this.typeFuel = typeFuel;
    }

    public double refuel(double amount) {
        if (currentFuelLevel < fuelCapacityInLiters) {
            currentFuelLevel += amount;
        }
        if (currentFuelLevel > fuelCapacityInLiters) {
            System.out.println("Error");
            return refuel(amount);
        }
        System.out.println("Success");
        return currentFuelLevel;
    }

    public double useFuel(double amount) {
        if (currentFuelLevel > 0) {
            currentFuelLevel -= amount;
        } else {
            System.out.println("Error");
            return useFuel(amount);
        }
        System.out.println("Success");
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

