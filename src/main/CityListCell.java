package main;

import java.io.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import util.StoreUserCity;

/*
 * Customizing the cell to put a custom list row into ListView
 * Inherits ListCell class with data type City
 */
public class CityListCell extends ListCell<City> {

	// Initialize all the components for the scene
	private HBox hbox = new HBox();
	private Label label = new Label("(empty)");
	private Pane pane = new Pane();
	private Button favoriteButton = new Button("");
	private Button forecastButton = new Button("Forecast");

	// Store the information of the data type into a variable
	private City lastItem;

	public CityListCell() {
		// Initialize the class
		super();

		// Add children into parent Hbox
		hbox.getChildren().addAll(label, pane, forecastButton, favoriteButton);
		HBox.setHgrow(pane, Priority.ALWAYS);

		// Set favoriteButton to 'true' when a user clicks favoriteButton
		favoriteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				StoreUserCity storer = new StoreUserCity();

				if (lastItem.getFavoriteCityFlag() == false ) {
					try {
						lastItem.setFavoriteCityFlag(true);
						storer.CSVUpdate(lastItem.getCityName(), lastItem.getFavoriteCityFlag());
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (lastItem.getFavoriteCityFlag() == true) {
					try {
						lastItem.setFavoriteCityFlag(false);
						storer.CSVUpdate(lastItem.getCityName(), lastItem.getFavoriteCityFlag());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Set forecastFlag to 'true' when a user clicks forecastButton
		forecastButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				lastItem.setForecastFlag(true);
			}
		});
	}

	// Update the content of a cell
	@Override
	protected void updateItem(City item, boolean empty) {
		super.updateItem(item, empty);
		setText(null);  // No text in label of super class
		if (empty) {
			lastItem = null;
			setGraphic(null);
		} else {
			lastItem = item;
			label.setText(item.getCityName());
			favoriteButton.setBackground(getBackground());
			if (lastItem.getFavoriteCityFlag() == false ) {

				// Store the image file into class Image
				Image favoriteImage = new Image(getURL("EmptyStar.png"));

				// Initialize ImageView to view the image 
				ImageView emptyFavoriteImage = new ImageView(favoriteImage);

				favoriteButton.setGraphic (emptyFavoriteImage);
			} else if (lastItem.getFavoriteCityFlag() == true) {

				// Store the image file into class Image
				Image favoriteImage = new Image(getURL("FilledStar.png"));

				// Initialize ImageView to view the image
				ImageView filledFavoriteImage = new ImageView(favoriteImage);

				favoriteButton.setGraphic (filledFavoriteImage);
			}
			setGraphic(hbox);
		}
	}

	protected String getURL(String imageFile) {

		// Create a file object
		File f = new File("");

		// Get the absolute path of file f
		String absolute = f.getAbsolutePath();

		// String to correct the path
		String fileDir = "src\\media\\" + imageFile;

		String protocol  = "file:///";

		// Correct the path
		String dir = protocol + absolute + "\\" + fileDir;

		return dir;
	}
}