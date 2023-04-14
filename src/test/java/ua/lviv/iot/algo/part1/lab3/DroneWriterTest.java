package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DroneWriterTest {
    DroneManager manager = new DroneManager();

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        manager.addDrone(new DeliveryDrone(2500, 5000, 250, 20, 600));
        manager.addDrone(new ElectroDrone(2000, 6000, 500, 100, 500));
        manager.addDrone(new PetrolDrone(700, 600, 50, 60, 350));
        manager.addDrone(new PetrolDrone(900, 550, 80, 45, 700));
        manager.addDrone(new UnderwaterDrone(60.0, 50, 10, 30, -400));
        manager.addDrone(new UnderwaterDrone(100, 90, 15, 25, -380));
        manager.addDrone(new DeliveryDrone(5000, 8000, 1250, 10, 500));
        manager.addDrone(new DeliveryDrone(2000, 4500, 250, 20, 300));
        manager.addDrone(new ElectroDrone(3000, 6500, 1000, 150, 600));
        manager.addDrone(new DeliveryDrone(3500, 6000, 125, 15, 500));

        for (AbstractDrone drone : manager.getDroneList()) {
            drone.calculateMaxFlyingDistanceAtCurrentSpeed();
        }

        DroneWriter fileWriter = new DroneWriter();
        fileWriter.writeToFile(manager.getDroneList(), "src/test/resources/FileDrones.csv");
    }

    @Test
    public void testWriteToFileForDroneWriter() throws IOException {
        String lineOfFile = "";
        List<String> content = new LinkedList<>();
        List<String> expectedContent = new LinkedList<>();
        BufferedReader readerDronesFile = new BufferedReader(new FileReader("src/test/resources/FileDrones.csv"));
        BufferedReader readerExpectedDronesFile;
        readerExpectedDronesFile = new BufferedReader(new FileReader("src/test/resources/expectedFileDrones.csv"));
        while ((lineOfFile = readerDronesFile.readLine()) != null) {
            content.add(lineOfFile);
        }
        while ((lineOfFile = readerExpectedDronesFile.readLine()) != null) {
            expectedContent.add(lineOfFile);
        }
        readerExpectedDronesFile.close();
        readerDronesFile.close();
        Assertions.assertEquals(content, expectedContent);
    }

    @Test
    public void testWriteToFileIsEmpty() throws IOException {
        DroneManager emptyManager = new DroneManager();
        String lineOfFile = "";
        DroneWriter writer = new DroneWriter();
        writer.writeToFile(emptyManager.getDroneList(), "src/test/resources/EmptyFileDrones.csv");
        BufferedReader readerEmptyFile = new BufferedReader(new FileReader("src/test/resources/EmptyFileDrones.csv"));
        while ((lineOfFile = readerEmptyFile.readLine()) != null) {
            Assertions.assertNull(lineOfFile);
        }
    }

    @Test
    public void testEmptyFileAvailability() throws FileNotFoundException {
        BufferedReader readerEmptyFile = new BufferedReader(new FileReader("src/test/resources/EmptyFileDrones.csv"));
        Assertions.assertNotNull(readerEmptyFile);
    }

    @Test
    public void testDronesFileAvailability() throws FileNotFoundException {
        BufferedReader readerDronesFile = new BufferedReader(new FileReader("src/test/resources/FileDrones.csv"));
        Assertions.assertNotNull(readerDronesFile);
    }
}
