package com.ensa;

import com.ensa.elevators.Elevator;
import com.ensa.elevators.ElevatorFactory;
import com.ensa.elevators.NearElevator;
import com.ensa.elevators.state.ElevatorState;

import java.util.ArrayList;
import java.util.List;


public class Building {
	
	int numberOfFloors;
	List<Elevator> elevators=new ArrayList<Elevator>();

	public Building(int numberOfFloors, String... arguments) {//you can enter many strings as args
		for(int i=0;i<arguments.length;i++) {
			//We create a list of all elevators in the building
			String[] elevatorElements=arguments[i].split(":");
			//the elevator take 2 arg (id,position)
			Elevator elevator=new Elevator(elevatorElements[0],Integer.parseInt(elevatorElements[1]));
			elevators.add(elevator);
					}
	}

	public String requestElevator() {
		// 10 if there is no param
		return NearElevator.getNearElevator(this.elevators,10);
	}
	
	public String requestElevator(int i) {
		
		return NearElevator.getNearElevator(this.elevators,i);
	}


	public void move(String idElavator, String stateElavator) {
			elevators.forEach(e ->{
			if(e.getIdElevator().equals(idElavator)) {
				//when a elevator moves his state changes from stop to up or down
				ElevatorState newState= ElevatorFactory.changeStateFactory(stateElavator);
			    newState.setState(e);
			}
			
		});
		
	}

	public void stopAt(String string, int i) {
		elevators.forEach(e ->{
			if(e.getIdElevator().equals(string)) {
				//when a elevator moves his state changes from stop to up or down
				ElevatorState newState= ElevatorFactory.changeStateFactory("");
			    newState.setState(e);
			    e.setPosition(i);
			}
			
		});
		
	}

	
}
