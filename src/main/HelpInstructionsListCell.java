package main;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HelpInstructionsListCell extends ListCell<HelpInstructions> {

	// Initialize all the components for the scene
	private HBox hbox = new HBox();
	private Label label = new Label("(empty)");
	private Pane pane = new Pane();

	// Store the information of the data type into a variable
	private HelpInstructions lastItem;

	public HelpInstructionsListCell() {
		// Initialize the class
		super();

		// Add children into parent Hbox
		hbox.getChildren().addAll(label, pane);
		HBox.setHgrow(pane, Priority.ALWAYS);
	}

	// Update the content of a cell
	@Override
	protected void updateItem(HelpInstructions item, boolean empty) {
		super.updateItem(item, empty);
		setText(null);  // No text in label of super class
		if (empty) {
			lastItem = null;
			setGraphic(null);
		} else {
			lastItem = item;
			label.setText(item.getInstruction());
			setGraphic(hbox);
		}
	}
}