package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Drone extends AerialVehicle {
    private double currentBattaryLevelInPercent;
    private double battaryCapacityInMA;

    public double chargeBattary(double amount) {
        if (currentBattaryLevelInPercent != 100) {
            currentBattaryLevelInPercent += amount;
        }
        if (currentBattaryLevelInPercent > 100) {
            System.out.println("Error");
            return chargeBattary(amount);
        }
        System.out.println("Success");
        return currentBattaryLevelInPercent;
    }

    public double useBattary(double amount) {
        if (currentBattaryLevelInPercent != 0) {
            currentBattaryLevelInPercent -= amount;
        }
        if (currentBattaryLevelInPercent == 1) {
            System.out.println("Attantion drone will fall!!!");
        }
        if (currentBattaryLevelInPercent < 0) {
            System.out.println("Error");
            return useBattary(amount);
        }
        System.out.println("Success");
        return currentBattaryLevelInPercent;
    }

    @Override
    public void flyAt(double speedMetersPerMinute, double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    public String toString() {
        return super.toString() + " currentBattaryLevel=" + currentBattaryLevelInPercent + "%, battaryCapacityInMA=" + battaryCapacityInMA;
    }
}
