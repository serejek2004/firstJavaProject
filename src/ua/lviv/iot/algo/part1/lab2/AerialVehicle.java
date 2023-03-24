package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
// @ToString (of = {"currentSpeed", "currentAltitude"})

public abstract class AerialVehicle {
    private double currentSpeed;
    private double currentAltitude;

    public abstract void flyAt(double speedMetersPerMinute, double altitude);

     public String toString() {
       return "currentSpeed=" + currentSpeed + ", currentAltitude=" + currentAltitude;
    }
}
