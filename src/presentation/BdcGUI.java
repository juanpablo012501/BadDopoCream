package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;

/**
 * This is the GUI that will interact with the player, it will show the menus  and option of the game
 * @author Juan Pablo Vélez Muñoz (JPV)
 * @author Paula Alejandra Díaz Arredondo (PAD)
 */
public class BdcGUI extends JFrame{
	private JPanel rightSection;	//used as button section
	private JPanel leftSection;		//used as design section
	private JButton newGameButton;	//used for creating a new game
	private JButton loadGameButton;	//used to load a game that was saved
	private JButton exitGameButton;	//used for exiting the game
	
	
	/**
	 * Initialize the game
	 * @param String [] args
	 */
	public static void main(String[] args){
		BdcGUI mainGUI = new BdcGUI();
	}
	
	/**
	 * Constructor of the class. In this case prepares all elements and actions
	 */
	public BdcGUI(){
		prepareElements();
		
		prepareActions();
	}
	
	/**
	 * Sets all swing instances used for the design of the main GUI
	 */
	private void prepareElements(){
		//preparation for the left panel	
		//utilizamos una clase anonima para poder asignarle la imagen del juego. Sobre-escribiendo paintComponent
		leftSection = new JPanel(){
			private Image backgroundImage = new ImageIcon("sources/gameDesign.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		leftSection.setSize(250, 500);
		
		//preparation for the buttons
		prepareButtons();
		
		//preparation for the right panel
		rightSection = new JPanel() {
			private Image backgroundImage = new ImageIcon("sources/buttonerBackground.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		//estructura de la botonera
		rightSection.setLayout(new GridLayout(3, 1, 0, 22));
		rightSection.add(newGameButton);
		rightSection.add(loadGameButton);
		rightSection.add(exitGameButton);
		
		
		//main configuration of the JFrame
		this.setTitle("Bad Dopo Cream");
		this.setResizable(false);
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(1, 2));
		ImageIcon icon = new ImageIcon("sources/gameIcon.png");
		this.setIconImage(icon.getImage());
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.add(leftSection);
		this.add(rightSection);
		this.setVisible(true);
	}
	
	/**
	 * Sets all buttons
	 */
	private void prepareButtons(){
		//sets the images used
		Image backgroundVanilla = new ImageIcon("sources/vainilla.png").getImage();
		Image backgroundChocolet = new ImageIcon("sources/chocolate.png").getImage();
		Image backgroundStrawberry = new ImageIcon("sources/fresa.png").getImage();
		
		//new game button
		newGameButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g){				
				//set the background image
				g.drawImage(backgroundVanilla, 0, 0, getWidth(), getHeight(), this);
		        
		        super.paintComponent(g);
		        
			}
		};
		
		newGameButton.setContentAreaFilled(false);
		newGameButton.setFocusPainted(false);
		newGameButton.setOpaque(false);
		
		//load game button
		loadGameButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g){				
				//set the background image
				g.drawImage(backgroundChocolet, 0, 0, getWidth(), getHeight(), this);
			        
		        super.paintComponent(g);
			        
			}
		};
				
		loadGameButton.setContentAreaFilled(false);
		loadGameButton.setFocusPainted(false);
		loadGameButton.setOpaque(false);
		
		//exit game button
		exitGameButton = new JButton() {
			@Override
			protected void paintComponent(Graphics g){			
				//set the background image
				g.drawImage(backgroundStrawberry, 0, 0, getWidth(), getHeight(), this);
					        
				super.paintComponent(g);
					        
			}
		};
						
		exitGameButton.setContentAreaFilled(false);
		exitGameButton.setFocusPainted(false);
		exitGameButton.setOpaque(false);
	}
	
	/**
	 * Sets all actions related to awt instances used in the main GUI
	 */
	private void prepareActions(){
		//listener for the normal exit button (top right)
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				exit();
			}
		});
		
		//listener for the exiting game button
		exitGameButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		//listener for the new game button
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 
			}
		});
		
		//listener for the load game button
		loadGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
	}
	
	/**
	 * Terminates the game
	 */
	private void exit() {
		System.exit(0);
	}
}
