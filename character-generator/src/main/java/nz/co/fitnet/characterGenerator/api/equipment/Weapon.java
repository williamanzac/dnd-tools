package nz.co.fitnet.characterGenerator.api.equipment;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import nz.co.fitnet.characterGenerator.api.DamageType;

public abstract class Weapon extends Item {
	private final WeaponType type;
	private final List<WeaponProperty> properties = new ArrayList<>();
	private final DamageType damageType;
	private final String damageDice;
	private final String twohandDamageDice;
	private final WeaponRange range;
	private final AttackType attackType;

	public Weapon(final double weight, final WeaponType type, final AttackType attackType, final DamageType damageType,
			final String damageDice, final WeaponRange range, final double cost, final WeaponProperty... properties) {
		this(weight, type, attackType, damageType, damageDice, null, range, cost, properties);
	}

	public Weapon(final double weight, final WeaponType type, final AttackType attackType, final DamageType damageType,
			final String damageDice, final String twohandDamageDice, final WeaponRange range, final double cost,
			final WeaponProperty... properties) {
		super(weight, cost);
		this.type = type;
		this.properties.addAll(asList(properties));
		this.damageType = damageType;
		this.damageDice = damageDice;
		this.twohandDamageDice = twohandDamageDice;
		this.range = range;
		this.attackType = attackType;
	}

	public WeaponType getType() {
		return type;
	}

	public List<WeaponProperty> getProperties() {
		return properties;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public String getDamageDice() {
		return damageDice;
	}

	public WeaponRange getRange() {
		return range;
	}

	public String getTwohandDamageDice() {
		return twohandDamageDice;
	}

	public AttackType getAttackType() {
		return attackType;
	}
}
