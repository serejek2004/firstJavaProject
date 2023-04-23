package ua.lviv.iot.algo.part1.lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DroneWriter {
    public void writeToFile(final List<AbstractDrone> droneList, final String fileName) throws FileNotFoundException {
        PrintWriter printer = new PrintWriter(fileName);

        Map<Class<? extends AbstractDrone>, List<AbstractDrone>> mapOfDrones = droneList.stream()
                .collect(Collectors.groupingBy(AbstractDrone::getClass));

        for (Map.Entry<Class<? extends AbstractDrone>, List<AbstractDrone>> drone : mapOfDrones.entrySet()) {
            printer.println(drone.getKey().getSimpleName());
            printer.println(drone.getValue().get(0).getHeaders());
            for (AbstractDrone sameDrone : drone.getValue()) {
                printer.println(sameDrone.toCSV());
            }
        }

        printer.close();
    }
}
