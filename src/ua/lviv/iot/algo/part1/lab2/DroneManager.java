package ua.lviv.iot.algo.part1.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DroneManager {
    private static final List<AbstractDrone> DroneList = new LinkedList<AbstractDrone>();

    public void addDrone(final AbstractDrone typeDrone) {
        DroneList.add(typeDrone);
    }

    public List<AbstractDrone> findAllWithSpeedGreaterThan(double currentSpeed) {
        return DroneList.stream()
                .filter(drone -> drone.getCurrentSpeed() > currentSpeed)
                .collect(Collectors.toList());
    }

    public List<AbstractDrone> findAllWithAltitudeGreaterThan(double currentAltitude) {
        return DroneList.stream()
                .filter(drone -> drone.getCurrentAltitude() > currentAltitude)
                .collect(Collectors.toList());
    }

    public static void main(String... args) {
        ElectroDrone battleELectroDrone = new ElectroDrone(2000, 6000, 500);
        ElectroDrone exploratoryElectroDrone = new ElectroDrone(3000, 6500, 1000);
        PetrolDrone battlePetrolDrone = new PetrolDrone(700, 600, 50, "React");
        PetrolDrone exploratoryPetrolDrone = new PetrolDrone(900, 550, 80, "React");
        UnderwaterDrone battleUnderwaterDrone = new UnderwaterDrone(60.0, 50, 10);
        UnderwaterDrone exploratoryUnderwaterDrone = new UnderwaterDrone(100, 90, 15);
        DeliveryDrone foodDeliveryDrone = new DeliveryDrone(2500, 5000, 250);
        DeliveryDrone materialDeliveryDrone = new DeliveryDrone(5000, 8000, 1250);

        battlePetrolDrone.flyAt(30, 700);
        battlePetrolDrone.getMaxFlyingDistanceAtCurrentSpeed();
        exploratoryPetrolDrone.flyAt(90, 1000);
        exploratoryPetrolDrone.getMaxFlyingDistanceAtCurrentSpeed();

        battleELectroDrone.flyAt(50, 600);
        battleELectroDrone.getMaxFlyingDistanceAtCurrentSpeed();
        exploratoryElectroDrone.flyAt(55, 500);
        exploratoryElectroDrone.getMaxFlyingDistanceAtCurrentSpeed();

        battleUnderwaterDrone.flyAt(30, -300);
        battleUnderwaterDrone.getMaxFlyingDistanceAtCurrentSpeed();
        exploratoryUnderwaterDrone.flyAt(15, -800);
        exploratoryUnderwaterDrone.getMaxFlyingDistanceAtCurrentSpeed();

        foodDeliveryDrone.flyAt(20, 450);
        foodDeliveryDrone.getMaxFlyingDistanceAtCurrentSpeed();
        materialDeliveryDrone.flyAt(15, 500);
        materialDeliveryDrone.getMaxFlyingDistanceAtCurrentSpeed();

        DroneManager manager = new DroneManager();
        manager.addDrone(battleELectroDrone);
        manager.addDrone(exploratoryElectroDrone);
        manager.addDrone(battlePetrolDrone);
        manager.addDrone(exploratoryPetrolDrone);
        manager.addDrone(battleUnderwaterDrone);
        manager.addDrone(exploratoryUnderwaterDrone);
        manager.addDrone(foodDeliveryDrone);
        manager.addDrone(materialDeliveryDrone);

        for (AbstractDrone Drones : DroneList) System.out.println(Drones.toString());

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

