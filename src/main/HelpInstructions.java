package main;

import javafx.scene.image.Image;

public class HelpInstructions {

	// Declare all the variables
	private int instructionID;
	private String instruction;
	private String description;
	private Image instructionImage;
	private Boolean informationDisplayFlag = false;

	// Create a constructor
	public HelpInstructions(int newInstructionID, String newInstruction, String newDescription, Image newInstructionImage) {
		instructionID = newInstructionID;
		instruction = newInstruction;
		description = newDescription;
		instructionImage = newInstructionImage;
	}

	// Get and Set methods for the class HelpInstructions

	public int getInstructionID() {
		return this.instructionID;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public String getDescription() {
		return this.description;
	}

	public Image getInstructionImage() {
		return this.instructionImage;
	}

	public Boolean getInformationDisplayFlag() {
		return this.informationDisplayFlag;
	}

	public void setInformationDisplayFlag(Boolean newFlag) {
		this.informationDisplayFlag = newFlag;
	}
}