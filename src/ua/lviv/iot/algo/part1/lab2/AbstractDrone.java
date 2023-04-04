package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public abstract class AbstractDrone {
    private double currentSpeed;
    private double currentAltitude;

    public abstract void flyAt(double speedMetersPerMinute, double altitude);

    public abstract void getMaxFlyingDistanceAtCurrentSpeed();

    public String toString() {
        return "currentSpeed=" + currentSpeed + ", currentAltitude=" + currentAltitude;
    }
}
