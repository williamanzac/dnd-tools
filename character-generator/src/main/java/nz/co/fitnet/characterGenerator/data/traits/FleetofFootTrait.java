package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.MovementType.walk;

import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;

public class FleetofFootTrait extends SpeedTrait {
	public FleetofFootTrait() {
		super(walk, 35);
	}
}
