package com.ensa.elevators.state;

import com.ensa.elevators.Elevator;

import static com.ensa.Constants.UP;

public class UpState implements com.ensa.elevators.state.ElevatorState {

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return UP;
	}
	@Override
	public void setState(Elevator e) {
		e.setElvatorState(this);	
	}
	@Override
	public int calculateDIstance(Elevator e,int floor) {
		if(floor<e.getPosition()){
			return 20-(floor+e.getPosition());
		}
		return Math.abs(e.getPosition()-floor);
	}

}
