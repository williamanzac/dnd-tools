package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Speed;

import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Speed;

public class SpeedTrait extends Trait<Speed> {
	public SpeedTrait(final MovementType movementType, final int speed) {
		super(Speed, new Speed(movementType, speed));
	}
}
