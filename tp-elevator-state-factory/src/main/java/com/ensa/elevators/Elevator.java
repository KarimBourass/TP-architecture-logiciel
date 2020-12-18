package com.ensa.elevators;


import com.ensa.elevators.state.ElevatorState;
import com.ensa.elevators.state.RestingElevator;

public class Elevator {
	
	private String idElevator;
	private int position;
	private ElevatorState elvatorState;
	
	public Elevator(String idElevator, int position) {
		this.setIdElevator(idElevator);
		this.position=position;
		// default position is stop
		this.elvatorState=new RestingElevator();
	}
	

	public ElevatorState getElvatorState() {
		return elvatorState;
	}

	public void setElvatorState(ElevatorState elvatorState) {
		this.elvatorState = elvatorState;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}


	public String getIdElevator() {
		return idElevator;
	}


	public void setIdElevator(String idElevator) {
		this.idElevator = idElevator;
	}
	

}
