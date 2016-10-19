package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import bean.Options;
import db.OptionsDao;

/**
 * 
 * @author MissAlways
 *
 */
public class SettingsMenu extends JFrame {
	private JPanel basePanel = new JPanel(new BorderLayout());

	// Labels
	private JLabel resolutionLabel = new JLabel("Resolution");

	// TextFields
	private JTextField customX = new JTextField();
	private JTextField customY = new JTextField();
	// Spinner
	private String[] resolutionList = new String[] { "640 X 480", "720 X 480", "720 X 576", "800 X 600", "1024 X 768",
			"1280 X 720", "1280 X 768", "1280 X 800", "1280 X 960", "1280 X 1024", "1440 X 900", "1680 X 1050" };

	private SpinnerListModel resolutionModel = new SpinnerListModel(resolutionList);
	private JSpinner resolutionSpinner = new JSpinner(resolutionModel);

	// JCheckBoxes
	private JCheckBox customResolutionCheckBox = new JCheckBox("Custom: ");
	private JCheckBox musicCheckBox = new JCheckBox("Music ");
	private JCheckBox soundCheckBox = new JCheckBox("Sound ");
	private JCheckBox fullscreenCheckBox = new JCheckBox("Fullscreen ");

	// Sliders
	private JSlider soundVolumeSlider = new JSlider(0, 100);
	private JSlider musicVolumeSlider = new JSlider(0, 100);

	// Buttons
	private JButton backBtn = new JButton("Back");
	private JButton saveBtn = new JButton("Save");

	public SettingsMenu() {
		OptionsDao optionsDao = new OptionsDao();
		Options options = optionsDao.getOptions();

		Component spinnerEditor = resolutionSpinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		jftf.setColumns(8);

		resolutionSpinner.setSize(50, 10);

		getCurrentSettings(options);
		placeComponents();
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

	private void placeComponents() {

		JPanel resolutionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		resolutionPanel.add(resolutionLabel);
		resolutionPanel.add(resolutionSpinner);

		JPanel customResolutionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		customResolutionPanel.add(customResolutionCheckBox);
		customResolutionPanel.add(customX);
		customResolutionPanel.add(customY);

		JPanel fullscreenPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		fullscreenPanel.add(fullscreenCheckBox);

		JPanel grid = new JPanel(new GridLayout(5, 1));
		grid.add(resolutionPanel);
		grid.add(customResolutionPanel);
		grid.add(fullscreenPanel);

		JPanel leftPanel = new JPanel(new FlowLayout());
		leftPanel.add(grid);

		basePanel.add(leftPanel, BorderLayout.LINE_START);

		JPanel soundPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		soundPanel.add(soundCheckBox);

		JPanel soundVolumePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		soundVolumePanel.add(soundVolumeSlider);

		JPanel musicPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		musicPanel.add(musicCheckBox);

		JPanel musicVolumePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		musicVolumePanel.add(musicVolumeSlider);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		buttonPanel.add(backBtn);
		buttonPanel.add(saveBtn);

		JPanel grid2 = new JPanel(new GridLayout(5, 1));
		grid2.add(soundPanel);
		grid2.add(soundVolumePanel);
		grid2.add(musicPanel);
		grid2.add(musicVolumePanel);

		JPanel rightPanel = new JPanel(new FlowLayout());
		rightPanel.add(grid2);

		basePanel.add(rightPanel, BorderLayout.LINE_END);
		basePanel.add(buttonPanel, BorderLayout.PAGE_END);

	}

	public static void main(String[] args) {
		new SettingsMenu().setVisible(true);

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
