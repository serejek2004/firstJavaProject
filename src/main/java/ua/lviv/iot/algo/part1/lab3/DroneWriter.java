package ua.lviv.iot.algo.part1.lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class DroneWriter {
    public void writeToFile(final List<AbstractDrone> droneList, final String fileName) throws FileNotFoundException {
        PrintWriter printer = new PrintWriter(fileName);
        droneList.sort(Comparator.comparing(drone -> drone.getClass().getSimpleName()));
        Map<Class<?>, List<AbstractDrone>> mapOfDrones = new HashMap<>();

        for (AbstractDrone drone : droneList) {
            mapOfDrones.computeIfAbsent(drone.getClass(), s -> new LinkedList<>()).add(drone);
        }

        for (Map.Entry<Class<?>, List<AbstractDrone>> drone : mapOfDrones.entrySet()) {
            printer.println(drone.getKey().getSimpleName());
            printer.println(drone.getValue().get(0).getHeaders());
            for (AbstractDrone sameDrone : drone.getValue()) {
                printer.println(sameDrone.toCSV());
            }
        }

        printer.close();
    }
}
