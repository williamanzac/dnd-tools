package nz.co.fitnet.characterGenerator.data.startingequipment;

import static java.util.stream.Collectors.toList;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Martial;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;
import static nz.co.fitnet.characterGenerator.data.Packs.EXPLORERS_PACK;
import static nz.co.fitnet.characterGenerator.data.Weapons.GREATAXE;
import static nz.co.fitnet.characterGenerator.data.Weapons.HANDAXE;
import static nz.co.fitnet.characterGenerator.data.Weapons.JAVELIN;
import static nz.co.fitnet.characterGenerator.data.Weapons.weaponList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.equipment.EquipmentOption;
import nz.co.fitnet.characterGenerator.api.equipment.StartingEquipment;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class BarbarianStartingEquipment extends StartingEquipment {
	public BarbarianStartingEquipment() {
		// (a) a greataxe or (b) any martial melee weapon
		final EquipmentOption aa = new EquipmentOption("aa", GREATAXE);
		List<Weapon> list = weaponList.stream()
				.filter(weapon -> weapon.getType() == Martial && weapon.getAttackType() == Melee).collect(toList());
		final EquipmentOption ab = new EquipmentOption("ab", 1, list);
		final EquipmentOption a = new EquipmentOption("a", 1, aa, ab);
		// (a) two handaxes or (b) any simple weapon
		final EquipmentOption ba = new EquipmentOption("ba", HANDAXE, HANDAXE);
		list = weaponList.stream().filter(weapon -> weapon.getType() == Simple).collect(toList());
		final EquipmentOption bb = new EquipmentOption("bb", 1, list);
		final EquipmentOption b = new EquipmentOption("b", 1, ba, bb);
		// An explorer’s pack and four javelins
		final EquipmentOption c = new EquipmentOption("c", EXPLORERS_PACK, JAVELIN, JAVELIN, JAVELIN, JAVELIN);
		options.add(a);
		options.add(b);
		options.add(c);
	}
}