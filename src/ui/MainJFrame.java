package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Options;
import db.OptionsDao;

/**
 * @author MissAlways
 *
 */
public class MainJFrame {
	JPanel cards;

	// Mainmenu
	final static String MAIN_MENU_PANEL = "Main menu";
	// Buttons
	private JButton playBtn = new JButton("Play Hard");
	private JButton optionsBtn = new JButton("Options");
	private JButton aboutUsBtn = new JButton("About us");
	private JButton exitBtn = new JButton("Exit");
	private JButton changePlayerBtn = new JButton("Change");
	// Label
	private JLabel currentPlayerLabel = new JLabel("");

	// Settings
	final static String SETTINGS_MENU_PANEL = "Options";
	// Labels
	private JLabel resolutionLabel = new JLabel("Resolution");

	// TextFields
	private static JTextField customX = new JTextField();
	private static JTextField customY = new JTextField();
	// Dropdown menu
	private static String[] resolutionArray = new String[] { "640 x 480", "720 x 480", "720 x 576", "800 x 600",
			"1024 x 768", "1280 x 720", "1280 x 768", "1280 x 800", "1280 x 960", "1280 x 1024", "1440 x 900",
			"1680 x 1050" };
	private static JComboBox<String> resolutionComboBox = new JComboBox<String>(resolutionArray);

	// JCheckBoxes
	private static JCheckBox customResolutionCheckBox = new JCheckBox("Custom: ");
	private static JCheckBox musicCheckBox = new JCheckBox("Music ");
	private static JCheckBox soundCheckBox = new JCheckBox("Sound ");
	private static JCheckBox fullscreenCheckBox = new JCheckBox("Fullscreen ");

	// Sliders
	private static JSlider soundVolumeSlider = new JSlider(0, 100);
	private static JSlider musicVolumeSlider = new JSlider(0, 100);

	// Buttons
	private JButton backBtn = new JButton("Back");
	private JButton saveBtn = new JButton("Save");

