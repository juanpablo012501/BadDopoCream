package presentation;

import javax.swing.JPanel;

public abstract class ChooserGUI extends JPanel{
	protected int optionChosen;
	
	/**
	 * Gives the answer chosen
	 * @return int
	 */
	public int getOptionChosen() {
		return optionChosen;
	}
}
