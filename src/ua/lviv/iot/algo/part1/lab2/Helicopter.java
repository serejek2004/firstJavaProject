package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Helicopter extends AerialVehicle {
    private double fuelCapicityInLiters;
    private double currentFuelLevel;

    public double refuel(double amount) {
        if (currentFuelLevel != 100) {
            currentFuelLevel += amount;
        }
        if (currentFuelLevel > 100) {
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
        return super.toString() + " currentFuelLevel=" + currentFuelLevel + ", fuelCapicityInLiters=" + fuelCapicityInLiters;
    }
}
