package nz.co.fitnet.nameGenerator.data;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.data.names.Dwarf;
import nz.co.fitnet.nameGenerator.data.names.Elf;
import nz.co.fitnet.nameGenerator.data.names.HalfElf;
import nz.co.fitnet.nameGenerator.data.names.Human;

public class Names {
	public static final Dwarf DWARF = new Dwarf();
	public static final Elf ELF = new Elf();
	public static final HalfElf HALF_ELF = new HalfElf();
	public static final Human HUMAN = new Human();

	public static final List<NameDefinitionList> nameList = asList(DWARF, ELF, HALF_ELF, HUMAN);
	public static final Map<String, NameDefinitionList> nameMap = nameList.stream()
			.collect(toMap(k -> k.getName(), v -> v));
}
