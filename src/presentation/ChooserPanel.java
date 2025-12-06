package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This is an extension of a JPanel that allows to create a group of button (the amount is given by the number of images sent in an ArrayList) 
 * and by choosing one of this buttons the option is stored and it can be asked for it
 * @author JPV
 * @author PAD
 */
public class ChooserPanel extends JPanel{
	private char type;
	private int optionChosen;
	private JPanel buttonerStructure;
	private ArrayList<JButton> options;
	private Image backgroundImage;
	private JPanel northMargin;
	private JPanel southMargin;
	private JPanel eastMargin;
	private JPanel westMargin;
	
	/**
	 * Constructor of the class
	 * @param ArrayList<String> this are the path of the images used for each button
	 * @param String this is the path to use as the font of the buttoner
	 * @param char this indicates what are you choosing: l-level, m-machine, i-iceream
	 */
	public ChooserPanel(ArrayList<String> sourceImages, String fontPath, char type) {
		this.type = type;
		 prepareElements(sourceImages, fontPath);
		 
		 prepareActions();
	}
	
	/**
	 * Sets the swing and awt components
	 * @param ArrayList<String> this are the path of the images used for each button
	 * @param String this is the path to use as the font of the buttoner
	 */
	private void prepareElements(ArrayList<String> sourceImages, String backgroungPath) {
		//set the backGround image
		backgroundImage = new ImageIcon(backgroungPath).getImage();
		
		//set the buttons
		prepareButtons(sourceImages);
		
		//set the buttoner Structure
		buttonerStructure = new JPanel();
		buttonerStructure.setLayout(new GridLayout(1, options.size(), 30, 0));
		buttonerStructure.setOpaque(false);
		
		//adding the buttons
		for(JButton option : options) {
			buttonerStructure.add(option);
		}
		
		//sets the margins
		northMargin = new JPanel();
		northMargin.setPreferredSize(new Dimension(600, 40));
		northMargin.setOpaque(false);
		southMargin = new JPanel();
		southMargin.setPreferredSize(new Dimension(600, 40));
		southMargin.setOpaque(false);
		eastMargin = new JPanel();
		eastMargin.setPreferredSize(new Dimension(30, 80));
		eastMargin.setOpaque(false);
		westMargin = new JPanel();
		westMargin.setPreferredSize(new Dimension(30, 80));
		westMargin.setOpaque(false);
		
		//sets the main JPanel features
		this.setLayout(new BorderLayout());
		this.add(northMargin, BorderLayout.NORTH);
		this.add(southMargin, BorderLayout.SOUTH);
		this.add(eastMargin, BorderLayout.EAST);
		this.add(westMargin, BorderLayout.WEST);
		this.add(buttonerStructure, BorderLayout.CENTER);
	}
	
	/**
	 * Instantiates the buttons
	 * @param ArrayList<String> this are the path of the images used button
	 */
	private void prepareButtons(ArrayList<String> sourceImages) {
		options = new ArrayList<JButton>();
		for(String imagePath : sourceImages) {
			JButton aux = new JButton() {
				private Image buttonImage = new ImageIcon(imagePath).getImage();
				
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(buttonImage, 0, 0, getWidth(), getHeight(), this);
				}
			};
			options.add(aux);
		}
	}
	
	/**
	 * Sets the actions related to each button
	 */
	private void prepareActions() {
		//the number assigned to each button correspond to the index in the ArrayList +1
		for(int numberAssigned = 0; numberAssigned <options.size(); numberAssigned++) {
			final int numAssig = numberAssigned;
			options.get(numberAssigned).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					optionChosen = numAssig + 1;
				}
			});
		}
	}
	
	/**
	 * Changes the north margin
	 * @param JPanel the new north margin, used for the back button panel
	 */
	public void changeNorthMargin(JPanel newNorthMargin) {
		this.add(newNorthMargin, BorderLayout.NORTH);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
	
	/**
	 * Gives the answer chosen
	 * @return int
	 */
	public int getOptionChosen() {
		return optionChosen;
	}
}
