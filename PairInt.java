//Sera Kim

package hw4_S_Kim;

import java.awt.Color;

public class PairInt {

	private int x;		//Initialize x coordinate
	private int y;		//Initialize y coordinate

	//Constructor pairs up coordinates x and y into a pair
	public PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//Returns x coordinate from PairInt
	public int getX() {
		return x;
	}

	//Returns y coordinate from PairInt
	public int getY() {
		return y;
	}

	//Sets the x coordinate within PairInt
	public void setX(int x) {
		this.x = x;
	}

	//Sets the y coordinate within PairInt
	public void setY(int y) {
		this.y = y;
	}

	//Returns true if PairInt is equal to Object P
	public boolean equals(PairInt p)  {
		if (this.x == p.getX() && this.y == p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}

	//Returns String value of PairInt
	public String toString() {
		return ("(" + this.x + ", " + this.y + ")");
	}

	//Copies and returns values of PairInt
	public PairInt copy() {
		return new PairInt(this.x, this.y);
	}
}
