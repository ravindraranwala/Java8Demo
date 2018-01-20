package org.pearson.com.chapter.five;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author José
 */
public class SecondApplication extends Application {

	@Override
	public void start(Stage stage) throws MalformedURLException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ihm.fxml"));

			Parent root = loader.load();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public static void main(String[] args) {
		launch();
	}
}
