package com.ensa.elevators.state;

import com.ensa.elevators.Elevator;

import static com.ensa.Constants.DOWN;

public class DownState implements com.ensa.elevators.state.ElevatorState {

    @Override
    public String getState() {
        // TODO Auto-generated method stub
        return DOWN;
    }

    @Override
    public void setState(Elevator e) {
        e.setElvatorState(this);

    }

    @Override
    public int calculateDIstance(Elevator e,int floor) {
        if(floor>e.getPosition()) {
            return floor+e.getPosition();
        }
        return Math.abs(e.getPosition()-floor);
    }

}