package nz.co.fitnet.characterGenerator.api;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;
import nz.co.fitnet.characterGenerator.api.equipment.ArmourType;
import nz.co.fitnet.characterGenerator.api.equipment.Tool;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;
import nz.co.fitnet.characterGenerator.api.skills.Skill;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AdditionalHitPointsTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.ArmourProficiencyTrait;
import nz.co.fitnet.characterGenerator.api.traits.DamageImmunityTrait;
import nz.co.fitnet.characterGenerator.api.traits.DamageResistanceTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.MeasurementTrait;
import nz.co.fitnet.characterGenerator.api.traits.SenseTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SkillProficiencyTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.api.traits.ToolProficiencyTrait;
import nz.co.fitnet.characterGenerator.api.traits.Trait;
import nz.co.fitnet.characterGenerator.api.traits.WeaponProficiencyTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;

public abstract class Race {

	protected List<Trait<?>> traits = new ArrayList<>();

	public String getName() {
		return getClass().getSimpleName();
	}

	public Measurement getHeight() {
		final Measurement measurement = traits.stream().filter(t -> t instanceof HeightTrait).map(t -> (HeightTrait) t)
				.map(HeightTrait::getThing).findFirst().orElse(null);
		return measurement;
	}

	public Measurement getWeight() {
		final Measurement measurement = traits.stream().filter(t -> t instanceof WeightTrait).map(t -> (WeightTrait) t)
				.map(MeasurementTrait::getThing).findFirst().orElse(null);
		return measurement;
	}

