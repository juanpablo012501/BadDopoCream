package presentation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This an extension of  JFrame that is design to add in a column a series of ChooserPanels, it also adds a back button to the firsts ChooserPanel
 * and a panel in the bottom that starts the game
 * @author JPV
 * @author PAD
 */
public class SettingsGUI extends JFrame{
	private GameModeGUI lastWindow;
	private JPanel startPanel;
	private JButton startButton;
	private JButton backButton;
	private ArrayList<ChooserPanel> panels;
	
	/**
	 * Constructor of the class
	 * @param JFrame the window that called this window
	 * @param ArrayList<ChooserGUI> the panel that must be added
	 */
	public SettingsGUI(GameModeGUI old, ArrayList<ChooserPanel> panels) {
		this.panels = panels;
		lastWindow = old;
		prepareElements(panels);
		prepareActions();
	}
	
	/**
	 * Prepares the swing and awt elements
	 * @param ArrayList<ChooserPanel> the panels that must be added
	 */
	private void prepareElements(ArrayList<ChooserPanel> panels) {
		//variables
		ImageIcon icon = new ImageIcon("sources/gameIcon.png");
		JPanel rightMargin = new JPanel();
		JPanel leftMargin = new JPanel();
		rightMargin.setPreferredSize(new Dimension(200, 100));
		leftMargin.setPreferredSize(new Dimension(200, 100));
		rightMargin.setOpaque(false);
		leftMargin.setOpaque(false);
		
		//set the button
		prepareButtons();
		
		//display for the start button
		startPanel = new JPanel() {
			private Image startBackground= new ImageIcon("sources/startBackground.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(startBackground, 0, 0, getWidth(), getHeight(), this);
			}
		};
		startPanel.setLayout(new BorderLayout());
		startPanel.add(rightMargin, BorderLayout.EAST);
		startPanel.add(leftMargin, BorderLayout.WEST);
		startPanel.add(startButton, BorderLayout.CENTER);
		
		//display for back button
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		backPanel.setOpaque(false);
		backPanel.add(backButton);
		
		//add the backPanel to the first ChooserPanel
		panels.get(0).changeNorthMargin(backPanel);
		
		//sets the Layout of the JFrame and add all panels
		this.setLayout(new GridLayout(panels.size()+1, 1));
		for(ChooserPanel panel : panels) {
			this.add(panel);
		}
		this.add(startPanel);
		
		//main settings
		this.setTitle("Set your game");
		this.setIconImage(icon.getImage());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);		
	}
	
	/**
	 * sets the buttons
	 */
	private void prepareButtons(){
		//set startButton
		startButton = new JButton() {
			private Image startImage= new ImageIcon("sources/startImage.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(startImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		//set backButton
		backButton = new JButton() {
			private Image backImage = new ImageIcon("sources/backImage.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		backButton.setPreferredSize(new Dimension(40, 40));
		backButton.setBorderPainted(false);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setOpaque(false);
	}
	
	/**
	 * Sets the actions associated to some components in the window 
	 */
	private void prepareActions() {
		//listener for back button
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastWindow.removePanels();
				lastWindow.setVisible(true);
				SettingsGUI.this.dispose();
			}
		});
		
		//listener for start button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(ChooserPanel panel : panels) {
					System.out.println(panel.getOptionChosen());
				}
			}
		});
	}
}
