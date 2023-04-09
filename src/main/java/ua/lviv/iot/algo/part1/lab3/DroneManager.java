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
}
