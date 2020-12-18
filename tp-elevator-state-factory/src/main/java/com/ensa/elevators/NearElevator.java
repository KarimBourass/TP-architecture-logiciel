package com.ensa.elevators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class NearElevator {
	
	public static String getNearElevator(List<Elevator> elevators,int position) {
		// we calculate the distance that an elevator must take from his start until it arrives to a costumer
		List<Integer> distances = new ArrayList<Integer>();
		elevators.forEach(e ->{
			//we add every calculated distance to a list
			if(e.getElvatorState().getState()!="STOP")distances.add(e.getElvatorState().calculateDIstance(e, position));
		});
		return elevators.get(distances.indexOf(Collections.min(distances))).getIdElevator();
	}

}
