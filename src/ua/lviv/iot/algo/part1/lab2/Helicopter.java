package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Helicopter extends AerialVehicle {
    private double fuelCapacityInLiters;
    private double currentFuelLevel;

    public double refuel(double amount) {
        if (currentFuelLevel != fuelCapacityInLiters) {
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
        if (currentFuelLevel != 0) {
            currentFuelLevel -= amount;
        }
        if (currentFuelLevel == 1) {
            System.out.println("Attantion you`ll fall!!!");
        }
        if (currentFuelLevel < 0) {
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
    public String toString() {
        return "Helicopter - " + super.toString() + " currentFuelLevel=" + currentFuelLevel + ", fuelCapicatyInLiters=" + fuelCapacityInLiters;
    }
}
