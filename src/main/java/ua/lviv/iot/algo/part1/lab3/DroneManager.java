package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter

public final class DroneManager {
    private List<AbstractDrone> droneList = new LinkedList<AbstractDrone>();

    public void addDrone(final AbstractDrone typeDrone) {
        droneList.add(typeDrone);
    }

    public List<AbstractDrone> findAllWithSpeedGreaterThan(
            final double currentSpeed) {
        return droneList.stream()
                .filter(drone -> drone.getCurrentSpeed() > currentSpeed)
                .collect(Collectors.toList());
    }

    public List<AbstractDrone> findAllWithAltitudeGreaterThan(
            final double currentAltitude) {
        return droneList.stream()
                .filter(drone -> drone.getCurrentAltitude() > currentAltitude)
                .collect(Collectors.toList());
    }
    public static void main(String... args) {
        ElectroDrone battleELectroDrone = new ElectroDrone(2000, 6000, 500, 100, 500);
        ElectroDrone exploratoryElectroDrone = new ElectroDrone(3000, 6500, 1000, 150, 600);
        PetrolDrone battlePetrolDrone = new PetrolDrone(700, 600, 50, "React", 60, 350);
        PetrolDrone exploratoryPetrolDrone = new PetrolDrone(900, 550, 80, "React", 45, 700);
        UnderwaterDrone battleUnderwaterDrone = new UnderwaterDrone(60.0, 50, 10, 30, -400);
        UnderwaterDrone exploratoryUnderwaterDrone = new UnderwaterDrone(100, 90, 15, 25, -380);
        DeliveryDrone foodDeliveryDrone = new DeliveryDrone(2500, 5000, 250, 20, 600);
        DeliveryDrone materialDeliveryDrone = new DeliveryDrone(5000, 8000, 1250, 10, 500);

//        battlePetrolDrone.flyAt(30, 300);
        battlePetrolDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
//        exploratoryPetrolDrone.flyAt(90, 1000);
        exploratoryPetrolDrone.calculateMaxFlyingDistanceAtCurrentSpeed();

//        battleELectroDrone.flyAt(50, 600);
        battleELectroDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
//        exploratoryElectroDrone.flyAt(55, 500);
        exploratoryElectroDrone.calculateMaxFlyingDistanceAtCurrentSpeed();

//        battleUnderwaterDrone.flyAt(30, -300);
        battleUnderwaterDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
//        exploratoryUnderwaterDrone.flyAt(15, -800);
        exploratoryUnderwaterDrone.calculateMaxFlyingDistanceAtCurrentSpeed();

//        foodDeliveryDrone.flyAt(20, 450);
        foodDeliveryDrone.calculateMaxFlyingDistanceAtCurrentSpeed();
//        materialDeliveryDrone.flyAt(15, 500);
        materialDeliveryDrone.calculateMaxFlyingDistanceAtCurrentSpeed();

        DroneManager manager = new DroneManager();
        manager.addDrone(battleELectroDrone);
        manager.addDrone(exploratoryElectroDrone);
        manager.addDrone(battlePetrolDrone);
        manager.addDrone(exploratoryPetrolDrone);
        manager.addDrone(battleUnderwaterDrone);
        manager.addDrone(exploratoryUnderwaterDrone);
        manager.addDrone(foodDeliveryDrone);
        manager.addDrone(materialDeliveryDrone);

        for (AbstractDrone Drones : manager.droneList) System.out.println(Drones.toString());

        System.out.println("--------------------------------------");
        System.out.println("currentSpeed greater than 50 is next objects ->");
        System.out.println("--------------------------------------");

        for (AbstractDrone Drones : manager.findAllWithSpeedGreaterThan(50)) {
            System.out.println(Drones);
        }
        System.out.println("--------------------------------------");
        System.out.println("currentAltitude greater than 500 is next objects ->");
        System.out.println("--------------------------------------");
        for (AbstractDrone Drones : manager.findAllWithAltitudeGreaterThan(500)) {
            System.out.println(Drones);
        }
    }
}

