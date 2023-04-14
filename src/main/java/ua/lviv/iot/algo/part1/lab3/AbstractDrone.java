package ua.lviv.iot.algo.part1.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public abstract class AbstractDrone {
    private double currentSpeed;
    private double currentAltitude;

    public abstract void flyAt(double speedMetersPerMinute, double altitude);

    public abstract void calculateMaxFlyingDistanceAtCurrentSpeed();

    public String getHeaders() {
        return ",currentSpeed,currentAltitude";
    }

    public String toCSV() {
        return "," + currentSpeed + "," + currentAltitude + ",";
    }
}
