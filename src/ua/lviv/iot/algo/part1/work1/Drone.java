package ua.lviv.iot.algo.part1.work1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"currentSpeed", "currentAltitude", "batteryCapacity", "currentBatteryLevel"})

public class Drone {
    private static Drone instance = new Drone();
    public static Drone getInstance() {
        return instance;
    }
    private double currentSpeed, currentAltitude, batteryCapacity, currentBatteryLevel;
    public double[] flyAt(double speedMetersPerMinute, double altitude) {
        double[] array = new double[2];
        currentSpeed = speedMetersPerMinute;
        currentAltitude = altitude;
        array[0] = currentSpeed;
        array[1] = currentAltitude;
        System.out.println("Now your speed MPM is " + speedMetersPerMinute);
        System.out.println("Now your alltitude in meters is " + altitude);
        return array;
    }
     public double chargeBattery(double amount) {
            currentBatteryLevel += amount;
            System.out.println("Your battary level is " + currentBatteryLevel );
        return currentBatteryLevel;
    }
    public double useBattery(double amount) {
        currentBatteryLevel -= amount;
        System.out.println("Your battary level is " + currentBatteryLevel);
        return currentBatteryLevel;
    }
    public static void main(String... args) {
        Drone[] arrayDrones = new Drone[4];
        arrayDrones[0] = new Drone( 600.0, 1500.0, 40000.0, 25000.0);
        arrayDrones[1] = new Drone();
        arrayDrones[2] = getInstance();
        arrayDrones[3] = getInstance();

        for (int i = 0; i < arrayDrones.length; i++) {
            System.out.println(arrayDrones[i].toString());
        }
    }
}
