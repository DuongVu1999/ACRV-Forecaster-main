package main;

import javafx.scene.control.*;
import javafx.util.Callback;

/*
 * CityCellFactory returns CityListCell
 */
public class CityCellFactory implements Callback<ListView<City>, ListCell<City>> {
	@Override
	public ListCell<City> call(ListView<City> param) {
		return new CityListCell();
	}
}