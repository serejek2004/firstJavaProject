package ua.lviv.iot.algo.part1.lab3;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.List;

public class DroneWriter {
    public void writeToFile(final List<AbstractDrone> droneList, final String fileName) throws FileNotFoundException {
        PrintWriter printer = new PrintWriter(fileName);
        for (int i = 0; i < droneList.size(); i++) {
            printer.println(droneList.get(i).getClass().getSimpleName());
            printer.println(droneList.get(i).getHeaders());
            printer.println(droneList.get(i).toCSV());
            for (int j = i + 1; j < droneList.size(); j++) {
                if ((droneList.get(i).getClass()) == (droneList.get(j).getClass())) {
                    printer.println(droneList.get(j).toCSV());
                    droneList.remove(j);
                    j--;
                }
            }
        }
        printer.close();
    }
}
