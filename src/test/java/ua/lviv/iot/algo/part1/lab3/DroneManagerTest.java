package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class DroneManagerTest {
    DroneManager manager = new DroneManager();
    List<AbstractDrone> expectedDroneList = new LinkedList<>();

    @BeforeEach
    public void setUpAll() {
        ElectroDrone battleELectroDrone = new ElectroDrone(2000, 6000, 500, 1500, 500);
        ElectroDrone exploratoryElectroDrone = new ElectroDrone(3000, 6500, 1000, 2050, 600);
        UnderwaterDrone battleUnderwaterDrone = new UnderwaterDrone(60.0, 50, 10, 30, -400);
        UnderwaterDrone exploratoryUnderwaterDrone = new UnderwaterDrone(100, 90, 15, 25, -380);
        manager.addDrone(battleELectroDrone);
        manager.addDrone(exploratoryElectroDrone);
        manager.addDrone(battleUnderwaterDrone);
        manager.addDrone(exploratoryUnderwaterDrone);
        expectedDroneList.add(battleELectroDrone);
        expectedDroneList.add(exploratoryElectroDrone);
    }

    @Test
    public void testFindAllWithSpeedGreaterThanForManagerDrone() {
        List<AbstractDrone> droneList = manager.findAllWithSpeedGreaterThan(1000);
        Assertions.assertEquals(expectedDroneList, droneList);
    }

    @Test
    public void testFindAllWithAltitudeGreaterThanForManagerDrone() {
        List<AbstractDrone> droneList = manager.findAllWithAltitudeGreaterThan(0);
        Assertions.assertEquals(expectedDroneList, droneList);
    }
}