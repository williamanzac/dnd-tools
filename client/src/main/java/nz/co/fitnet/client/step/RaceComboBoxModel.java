package nz.co.fitnet.client.step;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.Races;

public class RaceComboBoxModel extends AbstractListModel<Race> implements MutableComboBoxModel<Race> {
	private static final long serialVersionUID = 6017746291595616798L;

	private final List<Race> objects = Races.raceList;
	private Object selectedObject;

	/**
	 * Constructs an empty DefaultComboBoxModel object.
	 */
	public RaceComboBoxModel() {
	}

	// implements javax.swing.ComboBoxModel
	/**
	 * Set the value of the selected item. The selected item may be null.
	 *
	 * @param anObject
	 *            The combo box value or null for no selection.
	 */
	@Override
	public void setSelectedItem(final Object anObject) {
		if (selectedObject != null && !selectedObject.equals(anObject) || selectedObject == null && anObject != null) {
			selectedObject = anObject;
			fireContentsChanged(this, -1, -1);
		}
	}

	// implements javax.swing.ComboBoxModel
	@Override
	public Object getSelectedItem() {
		return selectedObject;
	}

	// implements javax.swing.ListModel
	@Override
	public int getSize() {
		return objects.size();
	}

	// implements javax.swing.ListModel
	@Override
	public Race getElementAt(final int index) {
		if (index >= 0 && index < objects.size()) {
			return objects.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Returns the index-position of the specified object in the list.
	 *
	 * @param anObject
	 * @return an int representing the index position, where 0 is the first position
	 */
	public int getIndexOf(final Object anObject) {
		return objects.indexOf(anObject);
	}

	// implements javax.swing.MutableComboBoxModel
	@Override
	public void addElement(final Race anObject) {
		objects.add(anObject);
		fireIntervalAdded(this, objects.size() - 1, objects.size() - 1);
		if (objects.size() == 1 && selectedObject == null && anObject != null) {
			setSelectedItem(anObject);
		}
	}

	// implements javax.swing.MutableComboBoxModel
	@Override
	public void insertElementAt(final Race anObject, final int index) {
		objects.add(index, anObject);
		fireIntervalAdded(this, index, index);
	}

	// implements javax.swing.MutableComboBoxModel
	@Override
	public void removeElementAt(final int index) {
		if (getElementAt(index) == selectedObject) {
			if (index == 0) {
				setSelectedItem(getSize() == 1 ? null : getElementAt(index + 1));
			} else {
				setSelectedItem(getElementAt(index - 1));
			}
		}

		objects.remove(index);

		fireIntervalRemoved(this, index, index);
	}

	// implements javax.swing.MutableComboBoxModel
	@Override
	public void removeElement(final Object anObject) {
		final int index = objects.indexOf(anObject);
		if (index != -1) {
			removeElementAt(index);
		}
	}

	/**
	 * Empties the list.
	 */
	public void removeAllElements() {
		if (objects.size() > 0) {
			final int firstIndex = 0;
			final int lastIndex = objects.size() - 1;
			objects.clear();
			selectedObject = null;
			fireIntervalRemoved(this, firstIndex, lastIndex);
		} else {
			selectedObject = null;
		}
	}
}
