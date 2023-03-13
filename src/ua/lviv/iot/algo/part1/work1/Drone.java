package ua.lviv.iot.algo.part1.work1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"currentSpeed", "currentAltitude", "batteryCapacity", "currentBatteryLevel"})

public class Drone {
    private double currentSpeed;
    private double currentAltitude;
    private double batteryCapacity;
    private double currentBatteryLevel;
    private static Drone instance = new Drone();
    public static Drone getInstance() {
        return instance;
    }
    public void flyAt(double speedMetersPerMinute, double altitude) {
        currentSpeed = speedMetersPerMinute;
        currentAltitude = altitude;
    }
    public double chargeBattery(double amount) {
        currentBatteryLevel += amount;
        return currentBatteryLevel;
    }
    public double useBattery(double amount) {
        currentBatteryLevel -= amount;
        return currentBatteryLevel;
    }
    public static void main(String... args) {
        Drone[] arrayDrones = new Drone[4];
        arrayDrones[0] = new Drone( 600.0, 1500.0, 40000.0, 25000.0);
        arrayDrones[1] = new Drone();
        arrayDrones[2] = getInstance();
        arrayDrones[3] = getInstance();

        for (Drone drones : arrayDrones) {
            System.out.println(drones.toString());
        }
    }
}
