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
        ElectroDrone BattleELectroDrone = new ElectroDrone(2000, 6000, 500);
        ElectroDrone ExploratoryElectroDrone = new ElectroDrone(3000, 6500, 1000);
        PetrolDrone BattlePetrolDrone = new PetrolDrone(700, 600, 50, "React");
        PetrolDrone ExploratoryPetrolDrone = new PetrolDrone(900, 550, 80, "React");
        UnderwaterDrone BattleUnderwaterDrone = new UnderwaterDrone(60.0, 50, 10);
        UnderwaterDrone ExploratoryUnderwaterDrone = new UnderwaterDrone(100, 90, 15);
        DeliveryDrone FoodDeliveryDrone = new DeliveryDrone(2500, 5000, 250);
        DeliveryDrone MaterialDeliveryDrone = new DeliveryDrone(5000, 8000, 1250);

        BattlePetrolDrone.flyAt(30, 700);
        BattlePetrolDrone.getMaxFlyingDistanceAtCurrentSpeed();
        ExploratoryPetrolDrone.flyAt(90, 1000);
        ExploratoryPetrolDrone.getMaxFlyingDistanceAtCurrentSpeed();

        BattleELectroDrone.flyAt(50, 600);
        BattleELectroDrone.getMaxFlyingDistanceAtCurrentSpeed();
        ExploratoryElectroDrone.flyAt(55, 500);
        ExploratoryElectroDrone.getMaxFlyingDistanceAtCurrentSpeed();

        BattleUnderwaterDrone.flyAt(30, -300);
        BattleUnderwaterDrone.getMaxFlyingDistanceAtCurrentSpeed();
        ExploratoryUnderwaterDrone.flyAt(15, -800);
        ExploratoryUnderwaterDrone.getMaxFlyingDistanceAtCurrentSpeed();

        FoodDeliveryDrone.flyAt(20, 450);
        FoodDeliveryDrone.getMaxFlyingDistanceAtCurrentSpeed();
        MaterialDeliveryDrone.flyAt(15, 500);
        MaterialDeliveryDrone.getMaxFlyingDistanceAtCurrentSpeed();

        DroneManager Manager = new DroneManager();
        Manager.addDrone(BattleELectroDrone);
        Manager.addDrone(ExploratoryElectroDrone);
        Manager.addDrone(BattlePetrolDrone);
        Manager.addDrone(ExploratoryPetrolDrone);
        Manager.addDrone(BattleUnderwaterDrone);
        Manager.addDrone(ExploratoryUnderwaterDrone);
        Manager.addDrone(FoodDeliveryDrone);
        Manager.addDrone(MaterialDeliveryDrone);

        for (AbstractDrone Drones : DroneList) System.out.println(Drones.toString());

        System.out.println("--------------------------------------");
        System.out.println("currentSpeed greater than 50 is next objects ->");
        System.out.println("--------------------------------------");

        for (AbstractDrone Drones : Manager.findAllWithSpeedGreaterThan(50)) {
            System.out.println(Drones);
        }
        System.out.println("--------------------------------------");
        System.out.println("currentAltitude greater than 500 is next objects ->");
        System.out.println("--------------------------------------");
        for (AbstractDrone Drones : Manager.findAllWithAltitudeGreaterThan(500)) {
            System.out.println(Drones);
        }
    }
}

