package com.ensa.elevators.state;

import com.ensa.elevators.Elevator;

import static com.ensa.Constants.RESTING;

public class RestingElevator implements com.ensa.elevators.state.ElevatorState {

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return RESTING;
	}

	@Override
	public void setState(Elevator e) {
		e.setElvatorState(this);
		
	}

	@Override
	public int calculateDIstance(Elevator e,int floor) {
		// TODO Auto-generated method stub
		return Math.abs(e.getPosition()-floor);
	}

}
