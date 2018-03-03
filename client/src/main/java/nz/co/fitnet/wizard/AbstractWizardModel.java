/**
 * Wizard Framework
 * Copyright 2004 - 2005 Andrew Pietsch
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * $Id: AbstractWizardModel.java,v 1.13 2005/05/22 07:13:28 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class provides a base for implementors of {@link WizardModel}. It provides the basic
 * {@link PropertyChangeListener} management and fires the appropriate events when the various properties are changed.
 * <p>
 * Subclasses will generally override {@link #refreshModelState} to update the state of the various model properties.
 */
public abstract class AbstractWizardModel implements WizardModel {
	private WizardStep activeStep;
	private boolean previousAvailable;
	private boolean nextAvailable;
	private boolean lastAvailable;
	private boolean cancelAvailable;
	private boolean lastVisible = true;
	private final PropertyChangeSupport pcs;

	private final PropertyChangeListener completeListener = evt -> {
		if (evt.getPropertyName().equals("complete")) {
			refreshModelState();
		}
	};

	public AbstractWizardModel() {
		pcs = new PropertyChangeSupport(this);
	}

	/**
	 * Gets the current active step the wizard should display.
	 *
	 * @return the active step.
	 */
	@Override
	public WizardStep getActiveStep() {
		return activeStep;
	}

	/**
	 * Provided for subclasses to change the current step in response to a call to {@link #nextStep} or its related
	 * methods.
	 *
	 * @param activeStep
	 *            the new step.
	 */
	protected void setActiveStep(final WizardStep activeStep) {
		if (this.activeStep != activeStep) {
			final WizardStep old = this.activeStep;
			this.activeStep = activeStep;
			pcs.firePropertyChange("activeStep", old, activeStep);
			refreshModelState();
		}
	}

	/**
	 * Checks if the previous button should be enabled.
	 *
	 * @return <tt>true</tt> if the previou button should be enabled, <tt>false</tt> otherwise.
	 */
	@Override
	public boolean isPreviousAvailable() {
		return previousAvailable;
	}

	/**
	 * Checks if the next button should be enabled.
	 *
	 * @return <tt>true</tt> if the next button should be enabled, <tt>false</tt> otherwise.
	 */
	@Override
	public boolean isNextAvailable() {
		return nextAvailable;
	}

	/**
	 * Checks if the last button should be enabled.
	 *
	 * @return <tt>true</tt> if the last button should be enabled, <tt>false</tt> otherwise.
	 * @see #isLastVisible
	 */
	@Override
	public boolean isLastAvailable() {
		return lastAvailable;
	}

	/**
	 * Configures if the previous button should be enabled.
	 *
	 * @param previousAvailable
	 *            <tt>true</tt> to enable the previous button, <tt>false</tt> otherwise.
	 */
	protected void setPreviousAvailable(final boolean previousAvailable) {
		if (this.previousAvailable != previousAvailable) {
			final boolean old = this.previousAvailable;
			this.previousAvailable = previousAvailable;
			pcs.firePropertyChange("previousAvailable", old, previousAvailable);
		}
	}

	/**
	 * Configures if the next button should be enabled.
	 *
	 * @param nextAvailable
	 *            <tt>true</tt> to enable the next button, <tt>false</tt> otherwise.
	 */
	protected void setNextAvailable(final boolean nextAvailable) {
		if (this.nextAvailable != nextAvailable) {
			final boolean old = this.nextAvailable;
			this.nextAvailable = nextAvailable;
			pcs.firePropertyChange("nextAvailable", old, nextAvailable);
		}
	}

	/**
	 * Configures if the last button should be enabled.
	 *
	 * @param lastAvailable
	 *            <tt>true</tt> to enable the last button, <tt>false</tt> otherwise.
	 */
	protected void setLastAvailable(final boolean lastAvailable) {
		if (this.lastAvailable != lastAvailable) {
			final boolean old = this.lastAvailable;
			this.lastAvailable = lastAvailable;
			pcs.firePropertyChange("lastAvailable", old, lastAvailable);
		}
	}

	/**
	 * Configures if the cncel button should be enabled.
	 *
	 * @param cancelAvailable
	 *            <tt>true</tt> to enable the cancel button, <tt>false</tt> otherwise.
	 */
	protected void setCancelAvailable(final boolean cancelAvailable) {
		if (this.cancelAvailable != cancelAvailable) {
			final boolean old = this.cancelAvailable;
			this.cancelAvailable = cancelAvailable;
			pcs.firePropertyChange("cancelAvailable", old, cancelAvailable);
		}
	}

	/**
	 * Checks if the last button should be displayed. This method should only return true if the
	 * {@link #isLastAvailable} will return true at any point. Returning false will prevent the last button from
	 * appearing on the wizard at all.
	 *
	 * @return <tt>true</tt> if the previou last should be displayed, <tt>false</tt> otherwise.
	 */
	@Override
	public boolean isLastVisible() {
		return lastVisible;
	}

	/**
	 * Configures if the last button should be displayed.
	 *
	 * @param lastVisible
	 *            <tt>true</tt> to display the last button, <tt>false</tt> otherwise.
	 * @see #isLastVisible
	 */
	public void setLastVisible(final boolean lastVisible) {
		if (this.lastVisible != lastVisible) {
			final boolean old = this.lastVisible;
			this.lastVisible = lastVisible;
			pcs.firePropertyChange("lastVisible", old, lastVisible);
		}
	}

	/**
	 * This is an empty method that is intended for subclasses to override to update their various properties based on
	 * the active step.
	 */
	@Override
	public void refreshModelState() {
	}

	/**
	 * Adds a {@link PropertyChangeListener} to this model.
	 *
	 * @param listener
	 *            the listener to add.
	 */
	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a {@link PropertyChangeListener} from this model.
	 *
	 * @param listener
	 *            the listener to remove.
	 */
	@Override
	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	/**
	 * Adds a {@link PropertyChangeListener} to this model.
	 *
	 * @param propertyName
	 *            the property to listen to.
	 * @param listener
	 *            the listener to add.
	 */
	@Override
	public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * Removes a {@link PropertyChangeListener} from this model.
	 *
	 * @param propertyName
	 *            the property to stop listening to.
	 * @param listener
	 *            the listener to remove.
	 */
	@Override
	public void removePropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(propertyName, listener);
	}

	/**
	 * Adds a listener to the "complete" property of the {@link WizardStep}. Any changes to this property will in
	 * automatically invoke {@link #refreshModelState()}.
	 *
	 * @param step
	 *            the {@link WizardStep} to monitor.
	 */
	protected void addCompleteListener(final WizardStep step) {
		step.addPropertyChangeListener(completeListener);
	}
}
