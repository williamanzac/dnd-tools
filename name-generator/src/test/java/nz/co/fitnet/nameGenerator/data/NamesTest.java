package nz.co.fitnet.nameGenerator.data;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import nz.co.fitnet.nameGenerator.api.NameDefinitionList;

public class NamesTest {
	@Test
	public void verifyList() {
		final List<NameDefinitionList> namelist = Names.nameList;
		System.out.println(namelist);
	}

	@Test
	public void verifyMap() {
		final Map<String, NameDefinitionList> namemap = Names.nameMap;
		System.out.println(namemap);
	}
}
