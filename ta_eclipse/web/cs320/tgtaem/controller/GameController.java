package cs320.tgtaem.controller;

import cs320.tgtaem.model.GameTempModel;

/**
 * Controller for numbers.
 */
public class GameController {
	private GameTempModel model;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	public void setModel(GameTempModel model) {
		this.model = model;
	}

	public void add(double first, double second, double third) {
		model.setResult(first + second + third);
	}
	
	public void multiply(double first, double second, double third) {
		model.setResult(first * second * third);
	}
}
