package nz.co.fitnet.characterGenerator.api;

import static java.lang.Math.floor;
import static java.util.stream.Collectors.toList;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Shield;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.equipment.ArmourType;
import nz.co.fitnet.characterGenerator.api.equipment.CharacterItem;
import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;
import nz.co.fitnet.characterGenerator.data.races.Dwarf;

public class Character {
	private int height;
	private int weight;
	private Race race;
	private Size size;
	private int ac = 10;
	private int age;
	private String name;
	private Gender gender;
	private boolean inspiration;
	private String personalityTrait;
	private String ideal;
	private String bond;
	private String flaw;
	private final Money money = new Money();

	private final List<Language> languages = new ArrayList<>();
	private final Map<MovementType, Integer> speed = new HashMap<>();
	private final Map<Ability, Integer> abilityScores = new HashMap<>();
	private final Map<Ability, Integer> abilityMods = new HashMap<>();
	private final List<CharacterItem> equipment = new ArrayList<>();
	private final Map<Sense, Integer> senses = new HashMap<>();
	private final List<DamageType> damageResistances = new ArrayList<>();
	private final List<DamageType> damageImmunities = new ArrayList<>();
	private final List<Weapon> proficientWeapons = new ArrayList<>();
	private final List<WeaponType> proficientWeaponTypes = new ArrayList<>();
	private final List<Tool> proficientTools = new ArrayList<>();
	private final List<Armour> proficientArmours = new ArrayList<>();
	private final List<ArmourType> proficientArmourTypes = new ArrayList<>();
	private final List<Ability> savingThrowAdvantages = new ArrayList<>();

	public int getAbilityScoreModifier(final Ability ability) {
		return (int) floor((getAbilityScore(ability) - 10) / 2);
	}

	public int getAbilityScore(final Ability ability) {
		int score = abilityScores.get(ability);

		if (race != null && race.getAbilityMods().containsKey(ability)) {
			score += race.getAbilityMods().get(ability);
		}
		if (abilityMods.containsKey(ability)) {
			score += abilityMods.get(ability);
		}
		return score;
	}

	public void setAbilityMod(final Ability ability, final int mod) {
		abilityMods.put(ability, mod);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(final int weight) {
		this.weight = weight;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(final Race race) {
		this.race = race;
	}

	public Map<Ability, Integer> getAbilityScores() {
		return abilityScores;
	}

	public Map<Ability, Integer> getAbilityMods() {
		return abilityMods;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public List<Language> getKnownLanguages() {
		if (race == null) {
			return getLanguages();
		}
		final List<Language> list = Stream.of(race.getKnownLanguages(), languages).flatMap(Collection::stream)
				.collect(toList());
		return list;
	}

	public void addKnownLanguage(final Language language) {
		languages.add(language);
	}

	public int getMovementSpeed(final MovementType type) {
		int value = 0;
		if (speed.containsKey(type)) {// movement type has been overridden
			value = speed.get(type);
		}
		if (value == 0) {
			return value;
		}
		final Armour equippedArmour = getEquippedArmour();
		// character has heavy armour equipped
		if (equippedArmour != null && equippedArmour.getType() == ArmourType.Heavy) {
			final int minStr = equippedArmour.getStrength();
			final int str = getAbilityScore(Ability.STR);
			// character strength is less then the minimum required for this armour and the character is not a dwarf
			if (str < minStr && !(race instanceof Dwarf)) {
				value -= 10;
			}
		}
		return value;
	}

	public void setMovementSpeed(final MovementType type, final int speed) {
		this.speed.put(type, speed);
	}

	public Size getSize() {
		return size;
	}

	public void setSize(final Size size) {
		this.size = size;
	}

	public List<CharacterItem> getEquipment() {
		return equipment;
	}

	public List<CharacterItem> getEquipped() {
		final List<CharacterItem> list = equipment.stream().filter(CharacterItem::isEquipped).collect(toList());
		return list;
	}

	public Armour getEquippedArmour() {
		final Armour item = equipment.stream().filter(CharacterItem::isEquipped).map(CharacterItem::getItem)
				.filter(e -> e instanceof Armour).map(a -> (Armour) a).filter(a -> a.getType() != Shield).findFirst()
				.orElse(null);
		return item;
	}

	public boolean hasSense(final Sense sense) {
		return senses.containsKey(sense);
	}

	public int getSense(final Sense sense) {
		if (senses.containsKey(sense)) {
			return senses.get(sense);
		}
		return 0;
	}

	public Map<Sense, Integer> getSenses() {
		return senses;
	}

	public Map<MovementType, Integer> getSpeed() {
		return speed;
	}

	public boolean isResistant(final DamageType type) {
		return damageResistances.contains(type);
	}

	public boolean isImmune(final DamageType type) {
		return damageImmunities.contains(type);
	}

	public boolean isProficientWith(final Weapon weapon) {
		return proficientWeapons.contains(weapon) || proficientWeaponTypes.contains(weapon.getType());
	}

	public boolean isProficientWith(final Tool tool) {
		return proficientTools.contains(tool);
	}

	public List<DamageType> getDamageResistances() {
		return damageResistances;
	}

	public List<DamageType> getDamageImmunities() {
		return damageImmunities;
	}

	public List<Weapon> getProficientWeapons() {
		return proficientWeapons;
	}

	public List<WeaponType> getProficientWeaponTypes() {
		return proficientWeaponTypes;
	}

	public List<Tool> getProficientTools() {
		return proficientTools;
	}

	public List<Armour> getProficientArmours() {
		return proficientArmours;
	}

	public List<ArmourType> getProficientArmourTypes() {
		return proficientArmourTypes;
	}

	public int getAC() {
		return ac;
	}

	public void setAC(final int ac) {
		this.ac = ac;
	}

	public List<Ability> getSavingThrowAdvantages() {
		return savingThrowAdvantages;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	public boolean isInspiration() {
		return inspiration;
	}

	public void setInspiration(final boolean inspiration) {
		this.inspiration = inspiration;
	}

	public String getPersonalityTrait() {
		return personalityTrait;
	}

	public void setPersonalityTrait(final String personalityTrait) {
		this.personalityTrait = personalityTrait;
	}

	public String getIdeal() {
		return ideal;
	}

	public void setIdeal(final String ideal) {
		this.ideal = ideal;
	}

	public String getBond() {
		return bond;
	}

	public void setBond(final String bond) {
		this.bond = bond;
	}

	public String getFlaw() {
		return flaw;
	}

	public void setFlaw(final String flaw) {
		this.flaw = flaw;
	}

	public Money getMoney() {
		return money;
	}
}
