package nz.co.fitnet.characterGenerator.api.equipment;

import java.util.ArrayList;
import java.util.List;

public class StartingEquipment {
	protected final List<EquipmentOption> options = new ArrayList<>();

	public List<EquipmentOption> getOptions() {
		return options;
	}

	public String getName() {
		return getClass().getSimpleName();
	}
}
