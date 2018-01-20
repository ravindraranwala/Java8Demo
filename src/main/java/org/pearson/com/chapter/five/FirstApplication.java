package org.pearson.com.chapter.five;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Label label = new Label("Hello world!");
		label.setFont(new Font(50));

		Scene scene = new Scene(label);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}

}
