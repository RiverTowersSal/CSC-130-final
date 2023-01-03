/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;

import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			
	private static stopWatchX sw = new stopWatchX(250);
	private static stopWatchX timer = new stopWatchX(0); 	// controls movement speed
	private static int i=1;
	
	// Static Method(s)
	public static void processKey(char key){
//		if(key == ' ')				return;
//		// Debounce routine below...
//		if(key == last)
//			if(sw.isTimeUp() == false)			return;
//		last = key;
//		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
		
		case 'w':
			Main.trigger = "";
			if (timer.isTimeUp()){
				Main.last.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
				Main.playerSprite.getCoords().adjustY(-10);
				Main.playerSprite.setTag("bear5");

				timer.resetWatch();
			}
			break;
		
		case 's':
			Main.trigger = "";
			if (timer.isTimeUp()){
				Main.last.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
				Main.playerSprite.getCoords().adjustY(10);
				Main.playerSprite.setTag("bear6");
				timer.resetWatch();
			}
			break;
			
		case 'a':
			Main.trigger = ""; 										// Toggles off dialogue text
			if (timer.isTimeUp()){									
				Main.last.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
				Main.playerSprite.getCoords().adjustX(-10);
				Main.playerSprite.setTag("bear"+i);
				if (i >= 4){
					i = 1;
				}
				i++;
				timer.resetWatch();
			}
			break;
			
		case 'd':
			Main.trigger = "";
			if (timer.isTimeUp()){
				Main.last.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
				Main.playerSprite.getCoords().adjustX(10);
				Main.playerSprite.setTag("bear"+i);
				if (i >=4){
					i = 1;
				}
				i++;
				timer.resetWatch();
			}
			break;
		
		case '$':				//spacebar
			if(key == ' ')				return;
			if(key == last)
				if(sw.isTimeUp() == false)			return;
			last = key;
			sw.resetWatch();			
			/* Code to open dialog boxes */
			if(Main.checkCollision(Main.playerBox, Main.stopsign)){
				Main.trigger = "A stop sign in the forest? Crazy!";
			}
			if(Main.checkCollision(Main.playerBox, Main.barbwire)){
				Main.trigger = "Ouch, Why is there barbwire here?";
			}
			if(Main.checkCollision(Main.playerBox, Main.tree)){
				Main.trigger = "I dont like how this thing looks";
			}
			break;
		
		case 'm':
			// For mouse coordinatesif(key == ' ')	
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}