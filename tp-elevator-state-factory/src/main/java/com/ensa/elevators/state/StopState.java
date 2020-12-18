package com.ensa.elevators.state;

import com.ensa.elevators.Elevator;

public class StopState implements ElevatorState{

	public StopState() {}
	
	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return "STOP";
	}
	@Override
	public void setState(Elevator e) {
		e.setElvatorState(this);
	}

	@Override
	public int calculateDIstance(Elevator e,int floor) {
		// TODO Auto-generated method stub
		return -1;
	}


}
