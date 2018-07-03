/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 * 
 */
package genius.scores;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class ScoresFileUtils {
	public static final String SCORES_FILE_NAME = "scores.genius";

	private ScoresFileUtils() {
	}

	public static Scores loadScores(String file) {
		Scores scores;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			scores = (Scores) ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			scores = new Scores();
			e.printStackTrace();
		}

		return scores;
	}

	public static void saveScores(String file, Scores scores) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(scores); // writing head of linked list
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
