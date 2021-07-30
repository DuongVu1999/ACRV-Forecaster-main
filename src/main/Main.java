package main;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/*  
 * Displays the GUI of the software ACRV's Forecaster
 * References for our project ACRV's Forecaster are listed in our SDD and SRS
 */

public class Main extends Application {

	public static Boolean isSplashLoaded = false;

	@Override
	public void start(Stage primaryStage) throws Exception{
		// Override the start function of the application to start the scene for the GUI

		// Load the FXML building file
		Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));

		// Set the title of the scene
		primaryStage.setTitle("ACRV's Forecaster");

		// Set the maximum screen based on the given window size
		primaryStage.setMaximized(true);

		// Set the scene with a given size
		Scene scene = new Scene(root, 600, 600);

		primaryStage.setResizable(true);
		primaryStage.setScene(scene);

		// Show the scene
		primaryStage.show();

		// Load splash screen with fade in effect
		FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), root);
		fadeIn.setFromValue(0);
		fadeIn.setToValue(1);
		fadeIn.setCycleCount(1);

		// Finish splash screen with fade out effect
		FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), root);
		fadeOut.setFromValue(1);
		fadeOut.setToValue(0);
		fadeOut.setCycleCount(1);

		fadeIn.play();

		// After fade in, start fade out
		fadeIn.setOnFinished((e) -> {
			fadeOut.play();
		});

		fadeOut.setOnFinished((e) -> {
			try {
				// Load the FXML building file
				Parent newRoot = FXMLLoader.load(getClass().getResource("ACRV.fxml"));

				// Set the scene with a given size
				scene.setRoot(newRoot);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}