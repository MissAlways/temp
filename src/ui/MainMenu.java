package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import db.OptionsDao;
import bean.Options;

/**
 * 
 * @author MissAlways
 *
 */
public class MainMenu extends JFrame {
	// Panel
	private JPanel basePanel = new JPanel(new GridLayout(1, 2));

	// Buttons
	private JButton playBtn = new JButton("Play Hard");
	private JButton optionsBtn = new JButton("Options");
	private JButton aboutUsBtn = new JButton("About us");
	private JButton exitBtn = new JButton("Exit");
	private JButton changePlayerBtn = new JButton("Change");
	// Label
	private JLabel currentPlayerLabel = new JLabel("");

	public MainMenu() {
		placeComponents();

		this.add(basePanel);
		this.setTitle("Work Hard");

		OptionsDao optionsDao = new OptionsDao();
		Options options = optionsDao.getOptions();

		this.setSize(options.getResolutionX(), options.getResolutionY());

		optionsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new SettingsMenu().setVisible(true);
				// TODO
				SettingsMenu settingsMenu = new SettingsMenu();
				settingsMenu.setVisible(true);
			}
		});

		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});
		aboutUsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});
		changePlayerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});
	}

	public static void main(String[] args) {
		new MainMenu().setVisible(true);
	}

	private void placeComponents() {
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
		GroupLayout.ParallelGroup buttonGroupX = groupLayout
				.createParallelGroup();
		buttonGroupX.addComponent(playBtn);
		buttonGroupX.addComponent(optionsBtn);
		buttonGroupX.addComponent(aboutUsBtn);
		buttonGroupX.addComponent(exitBtn);

		groupLayout.linkSize(SwingConstants.HORIZONTAL, playBtn, optionsBtn,
				aboutUsBtn, exitBtn);
		groupLayout.setHorizontalGroup(buttonGroupX);

		// Y Layout
		GroupLayout.SequentialGroup buttonGroupY = groupLayout
				.createSequentialGroup();
		buttonGroupY.addComponent(playBtn);
		buttonGroupY.addComponent(optionsBtn);
		buttonGroupY.addComponent(aboutUsBtn);
		buttonGroupY.addComponent(exitBtn);

		groupLayout.setVerticalGroup(buttonGroupY);

		rightPanel.add(playerPanel);
		rightPanel.add(buttonGroup);

		basePanel.add(leftPanel);
		basePanel.add(rightPanel);
	}

}
