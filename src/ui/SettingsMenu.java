package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.ResolutionSyntax;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;

import bean.Options;
import db.OptionsDao;

/**
 * 
 * @author MissAlways
 *
 */
public class SettingsMenu extends JFrame {
	JPanel basePanel = new JPanel();

	// Labels
	private JLabel resolutionLabel = new JLabel("Resolution");
	private JLabel resolutionCustomLabel = new JLabel("Custom: ");
	private JLabel fullscreenLabel = new JLabel("Fullscreen");
	private JLabel soundLabel = new JLabel("Sound");
	private JLabel musicLabel = new JLabel("Music");
	// TextFields
	private JTextField customX = new JTextField();
	private JTextField customY = new JTextField();
	// Spinner
	private String[] resolutionList = new String[] { "640 × 480", "720 × 480",
			"720 × 576", "800 × 600", "1024 × 768", "1280 × 720", "1280 × 768",
			"1280 × 800", "1280 × 960", "1280 × 1024", "1440 × 900",
			"1680 × 1050" };

	private SpinnerListModel resolutionModel = new SpinnerListModel(
			resolutionList);
	private JSpinner resolution = new JSpinner();

	// JCheckBoxes
	private JCheckBox customResolutionCheckBox = new JCheckBox("Custom: ");
	private JCheckBox musicCheckBox = new JCheckBox();
	private JCheckBox soundCheckBox = new JCheckBox();
	private JCheckBox fullscreenCheckBox = new JCheckBox();

	// Sliders
	private JSlider soundVolumeSlider = new JSlider(0, 100);
	private JSlider musicVolumeSlider = new JSlider(0, 100);

	// Buttons
	private JButton backBtn = new JButton("Back");
	private JButton saveBtn = new JButton("Save");

	public SettingsMenu() {
		OptionsDao optionsDao = new OptionsDao();
		Options options = optionsDao.getOptions();

		getCurrentSettings(options);
		// SET FULLSCREEN
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setUndecorated(true);
		// this.setVisible(true);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(basePanel);
		this.setTitle("Work Hard");
		this.setSize(options.getResolutionX(), options.getResolutionY());

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});

		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});

	}

	public static void main(String[] args) {
		/*
		 * Swing-ikkuna on syytä luoda tapahtumasäikeeseen käyttäen
		 * SwingUtilities.invokeLater-metodia.
		 */
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SettingsMenu().setVisible(true); /*
														 * Luo ja näyttää
														 * ikkunan
														 */
			}
		});
	}

	private void getCurrentSettings(Options options) {
		String temp;
		temp = Integer.toString(options.getResolutionX());
		customX.setText(temp);
		temp = Integer.toString(options.getResolutionY());
		customY.setText(temp);
		fullscreenCheckBox.setSelected(options.isFullscreen());
		soundCheckBox.setSelected(options.isSound());
		musicCheckBox.setSelected(options.isMusic());
		soundVolumeSlider.setValue(options.getSoundVolume());
		musicVolumeSlider.setValue(options.getMusicVolume());

	}

	
}
