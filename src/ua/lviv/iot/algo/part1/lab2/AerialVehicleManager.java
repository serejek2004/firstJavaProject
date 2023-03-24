package ua.lviv.iot.algo.part1.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AerialVehicleManager {
    private static final List<AerialVehicle> aerialVehicles = new LinkedList<AerialVehicle>();

    public void addAerialVehicle(final AerialVehicle aerialVehicle) {
        aerialVehicles.add(aerialVehicle);
    }

    public List<AerialVehicle> findAllWithSpeedGreaterThan(double currentSpeed) {
        return aerialVehicles.stream()
                .filter(vehicle -> vehicle.getCurrentSpeed() > currentSpeed)
                .collect(Collectors.toList());
    }

    public List<AerialVehicle> findAllWithAltitudeGreaterThan(double currentAltitude) {
        return aerialVehicles.stream()
                .filter(vehicle -> vehicle.getCurrentAltitude() > currentAltitude)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        Drone battleDrone = new Drone(20.0, 6000.0);
        Drone exploratoryDrone = new Drone(10.0, 6500.0);
        Helicopter battleHelicopter = new Helicopter(70.0, 60.0);
        Helicopter ambulanceHelicopter = new Helicopter(90.0, 55.0);
        Plane battleF16 = new Plane(1, 1);
        Plane boing = new Plane(66, 77);
        Balloon smallBalloon = new Balloon(90, 120);
        Balloon largeBalloon = new Balloon(150, 180);

        battleDrone.flyAt(50.0, 600.0);
        battleHelicopter.flyAt(30.0, 700.0);
        exploratoryDrone.flyAt(90.0, 1000.0);
        ambulanceHelicopter.flyAt(55.0, 500);
        battleF16.flyAt(300, 650);
        boing.flyAt(200, 1000);
        smallBalloon.flyAt(10, 350);
        largeBalloon.flyAt(15, 400);

        AerialVehicleManager manager = new AerialVehicleManager();
        manager.addAerialVehicle(battleDrone);
        manager.addAerialVehicle(exploratoryDrone);
        manager.addAerialVehicle(battleHelicopter);
        manager.addAerialVehicle(ambulanceHelicopter);
        manager.addAerialVehicle(battleF16);
        manager.addAerialVehicle(boing);
        manager.addAerialVehicle(smallBalloon);
        manager.addAerialVehicle(largeBalloon);

        for (AerialVehicle vehicle : aerialVehicles) System.out.println(vehicle.toString());

        System.out.println("--------------------------------------");
        System.out.println("currentSpeed greater than 50 is next objects ->");
        System.out.println("--------------------------------------");

        for (AerialVehicle vehicle : manager.findAllWithSpeedGreaterThan(50)) {
            System.out.println(vehicle);
        }
        System.out.println("--------------------------------------");
        System.out.println("currentAltitude greater than 500 is next objects ->");
        System.out.println("--------------------------------------");
        for (AerialVehicle vehicle : manager.findAllWithAltitudeGreaterThan(500)) {
            System.out.println(vehicle);
        }
    }
}

