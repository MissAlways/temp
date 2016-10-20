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
		String temp;

		try {
			inputStream = new FileInputStream("settings.ini");
			properties.load(inputStream);
			try {
				temp = properties.getProperty("resolutionX");
				options.setResolutionX(Integer.parseInt(temp));

			} catch (Exception e) {
				System.out.println("Horizontal resolution incorrect");
			}
			try {
				temp = properties.getProperty("resolutionY");
				options.setResolutionY(Integer.parseInt(temp));
			} catch (Exception e) {
				System.out.println("Vertical resolution incorrect");
			}
			try {
				temp = properties.getProperty("fullscreen");
				options.setFullscreen(Boolean.parseBoolean(temp));
			} catch (Exception e) {
				System.out.println("Fullscreen setting incorrect");
			}
			try {
				temp = properties.getProperty("sound");
				options.setSound(Boolean.parseBoolean(temp));
			} catch (Exception e) {
				System.out.println("Sound setting incorrect");
			}
			try {
				temp = properties.getProperty("soundVolume");
				options.setSoundVolume(Integer.parseInt(temp));
			} catch (Exception e) {
				System.out.println("SoundVolume setting incorrect");
			}

			try {
				temp = properties.getProperty("music");
				options.setMusic(Boolean.parseBoolean(temp));
			} catch (Exception e) {
				System.out.println("music setting incorrect");
			}
			try {
				temp = properties.getProperty("musicVolume");
				options.setMusicVolume(Integer.parseInt(temp));
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

	public void setOptions(Options options){
		Properties properties = new Properties();
		OutputStream outputStream = null;
		String temp;
		
		try {
			outputStream = new FileOutputStream("settings.ini");
			temp = Integer.toString(options.getResolutionX());
			properties.setProperty("resolutionX", temp);
			temp = Integer.toString(options.getResolutionY());
			properties.setProperty("resolutionY", temp);
			temp = Boolean.toString(options.isFullscreen());
			properties.setProperty("fullscreen", temp);
			temp = Boolean.toString(options.isSound());
			properties.setProperty("sound", temp);
			temp = Integer.toString(options.getSoundVolume());
			properties.setProperty("soundVolume", temp);
			temp = Boolean.toString(options.isMusic());
			properties.setProperty("music", temp);
			temp = Integer.toString(options.getMusicVolume());
			properties.setProperty("musicVolume", temp);
			properties.store(outputStream, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
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
