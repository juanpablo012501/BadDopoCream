package domain;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The class that defines the general features  of Bad Dopo-Cream game level.
 * @author Paula Alejandra Díaz (PAD)
 * @author Juan Pablo Vélez (JPV)
 */
public abstract class Level{
	protected static int heigthLimit = 18; 
	protected static int widthLimit = 18;
	protected IceCream IOne;
    protected IceCream ITwo;
    protected ArrayList<Enemy> enemies;
    protected List<Obstacle> elements;  //Ajustar lalista que se utilizara
    protected HashMap<Integer, Fruit> waves;
    protected ArrayList<Fruit> actualWave;
    protected int time;
    protected int limitTime;
    protected Placeable[][] map;
    
    /**
     * Constructor of a machine vs. machine mode level
     */
    public Level(){}

    /**
     * Constructor of a Single player mode level
     * @param char (color) the color of the iceCream that will be used
     */
    public Level(char color){}

    /**
     * Constructor of a player vs. player mode level
     * @param char (colorOne) the color of the ice cream of the first player
     * @param char color (colorTwo) the color of the ice cream of the second player
     */
    public Level(char colorOne, char colorTwo){}

    /**
     * Constructor of a player vs. machine mode level
     * @param int (uselessParameter) in order to build another constructor that only requires a color (char), we declare this parameter
     * @param char 8color) the color of the ice cream of the player
     */
    public Level(int uselessParameter, char color){}
}
