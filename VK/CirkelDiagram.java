import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Class for displaying simulation data in a pie chart
 * 
 * Special thanks go out to nraj of Stack Overflow
 * http://stackoverflow.com/questions/13662984/creating-pie-charts-programmatically
 * 
 * @author leonwetzel
 *
 */
public class CirkelDiagram extends JComponent {
	
	private FieldStats stats = new FieldStats();
	private HashMap<Class, Counter> counters = stats.getCounters();
	private ArrayList<Integer> aantal = getCounts();
	
	private double foxCount;
	private double rabbitCount;
	private double pinguinCount;
	private double hunterCount;

	// hoeveelheid actors
	private static final int HOEVEELHEID_ACTORS = 4;
	// 'pizzastukken' van het cirkeldiagram
	private CirkelDeel[] delen = { new CirkelDeel(foxCount, Color.black),
			new CirkelDeel(rabbitCount, Color.green), new CirkelDeel(pinguinCount, Color.yellow),
			new CirkelDeel(hunterCount, Color.red) };

	/**
	 * Constructor
	 */
	public CirkelDiagram() {
		getCounts();
		foxCount = 10.4;//aantal.get(0);
		rabbitCount = 15.3;//aantal.get(1);
		pinguinCount = 49.9;//aantal.get(2);
		hunterCount = 10.2;//aantal.get(3);		
		CirkelDeel[] delen = new CirkelDeel[HOEVEELHEID_ACTORS];
	}

	/**
	 * Methode om een cirkeldiagram te maken met behulp van het veld 'delen'
	 * @param g
	 */
	public void paint(Graphics g) {
		drawPie((Graphics2D) g, getBounds(), delen);
	}
	
	/**
	 * Method to retrieve counts from the hashmap
	 */
	public ArrayList<Integer> getCounts()
	{	
	    for(Class key : counters.keySet()) {
	        Counter info = counters.get(key);
	        info.getCount();
	        aantal.add(info.getCount());
	    }		
	    return aantal;
	}

	/**
	 * Methode om een cirkeldiagram te tekenen
	 * @param g
	 * @param gebied
	 * @param delen
	 */
	public void drawPie(Graphics2D g, Rectangle gebied, CirkelDeel[] delen) {
		double totaal = 0.0D;
		for (int i = 0; i < delen.length; i++) {
			totaal += delen[i].getValue();
		}
		double curValue = 0.0D;
		int startAngle = 0;
		for (int i = 0; i < delen.length; i++) {
			startAngle = (int) (curValue * 360 / totaal);
			int arcAngle = (int) (delen[i].getValue() * 360 / totaal);
			g.setColor(delen[i].getColor());
			g.fillArc(gebied.x, gebied.y, gebied.width, gebied.height, startAngle,
					arcAngle);
			curValue += delen[i].getValue();
		}
	}
}
