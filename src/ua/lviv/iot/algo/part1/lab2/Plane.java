package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor



public class Plane extends AerialVehicle {
    private int numberOfPassengers;
    private int maxNumberOfPassengers;

    public int boardingPassengers(int amount) {
        if (numberOfPassengers <= maxNumberOfPassengers) {
            numberOfPassengers += amount;
        }
        if (numberOfPassengers > maxNumberOfPassengers) {
            System.out.println("Error");
            return boardingPassengers(amount);
        }
        System.out.println("Success");
        return numberOfPassengers;
    }

    public int disembarkationOfPassengers(int amount) {
        if (numberOfPassengers != 0 && numberOfPassengers > amount) {
            numberOfPassengers -= amount;
        } else {
            System.out.println("Error");
        }
        return numberOfPassengers;
    }

    @Override
    public void flyAt(double speedMetersPerMinute, double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public String toString() {
        return "Plane - " + super.toString() + " numberOfPassangers=" + numberOfPassengers + ", maxNumberOfPassengers=" + maxNumberOfPassengers;
    }
}


