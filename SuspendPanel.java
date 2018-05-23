package project1;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import project1.StopWatchGUI.ButtonListener;

/************************************************************************
 * This class makes the Graphical User Interface for the Suspend Button for the
 * Stopwatch
 *
 * @author Kelly Hancox and Isfar Baset
 * @version May 23, 2018
 ************************************************************************/

public class SuspendPanel extends JPanel {

		private StopWatchGUI p1;
		private StopWatchGUI p2;
		private StopWatchGUI p3;

		StopWatch s;

		private JButton suspend;

		ButtonListener buttonListener = new ButtonListener();

		public SuspendPanel() {

			p1 = new StopWatchGUI();
			p2 = new StopWatchGUI();
			p3 = new StopWatchGUI();
			suspend = new JButton("Suspend");

			add(p1);
			add(p2);
			add(p3);

			setLayout(new GridBagLayout());
			GridBagConstraints placing;
			placing = new GridBagConstraints();

			suspend.setPreferredSize(new Dimension(200, 60));

			placing.gridx = 1;
			placing.gridy = 5;
			add(suspend, placing);

			suspend.addActionListener(buttonListener);

		}

		private class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == suspend) {
					s = new StopWatch();
					if (s.getSuspended()) {
						p1.disableButton(false);
						p2.disableButton(false);
						p3.disableButton(false);
						s.suspend(false);

					} else if (!s.getSuspended()) {
						p1.disableButton(true);
						p2.disableButton(true);
						p3.disableButton(true);
						s.suspend(true);
					}
				}

			}
		}
	}



