package project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;

import javax.swing.*; //<--this is using the timer class
import javax.swing.Timer;

import java.awt.*;

import java.io.*;
import java.text.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.util.Scanner;

/************************************************************************
 * This class makes the Graphical User Interface for the Stopwatch.
 *
 * @author Kelly Hancox and Isfar Baset
 * @version May 23, 2018
 ************************************************************************/
public class StopWatchGUI extends JPanel {

	private JButton start;
	private JButton stop;
	private JButton add;
	private JButton subtract;
	private JButton reset;
	private static JButton suspend;
	private JButton save;

	private JLabel time;

	private JTextField inputField;

	/** menu items */
	private JMenuItem quit;
	private JMenuItem load;
	private JMenuItem save1;

	int timerDelay;

	ButtonListener buttonListener = new ButtonListener();

	private StopWatch stopWatchTimer;
	private Timer javaTimer;
	private TimerListener timer;

	String startTime;

	final JFileChooser fc = new JFileChooser();

	StopWatch s;

	public StopWatchGUI() {

		stopWatchTimer = new StopWatch(0, 0, 0);
		timer = new TimerListener();
		javaTimer = new Timer(500, timer);

		setLayout(new GridBagLayout());
		GridBagConstraints loc;
		loc = new GridBagConstraints();

		s = new StopWatch();

		time = new JLabel("00:00:000");

		inputField = new JTextField(10);

		start = new JButton("Start");
		stop = new JButton("Stop");
		add = new JButton("Add");
		subtract = new JButton("Subtract");
		reset = new JButton("Reset");

		start.addActionListener(buttonListener);
		stop.addActionListener(buttonListener);
		add.addActionListener(buttonListener);
		subtract.addActionListener(buttonListener);
		reset.addActionListener(buttonListener);

		loc.gridx = 0;
		loc.gridy = 0;
		loc.gridwidth = 2;
		add(time, loc);

		loc.gridx = 0;
		loc.gridy = 1;
		loc.gridwidth = 2;
		add(inputField, loc);

		loc.gridx = 0;
		loc.gridy = 2;
		loc.gridwidth = 1;
		add(start, loc);

		loc.gridx = 0;
		loc.gridy = 3;
		loc.gridwidth = 1;
		add(add, loc);

		loc.gridx = 1;
		loc.gridy = 2;
		loc.gridwidth = 1;
		add(stop, loc);

		loc.gridx = 1;
		loc.gridy = 3;
		loc.gridwidth = 1;
		add(subtract, loc);

		loc.gridx = 0;
		loc.gridy = 4;
		loc.gridwidth = 2;
		add(reset, loc);

		JMenuBar menubar = new JMenuBar();
		add(menubar);
		JMenu file = new JMenu("File");
		menubar.add(file);
		load = new JMenuItem("Load");
		file.add(load);
		save1 = new JMenuItem("Save");
		file.add(save1);
		quit = new JMenuItem("Quit");
		file.add(quit);

		load.addActionListener(buttonListener);
		quit.addActionListener(buttonListener);
		save1.addActionListener(buttonListener);

	}

	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// update the stopwatch object
			s.add(500);
			time.setText(s.toString());

		}

	}

	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == start) {
				javaTimer.start();
			}

			if (e.getSource() == stop) {
				javaTimer.stop();
			}

			if (e.getSource() == add) {
				startTime = inputField.getText();

				if (Integer.valueOf(startTime) < 0) {
					JOptionPane.showMessageDialog(null, "Sorry, Negative Input Not Allowed.");
				}

				else {
					StopWatch s2 = new StopWatch(startTime);
					s.add(s2);
					time.setText(s.toString());
				}
			}

			if (e.getSource() == subtract) {
				startTime = inputField.getText();

				if (Integer.valueOf(startTime) < 0) {
					JOptionPane.showMessageDialog(null, "Sorry, Negative Input Not Allowed.");
				}

				else {
					StopWatch s2 = new StopWatch(startTime);
					s.sub(s2);
					time.setText(s.toString());

				}

			}

			if (e.getSource() == reset) {
				javaTimer.stop();
				s = new StopWatch(0, 0, 0);
				time.setText(s.toString());
			}

			if (e.getSource() == suspend) {
				if (s.getSuspended()) {
					disableButton(true);
					s.suspend(false);

				} else if (!s.getSuspended()) {
					disableButton(false);
					s.suspend(true);
				}
			}

			if (e.getSource() == load)

			{
				openFile();
			}

			if (e.getSource() == quit) {
				System.exit(1);
			}

			if (e.getSource() == save1) {
				saveFile();
			}

		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("StopWatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(2, 2));

		SuspendPanel sp;
		sp = new SuspendPanel();

		frame.getContentPane().add(sp);

		frame.setVisible(true);
		frame.pack();

	}

	private void openFile() {

		// create File Chooser so that it starts at the current directory
		String userDir = System.getProperty("user.dir");
		JFileChooser fc = new JFileChooser(userDir);

		// show File Chooser and wait for user selection
		int returnVal = fc.showOpenDialog(this);

		// did the user select a file?
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filename = fc.getSelectedFile().getName();
			s.load(filename);
			time.setText(s.toString());
		}
	}

	// make a method for saving very similar to load
	private void saveFile() {

		String savedFile = "Stop Watch Time";
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("/home/me/Documents"));
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt");
				s.load("StopWatch.txt");
				fw.write(savedFile.toString());
				fw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void disableButton(boolean b) {
		if (b == true) {
			start.setEnabled(false);
			stop.setEnabled(false);
			add.setEnabled(false);
			reset.setEnabled(false);
			add.setEnabled(false);
			subtract.setEnabled(false);
		} else {
			start.setEnabled(true);
			stop.setEnabled(true);
			add.setEnabled(true);
			reset.setEnabled(true);
			add.setEnabled(true);
			subtract.setEnabled(true);
		}

	}

}


