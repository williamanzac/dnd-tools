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
 * $Id: ArrowIcon.java,v 1.8 2005/05/16 23:06:56 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Created by IntelliJ IDEA. User: andrewp Date: 4/06/2004 Time: 20:00:46 To change this template use Options | File
 * Templates.
 */
class ArrowIcon implements Icon {

	private final int direction;
	private static final int LENGTH = 5;

	public ArrowIcon(final int direction) {
		this.direction = direction;
	}

	@Override
	public int getIconWidth() {
		return direction == SwingConstants.EAST || direction == SwingConstants.WEST ? LENGTH : 2 * LENGTH;
	}

	@Override
	public int getIconHeight() {
		return direction == SwingConstants.NORTH || direction == SwingConstants.SOUTH ? LENGTH : 2 * LENGTH;
	}

	@Override
	public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
		final Color oldColor = g.getColor();
		final int mid = LENGTH;
		int i = 0;
		int j = 0;

		g.translate(x, y);

		if (c.isEnabled()) {
			g.setColor(c.getForeground());
		} else {
			g.setColor(UIManager.getColor("Button.disabledForeground"));
		}

		switch (direction) {
		case SwingConstants.NORTH:
			for (i = 0; i < LENGTH; i++) {
				g.drawLine(mid - i, i, mid + i, i);
			}
			break;
		case SwingConstants.SOUTH:
			j = 0;
			for (i = LENGTH - 1; i >= 0; i--) {
				g.drawLine(mid - i, j, mid + i, j);
				j++;
			}
			break;
		case SwingConstants.WEST:
			for (i = 0; i < LENGTH; i++) {
				g.drawLine(i, mid - i, i, mid + i);
			}
			break;
		case SwingConstants.EAST:
			j = 0;
			for (i = LENGTH - 1; i >= 0; i--) {
				g.drawLine(j, mid - i, j, mid + i);
				j++;
			}
			break;
		}
		g.translate(-x, -y);
		g.setColor(oldColor);

	}

}
