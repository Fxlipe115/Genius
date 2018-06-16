/*
 * Final project for the course Técnicas de Construção de Programas
 * Universidade Federal do Rio Grande do Sul
 * Instituto de Informática
 *
 * Created : May 11, 2018
 * Author  : Graeff
 */
package genius;

import java.awt.Frame;

import javax.swing.JFrame;

import genius.controller.ApplicationController;
import genius.controller.GameController;
import genius.controller.ScoresController;
import genius.model.Settings;

/**
 * @author Graeff
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationController applicationController = new ApplicationController();
		applicationController.initApplication();
//		Frame f = new JFrame();
//		ScoresController sc = new ScoresController();
//		f.add(sc.getScoresView());
//		f.setSize(400, 400);
//		f.setVisible(true);
	}

}
