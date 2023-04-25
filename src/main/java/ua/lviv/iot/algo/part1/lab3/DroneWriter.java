package ua.lviv.iot.algo.part1.lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class DroneWriter {
    public void writeToFile(final List<AbstractDrone> droneList, final String fileName) throws FileNotFoundException {
        PrintWriter printer = new PrintWriter(fileName);

        droneList.sort(Comparator.comparing(o -> o.getClass().getName()));

        String temporaryName = null;

        for (AbstractDrone drone : droneList) {
            if (temporaryName != drone.getClass().getName()) {
                printer.println(drone.getClass().getSimpleName());
                printer.println(drone.getHeaders());
            }

            printer.println(drone.toCSV());
            temporaryName = drone.getClass().getName();

        }
        printer.close();
    }
}