	public Map<Ability, Integer> getAbilityMods() {
		final Map<Ability, Integer> abilityMods = traits.stream().filter(t -> t instanceof AbilityModifiersTrait)
				.map(t -> (AbilityModifiersTrait) t).map(Trait::getThing).map(AbilityModifiers::getAbilityModifiers)
				.map(Map::entrySet).flatMap(Collection::stream)
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::max));
		return abilityMods;
	}

	public int getAdditionalMods() {
		final int additionalMods = traits.stream().filter(t -> t instanceof AbilityModifiersTrait)
				.map(t -> (AbilityModifiersTrait) t).map(Trait::getThing).map(AbilityModifiers::getAdditionalModifiers)
				.reduce((t, n) -> t + n).get().intValue();
		return additionalMods;
	}

	public Age getAge() {
		final Age age = traits.stream().filter(t -> t instanceof AgeTrait).map(t -> (AgeTrait) t).map(Trait::getThing)
				.findFirst().orElse(null);
		return age;
	}

	public List<Language> getKnownLanguages() {
		final List<Language> languages = traits.stream().filter(t -> t instanceof KnownLanguagesTrait)
				.map(t -> (KnownLanguagesTrait) t).map(Trait::getThing).map(KnownLanguages::getLanguages)
				.flatMap(Collection::stream).collect(toList());
		return languages;
	}

	public int getAdditionalLanguages() {
		final int additionalLanguages = traits.stream().filter(t -> t instanceof KnownLanguagesTrait)
				.map(t -> (KnownLanguagesTrait) t).map(Trait::getThing).map(KnownLanguages::getAdditionalLanguages)
				.reduce((t, n) -> t + n).get().intValue();
		return additionalLanguages;
	}

	public Size getSize() {
		final Size size = traits.stream().filter(t -> t instanceof SizeTrait).map(t -> (SizeTrait) t)
				.map(Trait::getThing).findFirst().orElse(null);
		return size;
	}

	public Map<MovementType, Integer> getMovementSpeeds() {
		final Map<MovementType, Integer> map = traits.stream().filter(t -> t instanceof SpeedTrait)
				.map(t -> (SpeedTrait) t).map(Trait::getThing)
				.collect(toMap(Speed::getType, Speed::getSpeed, Integer::max));
		return map;
	}

	public Map<Sense, Integer> getSenses() {
		final Map<Sense, Integer> map = traits.stream().filter(t -> t instanceof SenseTrait).map(t -> (SenseTrait) t)
				.map(Trait::getThing).map(Map::entrySet).flatMap(Collection::stream)
				.collect(toMap(Entry::getKey, Entry::getValue, Integer::max));
		return map;
	}

	public List<DamageType> getDamageResistances() {
		final List<DamageType> list = traits.stream().filter(t -> t instanceof DamageResistanceTrait)
				.map(t -> (DamageResistanceTrait) t).map(Trait::getThing).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public List<DamageType> getDamageImmunities() {
		final List<DamageType> list = traits.stream().filter(t -> t instanceof DamageImmunityTrait)
				.map(t -> (DamageImmunityTrait) t).map(Trait::getThing).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public List<Weapon> getWeaponProficiencies() {
		final List<Weapon> list = traits.stream().filter(t -> t instanceof WeaponProficiencyTrait)
				.map(t -> (WeaponProficiencyTrait) t).map(Trait::getThing)
				.map(WeaponProficiencies::getProficientWeapons).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public List<WeaponType> getWeaponTypeProficiencies() {
		final List<WeaponType> list = traits.stream().filter(t -> t instanceof WeaponProficiencyTrait)
				.map(t -> (WeaponProficiencyTrait) t).map(Trait::getThing)
				.map(WeaponProficiencies::getProficientWeaponTypes).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public List<Tool> getToolProficiencies() {
		final List<Tool> list = traits.stream().filter(t -> t instanceof ToolProficiencyTrait)
				.map(t -> (ToolProficiencyTrait) t).map(Trait::getThing).map(ToolProficiencies::getProficientTools)
				.flatMap(Collection::stream).collect(toList());
		return list;
	}

	public int getNumberToolProficiencies() {
		final int additionalMods = traits.stream().filter(t -> t instanceof ToolProficiencyTrait)
				.map(t -> (ToolProficiencyTrait) t).map(Trait::getThing)
				.map(ToolProficiencies::getNumberToolProficiencies).reduce((t, n) -> t + n).orElse(0);
		return additionalMods;
	}

	public List<Armour> getArmourProficiencies() {
		final List<Armour> list = traits.stream().filter(t -> t instanceof ArmourProficiencyTrait)
				.map(t -> (ArmourProficiencyTrait) t).map(Trait::getThing)
				.map(ArmourProficiencies::getProficientArmours).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public List<ArmourType> getArmourTypeProficiencies() {
		final List<ArmourType> list = traits.stream().filter(t -> t instanceof ArmourProficiencyTrait)
				.map(t -> (ArmourProficiencyTrait) t).map(Trait::getThing)
				.map(ArmourProficiencies::getProficientArmourTypes).flatMap(Collection::stream).collect(toList());
		return list;
	}

	public int getAdditionalHP() {
		final Integer value = traits.stream().filter(t -> t instanceof AdditionalHitPointsTrait)
				.map(t -> (AdditionalHitPointsTrait) t).map(AdditionalHitPointsTrait::getThing).reduce((t, n) -> t + n)
				.orElse(0);
		return value;
	}

	public List<Skill> getSkillProficiencies() {
		final List<Skill> list = traits.stream().filter(t -> t instanceof SkillProficiencyTrait)
				.map(t -> (SkillProficiencyTrait) t).map(Trait::getThing).map(SkillProficiencies::getProficientSkills)
				.flatMap(Collection::stream).collect(toList());
		return list;
	}

	public int getNumberSkillProficiencies() {
		final int additionalMods = traits.stream().filter(t -> t instanceof SkillProficiencyTrait)
				.map(t -> (SkillProficiencyTrait) t).map(Trait::getThing)
				.map(SkillProficiencies::getNumberSkillProficiencies).reduce((t, n) -> t + n).orElse(0);
		return additionalMods;
	}

	public List<Trait<?>> getTraits() {
		return traits;
	}
}