	public void addComponentToPane(Container pane) {
		JPanel mainMenuPanel = placeMainMenuComponents();
		JPanel settingsMenuPanel = placeSettingsMenuComponents();

		cards = new JPanel(new CardLayout());
		cards.add(mainMenuPanel, MAIN_MENU_PANEL);
		cards.add(settingsMenuPanel, SETTINGS_MENU_PANEL);

		pane.add(cards, BorderLayout.CENTER);

		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		optionsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) (cards.getLayout());
				cardLayout.show(cards, SETTINGS_MENU_PANEL);
			}
		});

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) (cards.getLayout());
				cardLayout.show(cards, MAIN_MENU_PANEL);

			}
		});

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveSettings();
				CardLayout cardLayout = (CardLayout) (cards.getLayout());
				cardLayout.show(cards, MAIN_MENU_PANEL);

			}

			private void saveSettings() {
				String x = "";
				String y = "";
				String xy;
				boolean fullscreen;
				boolean sound;
				int soundVolume;
				boolean music;
				int musicVolume;
				Options options = new Options();

				if (customResolutionCheckBox.isSelected()) {
					x = customX.getText();
					y = customY.getText();
				} else {
					xy = resolutionComboBox.getSelectedItem().toString();
					final String regex = "([0-9]{3,4}) x ([0-9]{3,4})";
					final Pattern pattern = Pattern.compile(regex);
					final Matcher matcher = pattern.matcher(xy);

					while (matcher.find()) {
						x = matcher.group(1);
						y = matcher.group(2);
					}

				}

				if (fullscreenCheckBox.isSelected()) {
					fullscreen = true;
				} else {
					fullscreen = false;
				}
				if (soundCheckBox.isSelected()) {
					sound = true;
				} else {
					sound = false;
				}
				soundVolume = soundVolumeSlider.getValue();
				if (musicCheckBox.isSelected()) {
					music = true;
				} else {
					music = false;
				}
				musicVolume = musicVolumeSlider.getValue();
				options.setResolutionX(Integer.parseInt(x));
				options.setResolutionY(Integer.parseInt(y));
				options.setFullscreen(fullscreen);
				options.setSound(sound);
				options.setSoundVolume(soundVolume);
				options.setMusic(music);
				options.setMusicVolume(musicVolume);

				OptionsDao optionsDao = new OptionsDao();
				System.out.println(options.toString());
				optionsDao.setOptions(options);
			}
		});
	}

	private JPanel placeSettingsMenuComponents() {
		JPanel resolutionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		resolutionPanel.add(resolutionLabel);
		resolutionPanel.add(resolutionComboBox);

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

		JPanel basePanel = new JPanel(new BorderLayout());
		basePanel.add(leftPanel, BorderLayout.LINE_START);
		basePanel.add(rightPanel, BorderLayout.LINE_END);
		basePanel.add(buttonPanel, BorderLayout.PAGE_END);
		return basePanel;
	}

	private JPanel placeMainMenuComponents() {
		JPanel buttonGroup = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel(new GridLayout(2, 1));
		GroupLayout groupLayout = new GroupLayout(buttonGroup);
		buttonGroup.setLayout(groupLayout);

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		JPanel playerPanelFix = new JPanel(new GridLayout(2, 1));
		playerPanelFix.add(currentPlayerLabel);
		playerPanelFix.add(changePlayerBtn);

		JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		playerPanel.add(playerPanelFix);

		// X Layout
		GroupLayout.ParallelGroup buttonGroupX = groupLayout.createParallelGroup();
		buttonGroupX.addComponent(playBtn);
		buttonGroupX.addComponent(optionsBtn);
		buttonGroupX.addComponent(aboutUsBtn);
		buttonGroupX.addComponent(exitBtn);

		groupLayout.linkSize(SwingConstants.HORIZONTAL, playBtn, optionsBtn, aboutUsBtn, exitBtn);
		groupLayout.setHorizontalGroup(buttonGroupX);

		// Y Layout
		GroupLayout.SequentialGroup buttonGroupY = groupLayout.createSequentialGroup();
		buttonGroupY.addComponent(playBtn);
		buttonGroupY.addComponent(optionsBtn);
		buttonGroupY.addComponent(aboutUsBtn);
		buttonGroupY.addComponent(exitBtn);

		groupLayout.setVerticalGroup(buttonGroupY);

		rightPanel.add(playerPanel);
		rightPanel.add(buttonGroup);

		JPanel basePanel = new JPanel(new GridLayout(1, 2));
		basePanel.add(leftPanel);
		basePanel.add(rightPanel);

		return basePanel;
	}

	public static void getUi() {
		JFrame frame = new JFrame("Work Hard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainJFrame mainJFrame = new MainJFrame();
		mainJFrame.addComponentToPane(frame.getContentPane());

		OptionsDao optionsDao = new OptionsDao();
		Options options = optionsDao.getOptions();

		getCurrentSettings(options);

		frame.setSize(options.getResolutionX(), options.getResolutionY());
		frame.setVisible(true);

	}

	private static void getCurrentSettings(Options options) {
		customX.setText(Integer.toString(options.getResolutionX()));
		customY.setText(Integer.toString(options.getResolutionY()));

		String resolution = options.getResolution();

		if (Arrays.asList(resolutionArray).indexOf(resolution) != -1) {
			resolutionComboBox.setSelectedItem(resolution);
		} else {
			customResolutionCheckBox.setSelected(true);
		}
		fullscreenCheckBox.setSelected(options.isFullscreen());
		soundCheckBox.setSelected(options.isSound());
		musicCheckBox.setSelected(options.isMusic());
		soundVolumeSlider.setValue(options.getSoundVolume());
		musicVolumeSlider.setValue(options.getMusicVolume());

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				getUi();
			}
		});
	}
}
