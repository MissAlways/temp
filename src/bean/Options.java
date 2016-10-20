package bean;

/**
 * @author MissAlways
 *
 */
public class Options {
	private int resolutionX;
	private int resolutionY;
	private boolean fullscreen;
	private boolean sound;
	private int soundVolume;
	private boolean music;
	private int musicVolume;

	/**
	 * @param resolutionX horizontal resolution
	 * @param resolutionY vertical resolution
	 * @param fullscreen fullscreen on(true) or off(false)
	 * @param sound sound on(true) or off(false)
	 * @param soundVolume sound volume
	 * @param music music on(true) or off(false)
	 * @param musicVolume music volume
	 */
	public Options() {
		resolutionX = 600;
		resolutionY = 400;
		fullscreen = false;
		sound = true;
		soundVolume = 100;
		music = true;
		musicVolume = 100;
	}

	public String getResolution(){
		String reso = resolutionX+" x "+resolutionY;
		return reso;
	}
	/**
	 * @return the resolutionX
	 */
	public int getResolutionX() {
		return resolutionX;
	}

	/**
	 * @param resolutionX
	 *            the resolutionX to set
	 */
	public void setResolutionX(int resolutionX) {
		this.resolutionX = resolutionX;
	}

	/**
	 * @return the resolutionY
	 */
	public int getResolutionY() {
		return resolutionY;
	}

	/**
	 * @param resolutionY
	 *            the resolutionY to set
	 */
	public void setResolutionY(int resolutionY) {
		this.resolutionY = resolutionY;
	}

	/**
	 * @return the fullscreen
	 */
	public boolean isFullscreen() {
		return fullscreen;
	}

	/**
	 * @param fullscreen
	 *            the fullscreen to set
	 */
	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	/**
	 * @return the sound
	 */
	public boolean isSound() {
		return sound;
	}

	/**
	 * @param sound
	 *            the sound to set
	 */
	public void setSound(boolean sound) {
		this.sound = sound;
	}

	/**
	 * @return the soundVolume
	 */
	public int getSoundVolume() {
		return soundVolume;
	}

	/**
	 * @param soundVolume
	 *            the soundVolume to set
	 */
	public void setSoundVolume(int soundVolume) {
		this.soundVolume = soundVolume;
	}

	/**
	 * @return the music
	 */
	public boolean isMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(boolean music) {
		this.music = music;
	}

	/**
	 * @return the musicVolume
	 */
	public int getMusicVolume() {
		return musicVolume;
	}

	/**
	 * @param musicVolume
	 *            the musicVolume to set
	 */
	public void setMusicVolume(int musicVolume) {
		this.musicVolume = musicVolume;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Options [resolutionX=" + resolutionX + ", resolutionY="
				+ resolutionY + ", fullscreen=" + fullscreen + ", sound="
				+ sound + ", soundVolume=" + soundVolume + ", music=" + music
				+ ", musicVolume=" + musicVolume + "]";
	}

}
