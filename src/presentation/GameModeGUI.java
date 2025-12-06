package presentation;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * When creating a new game you have to choose a game mode (single player, two players, player vs machine or machine vs machine.
 * This class is a menu to choose the game mode
 * @author PAD
 * @author JPV
 */
public class GameModeGUI extends JFrame{
	private JFrame lastWindow;		//used to go back to the last window
	private ArrayList<ChooserPanel> panels = new ArrayList<ChooserPanel>();
	
	private JPanel superiorPanel;
	private JPanel inferiorPanel;
	private JButton singlePlayerButton;
	private JButton twoPlayersButton;
	private JButton playerMachineButton;
	private JButton machineMachineButton;
	private JButton backButton;
	
	//arrays for the images
	private static String[] IPATHS = {"sources/vanilla.png", "sources/chocolate.png", "sources/strawberry.png"};
	private static ArrayList<String> ICECREAMPATHS = new ArrayList<String>(Arrays.asList(IPATHS));
	private static String[] MPATHS = {"sources/fearful.png", "sources/expert.png", "sources/hungry.png"};
	private static ArrayList<String> MACHINEPATHS = new ArrayList<String>(Arrays.asList(MPATHS));
	private static String[] LPATHS = {"sources/level1.png", "sources/level2.png", "sources/level3.png"};
	private static ArrayList<String> LEVELPATHS = new ArrayList<String>(Arrays.asList(LPATHS));
	private ChooserPanel levelsPanel = new ChooserPanel(LEVELPATHS, "sources/levelsBackground.png", 'l');
	
	/**
	 * Constructor of this menu (GUI)
	 * @param JFrame the last JFrame (the one behind this one)
	 */
	public GameModeGUI(JFrame old) {
		lastWindow = old;
		
		prepareElements();
		
		prepareActions();
	}
	
	/**
	 * Sets the swing and awt instances used in the class
	 */
	private void prepareElements() {
		//variables
		ImageIcon icon = new ImageIcon("sources/gameIcon.png");
		JPanel topSection = new JPanel();
		topSection.setOpaque(false);
		//limits for the buttoner
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(500, 25));
		north.setOpaque(false);
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(500, 25));
		south.setOpaque(false);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(25, 100));
		east.setOpaque(false);
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(25, 100));
		west.setOpaque(false);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2, 2, 15 ,15));
		center.setOpaque(false);
		
		//Settings for the buttons
		prepareButtons();
		
		//setting for the superior panel
		superiorPanel = new JPanel() {
			private Image backgroundImage = new ImageIcon("sources/gameModebackground.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {				
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		
		};
		superiorPanel.setLayout(new BorderLayout());
		superiorPanel.setPreferredSize(new Dimension(500, 200));
		topSection.setLayout(new FlowLayout(FlowLayout.LEFT, 0,  0));
		topSection.add(backButton);
		superiorPanel.add(topSection, BorderLayout.NORTH);
		
		//setting for the inferior panel
		inferiorPanel = new JPanel() {
			private Image image = new ImageIcon("sources/startBackground.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {				
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		
		};
		inferiorPanel.setLayout(new BorderLayout());
		inferiorPanel.setPreferredSize(new Dimension(500, 300));
		inferiorPanel.add(north, BorderLayout.NORTH);
		inferiorPanel.add(south, BorderLayout.SOUTH);
		inferiorPanel.add(east, BorderLayout.EAST);
		inferiorPanel.add(west, BorderLayout.WEST);
		inferiorPanel.add(center, BorderLayout.CENTER);
		center.add(singlePlayerButton);
		center.add(twoPlayersButton);
		center.add(playerMachineButton);
		center.add(machineMachineButton);
		
		//main configurations
		this.setTitle("Game modes");
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adding elements
		this.add(superiorPanel, BorderLayout.NORTH);
		this.add(inferiorPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Sets the buttons of the JFrame
	 */
	private void prepareButtons() {
		//back
		backButton = new JButton() {
			private Image backImage = new ImageIcon("sources/backImage.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		backButton.setPreferredSize(new Dimension(40, 35));
		backButton.setBorderPainted(false);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setOpaque(false);
		
		//single player
		singlePlayerButton = new JButton() {
			private Image backImage = new ImageIcon("sources/singlePlayerB.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		
		//two players
		twoPlayersButton = new JButton() {
			private Image backImage = new ImageIcon("sources/twoPlayersB.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		
		//player vs. machine
		playerMachineButton = new JButton() {
			private Image backImage = new ImageIcon("sources/PvMB.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
		
		//machine vs. machine
		machineMachineButton = new JButton() {
			private Image backImage = new ImageIcon("sources/MvMB.png").getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backImage,  0, 0, getWidth(), getHeight(), this);
			}
		};
	}
	
	/**
	 * Sets the actions assigned to each element in the class
	 */
	private void prepareActions() {
		//listener for backButton
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lastWindow.setVisible(true);
				GameModeGUI.this.dispose();
			}
		});
		//listener for singlePlayerButton
		singlePlayerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooserPanel playerPanel = new ChooserPanel(ICECREAMPATHS, "sources/playerBackground.png", 'i');
				panels.add(playerPanel);
				panels.add(levelsPanel);
				
				SettingsGUI newWindow = new SettingsGUI(GameModeGUI.this, panels);
				newWindow.setVisible(true);
				GameModeGUI.this.setVisible(false);
			}
		});
		
		//listener for twoPlayerButton
		twoPlayersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooserPanel playerOnePanel = new ChooserPanel(ICECREAMPATHS, "sources/playerBackground.png", 'i');
				ChooserPanel playerTwoPanel = new ChooserPanel(ICECREAMPATHS, "sources/playerBackground.png", 'i');
				panels.add(playerOnePanel);
				panels.add(playerTwoPanel);
				panels.add(levelsPanel);
				
				SettingsGUI newWindow = new SettingsGUI(GameModeGUI.this, panels);
				newWindow.setVisible(true);
				GameModeGUI.this.setVisible(false);
			}
		});
		
		//listener for playerMachineButton
		playerMachineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooserPanel playerPanel = new ChooserPanel(ICECREAMPATHS, "sources/playerBackground.png", 'i');
				ChooserPanel machinePanel = new ChooserPanel(MACHINEPATHS, "sources/machineBackground.png", 'm');
				panels.add(playerPanel);
				panels.add(machinePanel);
				panels.add(levelsPanel);
				
				SettingsGUI newWindow = new SettingsGUI(GameModeGUI.this, panels);
				newWindow.setVisible(true);
				GameModeGUI.this.setVisible(false);
			}
		});
		
		//listener for machineMachineButton
		machineMachineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChooserPanel machineOnePanel = new ChooserPanel(MACHINEPATHS, "sources/machineBackground.png", 'm');
				ChooserPanel machineTwoPanel = new ChooserPanel(MACHINEPATHS, "sources/machineBackground.png", 'm');
				panels.add(machineOnePanel);
				panels.add(machineTwoPanel);
				panels.add(levelsPanel);
				
				SettingsGUI newWindow = new SettingsGUI(GameModeGUI.this, panels);
				newWindow.setVisible(true);
				GameModeGUI.this.setVisible(false);
			}
		});
	}
	
	/**
	 * Removes all panels added before
	 */
	public void removePanels() {
		panels.clear();
	}
}
