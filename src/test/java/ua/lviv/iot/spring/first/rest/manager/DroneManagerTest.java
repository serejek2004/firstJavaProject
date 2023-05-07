package ua.lviv.iot.spring.first.rest.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.first.rest.manager.DroneManager;
import ua.lviv.iot.spring.first.rest.model.AbstractDrone;
import ua.lviv.iot.spring.first.rest.model.ElectroDrone;
import ua.lviv.iot.spring.first.rest.model.UnderwaterDrone;

import java.util.LinkedList;
import java.util.List;

class DroneManagerTest {
    DroneManager manager;
    List<AbstractDrone> expectedDroneList;

    @BeforeEach
    public void setUpAll() {
        manager = new DroneManager();
        expectedDroneList = new LinkedList<>();
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