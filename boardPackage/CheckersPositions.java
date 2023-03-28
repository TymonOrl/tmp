package boardPackage;

import java.util.Iterator;

public class CheckersPositions {
	
	int tile[][] = new int[8][8];
	Boolean white[][] = new Boolean[8][8];
	
	CheckersPositions() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if( y%2==0 && x%2==1){
					white[x][y] = false;
				}
				else if ( y%2==1 && x%2==0 ) {
					white[x][y] = false;
				}
				else {
					white[x][y] = true;
				}
			}
		}
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
					// Placing white pieces
					if( (x+y*8)<(8*3) && !white[x][y]) {
						tile[x][y] = Checker.WCHECKER.value;
					}
					// Placing black pieces
					else if( (x+y*8)>=(8*5) && !white[x][y]) {
						tile[x][y] = Checker.BCHECKER.value;
					} // Value for empty tiles
					else {
					tile[x][y] = Checker.NONE.value;
					}

				}
			}
		}
	/*
	public static void main(String[] args) {
		CheckersPositions checkersPosition = new CheckersPositions();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				System.out.println((x+y*8) + " " +
			checkersPosition.tile[x][y] );
			}
		}	
	}
	*/
}
