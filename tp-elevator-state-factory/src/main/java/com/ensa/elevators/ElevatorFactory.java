package com.ensa.elevators;

import com.ensa.elevators.state.DownState;
import com.ensa.elevators.state.ElevatorState;
import com.ensa.elevators.state.StopState;
import com.ensa.elevators.state.UpState;

public abstract class ElevatorFactory {

	public static ElevatorState changeStateFactory(String stateElavator) {
		// generate a class using a parameter
		if(stateElavator=="UP") {
			return new UpState();
		}else if(stateElavator=="DOWN") {
			return new DownState();
		}else {
			return new StopState();
		}
	}
}
