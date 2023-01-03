package Data;

public class boundingBox {
	// Fields
		private spriteInfo spriteData;
		private int x1;
		private int x2;
		private int y1;
		private int y2;
		
		
		public boundingBox(int x1a, int x2a, int y1a, int y2a){
			x1 = x1a;
			x2 = x2a;
			y1 = y1a;
			y2 = y2a;		
		}
		
		//Automatically sets the bounding box of the sprite to 128x128 
		public boundingBox(spriteInfo sprite1){	
			spriteData = sprite1;
			x1 = spriteData.getCoords().getX();
			x2 = spriteData.getCoords().getX() + 128;
			y1 = spriteData.getCoords().getY();
			y2 = spriteData.getCoords().getY() + 128;
		}
		
		// Sprite constructor with adjustments for each boundary relative to the origin
		public boundingBox(spriteInfo sprite1, int adjustX1, int adjustX2, int adjustY1, int adjustY2){	
			spriteData = sprite1;
			x1 = spriteData.getCoords().getX() + adjustX1;
			x2 = spriteData.getCoords().getX() + adjustX2;
			y1 = spriteData.getCoords().getY() + adjustY1;
			y2 = spriteData.getCoords().getY() + adjustY2;
		}
		
		public void setX1(int val){
			x1 = val;
		}
		
		public void setX2(int val){
			x2 = val;
		}
		
		public void setY1(int val){
			y1 = val;
		}
		
		public void setY2(int val){
			y2 = val;
		}

		public int getX1(){
			return x1;
		}
		
		public int getX2(){
			return x2;
		}
		
		public int getY1(){
			return y1;
		}
		
		public int getY2(){
			return y2;
		}
		

}
