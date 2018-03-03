package nz.co.fitnet.client.step;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import nz.co.fitnet.characterGenerator.api.Race;

public class RaceListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 800093551975622246L;

	@Override
	public Component getListCellRendererComponent(final JList<? extends Object> list, Object value, final int index,
			final boolean isSelected, final boolean cellHasFocus) {
		if (value instanceof Race) {
			value = join(splitByCharacterTypeCamelCase(((Race) value).getName()), " ");
		}
		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
