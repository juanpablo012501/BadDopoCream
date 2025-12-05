package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SinglePlayerSettingsGUI extends SettingsGUI{
	//private JPanel playerChooser = new IceCreamChooserGUI();
	private JPanel playerChooser = new JPanel();
	
	/**
	 * Constructor of the class
	 * @param old
	 */
	public SinglePlayerSettingsGUI(JFrame old) {
		super(old);
		
		prepareElements();
		prepareActions();
	}
	
	/**
	 * Sets the Swing and awt component in the Window
	 */
	protected void prepareElements() {
		super.prepareElements();
		
		//variables
		ImageIcon icon = new ImageIcon("sources/gameIcon.png");
		
		//main configurations
		this.setTitle("Single Player Settings");
		this.setResizable(false);
		this.setLayout(new GridLayout(2, 1));
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adding elements
		this.add(playerChooser);
		this.add(form);
		this.pack();
		this.setVisible(true);
		System.out.println(startButton.getWidth() + "x" + startButton.getHeight());
	}

	@Override
	protected void startGame() {
		//poner el constructor correspondiente
	}

}
