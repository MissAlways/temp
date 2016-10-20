package db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import bean.Options;

/**
 * 
 * @author MissAlways
 *
 */
public class OptionsDao {

	public Options getOptions() {
		InputStream inputStream = null;
		Properties properties = new Properties();
		Options options = new Options();

		try {
			inputStream = new FileInputStream("settings.ini");
			properties.load(inputStream);
			try {
				options.setResolutionX(Integer.parseInt(properties.getProperty("resolutionX")));

			} catch (Exception e) {
				System.out.println("Horizontal resolution incorrect");
			}
			try {
				options.setResolutionY(Integer.parseInt(properties.getProperty("resolutionY")));
			} catch (Exception e) {
				System.out.println("Vertical resolution incorrect");
			}
			try {
				options.setFullscreen(Boolean.parseBoolean(properties.getProperty("fullscreen")));
			} catch (Exception e) {
				System.out.println("Fullscreen setting incorrect");
			}
			try {
				options.setSound(Boolean.parseBoolean(properties.getProperty("sound")));
			} catch (Exception e) {
				System.out.println("Sound setting incorrect");
			}
			try {
				options.setSoundVolume(Integer.parseInt(properties.getProperty("soundVolume")));
			} catch (Exception e) {
				System.out.println("SoundVolume setting incorrect");
			}
			try {
				options.setMusic(Boolean.parseBoolean(properties.getProperty("music")));
			} catch (Exception e) {
				System.out.println("music setting incorrect");
			}
			try {
				options.setMusicVolume(Integer.parseInt(properties.getProperty("musicVolume")));
			} catch (Exception e) {
				System.out.println("MusicVolume setting incorrect");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return options;
	}

	public void setOptions(Options options) {
		Properties properties = new Properties();
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream("settings.ini");
			properties.setProperty("resolutionX", Integer.toString(options.getResolutionX()));
			properties.setProperty("resolutionY", Integer.toString(options.getResolutionY()));
			properties.setProperty("fullscreen", Boolean.toString(options.isFullscreen()));
			properties.setProperty("sound", Boolean.toString(options.isSound()));
			properties.setProperty("soundVolume", Integer.toString(options.getSoundVolume()));
			properties.setProperty("music", Boolean.toString(options.isMusic()));
			properties.setProperty("musicVolume", Integer.toString(options.getMusicVolume()));
			properties.store(outputStream, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
