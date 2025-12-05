package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class SettingsGUI extends JFrame{
	protected JFrame lastWindow;
	protected JButton backButton;
	protected JButton startButton;
	protected JPanel form;
	
	/**
	 * Constructor of the class
	 * @param JFrame the window that called this window
	 */
	public SettingsGUI(JFrame old) {
		
	}
	
	/**
	 * Prepares the swing and awt elements
	 */
	protected void prepareElements() {
		//set the buttons
		prepareButtons();
		
		//limits for the buttoner
		form = new JPanel() {
		private Image font = new ImageIcon("sources/startFont.png").getImage();
		
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(font, 0, 0, getWidth(), getHeight(), this);
			}
		};
		form.setLayout(new BorderLayout());
		form.setOpaque(false);
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(500, 25));
		north.setOpaque(false);
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(500, 25));
		south.setOpaque(false);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(50, 150));
		east.setOpaque(false);
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(50, 150));
		west.setOpaque(false);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2, 15 ,15));
		center.setOpaque(false);
		
		//settings for the buttoner
		form.add(north, BorderLayout.NORTH);
		form.add(south, BorderLayout.SOUTH);
		form.add(east, BorderLayout.EAST);
		form.add(west, BorderLayout.WEST);
		form.add(startButton, BorderLayout.CENTER);
	}
	
	/**
	 * sets the buttons
	 */
	protected void prepareButtons(){
		//go back button
		backButton = new JButton() {
			private Image backImage = new ImageIcon("sources/back.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		
		//start button
		startButton = new JButton() {
			private Image startImage = new ImageIcon("sources/startButton.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(startImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
	}
	
	/**
	 * Sets the actions associated to some components in the window 
	 */
	protected void prepareActions() {
		//listener for backButton
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastWindow.setVisible(true);
				SettingsGUI.this.dispose();
			}
		});
		
		//listener for start game
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
	}
	
	/**
	 * Stars the game with the given settings
	 */
	protected abstract void startGame();
}
