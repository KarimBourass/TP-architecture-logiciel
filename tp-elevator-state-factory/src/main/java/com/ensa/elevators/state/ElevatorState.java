package com.ensa.elevators.state;
import com.ensa.elevators.Elevator;

public interface ElevatorState {

    public String getState();
    public void setState(Elevator e);
    public int calculateDIstance(Elevator e,int floor);
}
