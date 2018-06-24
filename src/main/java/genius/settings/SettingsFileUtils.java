package genius.settings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class SettingsFileUtils {
	public static final String SETTINGS_FILE_NAME = "settings.genius";
	
	private SettingsFileUtils() {
	}

	public static Settings loadSettings(String file) {
		Settings settings;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			settings = (Settings) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			settings = new Settings();
			e.printStackTrace();
		}

		return settings;
	}

	public static void saveSettings(String file, Settings settings) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(settings); // writing head of linked list
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
