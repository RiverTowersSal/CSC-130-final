package Main;

import java.awt.Color;

import java.util.*;

import Data.Vector2D;
import Data.boundingBox;
import logic.Control;
import timer.stopWatchX;
import Data.spriteInfo;
import FileIO.EZFileRead;
import FileIO.EZFileWrite;

public class Main{
	// Fields (Static) below...

	public static int currentSpriteIndex = 1;
	public static String trigger = "";

	//Current position
	public static Vector2D currentVec = new Vector2D(200, 900);
	
	//Previous position
	public static Vector2D prevVec = new Vector2D(0, 0);
	
	public static boundingBox playerBox;
	public static boundingBox stopsign = new boundingBox(0, 180, 246, 1000); /* Interactable object */
	public static boundingBox tree = new boundingBox(1200, 1440, 260, 1000); /* Interactable object */
	public static boundingBox barbwire = new boundingBox(0, 180, 0, 230); /* Interactable object */

	
	public static spriteInfo playerSprite = new spriteInfo(currentVec, "bear"+ currentSpriteIndex);
	public static spriteInfo last = new spriteInfo (prevVec, playerSprite.getTag()); 
	
	public static ArrayList<boundingBox> boxes = new ArrayList<>(); 	// Holds bounding boxes
	public static ArrayList<spriteInfo> sprites = new ArrayList<>(); 	// Holds sprites
	
	
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	
	
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		boxes.add(new boundingBox(0, 1408, 0, 161));  	// Top of screen boundary
		boxes.add(new boundingBox(0, 1408, 1000, 1040));	// Bottom of screen boundary
		boxes.add(new boundingBox(0, 50, 0, 1000));	// Stop sign stick Boundary
		boxes.add(new boundingBox(1320, 1440, 570, 1000));	// Right Boundary
		boxes.add(new boundingBox(1291, 1440, 260,570 )); //Middle of tree boundary
		boxes.add(new boundingBox(0, 150, 246, 440)); // Stop sign sign boundary
		boxes.add(new boundingBox(1200, 1440, 0, 260)); // top right tree boundary	
		
		
		// Add all spriteInfo objects to an arrayList
		sprites.add(new spriteInfo(new Vector2D(0, 0), "background")); 
		sprites.add(playerSprite);
	}
	
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		

		
		/* Player bounding box updated by current playerSprite position and adjusted bounds relative to origin (top left) */
		playerBox = new boundingBox(playerSprite, 20, 108, 108, 120);  	
		
		/* Check collision between player and any rigid body stored in the array and bounce the player if true */
		for (int i = 0; i < boxes.size(); i++)
			if (checkCollision(playerBox, boxes.get(i)))
				bouncePlayer(); 
		
		//Iterate sprites through arraylist
		for (int i = 0; i < sprites.size(); i++)
			ctrl.addSpriteToFrontBuffer(sprites.get(i).getCoords().getX(), sprites.get(i).getCoords().getY(), 		
					sprites.get(i).getTag());
		
		ctrl.drawString(415, 600, trigger, Color.GREEN);
	}
	
	// Additional Static methods below...(if needed)
	
		public static boolean checkCollision(boundingBox box1, boundingBox box2){
			if (((box1.getX1() > box2.getX2()) 
				|| (box1.getX2() < box2.getX1()) 
				|| (box1.getY1() > box2.getY2()) 
				|| (box1.getY2() < box2.getY1())))
				return false;
			else 
				return true;
		}
		// Method for bouncing the player back to the last position after a collision detection
		public static void bouncePlayer(){
			if ((playerSprite.getCoords().getX() - last.getCoords().getX()) != 0){
				if ((playerSprite.getCoords().getX() - last.getCoords().getX()) > 0)		// If moved from left to right
					playerSprite.getCoords().adjustX(-10);								
				if ((playerSprite.getCoords().getX() - last.getCoords().getX()) < 0)  	// If moved from right to left
					playerSprite.getCoords().adjustX(+10);
			}
			if ((playerSprite.getCoords().getY() - last.getCoords().getY()) != 0){
				if ((playerSprite.getCoords().getY() - last.getCoords().getY()) > 0)		// If moved from up to down
					playerSprite.getCoords().adjustY(-10);
				if ((playerSprite.getCoords().getY() - last.getCoords().getY()) < 0)		// If moved from down to up
					playerSprite.getCoords().adjustY(+10);
			}
}
		}
