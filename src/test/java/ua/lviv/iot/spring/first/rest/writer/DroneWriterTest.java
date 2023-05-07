package ua.lviv.iot.spring.first.rest.writer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.spring.first.rest.manager.DroneManager;
import ua.lviv.iot.spring.first.rest.model.*;
import ua.lviv.iot.spring.first.rest.writer.DroneWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DroneWriterTest {
    DroneManager manager = new DroneManager();
    DroneManager emptyManager = new DroneManager();
    DroneWriter fileWriter = new DroneWriter();
    private static final String SRC_PATH_TEST_JAVA_RESOURCES = "src/test/java/resources/";
    private static final String FILE_DRONES = "FileDrones.csv";
    private static final String EMPTY_FILE_DRONES = "EmptyFileDrones.csv";
    private static final String EXPECTED_FILE_DRONES = "expectedFileDrones.csv";

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

        fileWriter.writeToFile(manager.getDroneList(), SRC_PATH_TEST_JAVA_RESOURCES + FILE_DRONES);
        fileWriter.writeToFile(emptyManager.getDroneList(), SRC_PATH_TEST_JAVA_RESOURCES + EMPTY_FILE_DRONES);
    }

    @AfterAll
    public static void deleteExcessiveFiles() {
        new File(SRC_PATH_TEST_JAVA_RESOURCES + FILE_DRONES).delete();
        new File(SRC_PATH_TEST_JAVA_RESOURCES + EMPTY_FILE_DRONES).delete();
    }

    @Test
    public void testWriteToFileIsEmpty() throws IOException {
        BufferedReader readerEmptyFile = new BufferedReader(new FileReader(SRC_PATH_TEST_JAVA_RESOURCES + EMPTY_FILE_DRONES));
        Assertions.assertNull(readerEmptyFile.readLine());
        readerEmptyFile.close();
    }

    @Test
    public void testWriteToFileForDroneWriter() throws IOException {
        Path filePath = Paths.get(SRC_PATH_TEST_JAVA_RESOURCES + FILE_DRONES);
        Path expectedFilePath = Paths.get(SRC_PATH_TEST_JAVA_RESOURCES + EXPECTED_FILE_DRONES);
        Assertions.assertEquals(-1L, Files.mismatch(filePath, expectedFilePath));
    }
}
