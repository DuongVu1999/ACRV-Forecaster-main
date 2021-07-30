package main;

import javafx.scene.control.*;
import javafx.util.Callback;

/*
 * HelpInstructionsCellFactory return HelpInstructionsListCell
 */
public class HelpInstructionsCellFactory implements Callback<ListView<HelpInstructions>, ListCell<HelpInstructions>> {
	@Override
	public ListCell<HelpInstructions> call(ListView<HelpInstructions> param) {
		return new HelpInstructionsListCell();
	}
}