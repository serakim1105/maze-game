//Sera Kim

package hw4_S_Kim;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public Maze(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		try {
		findAllMazePaths(0,0);
		System.out.println("Min Path:\n" + findMazePathMin(0,0));
		return findMazePath(0, 0); // (0, 0) is the start point.
		}
		catch (Exception e){
			System.out.println("[[]]");
		}
		return false;
	}

	/**
	 * Attempts to find a path through point (x, y).
	 * @pre Possible path cells are in BACKGROUND color;
	 *      barrier cells are in ABNORMAL color.
	 * @post If a path is found, all cells on it are set to the
	 *       PATH color; all cells that were visited but are
	 *       not on the path are in the TEMPORARY color.
	 * @param x The x-coordinate of current point
	 * @param y The y-coordinate of current point
	 * @return If a path through (x, y) is found, true;
	 *         otherwise, false
	 */
	public boolean findMazePath(int x, int y) {
		//Base case: if current cell is outside of maze, return false
		if ((x > maze.getNCols() - 1) || (y > maze.getNRows() - 1) || (x < 0) || (y < 0)) {
			return false;
		}

		//Base case: if current cell doesn't have NON-BACKGROUND, return false
		if (maze.getColor(x, y) != NON_BACKGROUND) {
			return false;
		}

		//Base case: if current cell is exit cell, paint cell with PATH and return true
		if ((x == maze.getNCols() - 1) && (y == maze.getNRows() - 1)) {
			maze.recolor(x, y, PATH);
			return true;
		}

		/* Recursive case: if not all of the above, paint cell with PATH
		 * For each neighbor, check if they are part of the path  
		 * If part of the path, return true
		 * If not part of the path, paint cell with TEMPORARY 	
		 */
		maze.recolor(x, y, PATH);
		if ((findMazePath(x - 1, y)) || (findMazePath(x + 1, y)) ||
				(findMazePath(x, y - 1)) || (findMazePath(x, y + 1))) {
			return true;
		}

		//If all above tests fail, paint cell with TEMPORARY
		maze.recolor(x,  y, TEMPORARY);
		return false;
	}

	//Wrapper method to findMazePathStackBased method
	public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
		//Initialize new result list, which stores all final paths
		ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
		//Initialize new trace Stack, which stores all possible paths
		Stack<PairInt> trace = new Stack<>();
		//Call helper method 
		findMazePathStackBased(0, 0, result, trace);
		//For loop to print all element of ArrayList
		if (result.size() != 0) {
			System.out.println(result.get(0));
			for (int i = 1; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
		
		return result;
	}

	//Helper method to findAllMazePath method
	public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		//Base case: if current cell is outside of maze, return
		if ((x > maze.getNCols() - 1) || (y > maze.getNRows() - 1) || (x < 0) || (y < 0)) {
			return;
		}

		//Base case: if current cell doesn't have NON-BACKGROUND, return 
		if (maze.getColor(x, y) != NON_BACKGROUND) {
			return;
		}

		//Base case: if current cell is exit cell, add the elements in trace to result
		if ((x == maze.getNCols() - 1) && (y == maze.getNRows() - 1)) {
			//Initialize new PairInt object with current coordinates
			PairInt newPairInt = new PairInt(x, y);
			//Add the new object to trace
			trace.push(newPairInt);
			//Create a new ArrayList
			ArrayList<PairInt> newArr = new ArrayList<PairInt>();
			//Add trace to new ArrayList
			newArr.addAll(trace);
			//Add contents of newArr to result
			result.add(newArr);
			//Pop exit cell from trace
			trace.pop();
			return;
		}

		/* Recursive case: if not all of the above, paint cell with PATH
		 * For each neighbor, check if they are part of the path  
		 * If part of the path, add to trace
		 * Upon returning from recursion, remove the color for backtracking	
		 */

		//Initialize new PairInt object with current coordinates
		PairInt newPairInt = new PairInt(x, y);
		//Add the new object to trace
		trace.push(newPairInt);
		//Recolor celL to PATH
		maze.recolor(x,  y, PATH);
		//Check all four neighbors
		findMazePathStackBased(x - 1, y, result, trace);
		findMazePathStackBased(x + 1, y, result, trace);
		findMazePathStackBased(x , y - 1, result, trace);
		findMazePathStackBased(x , y + 1, result, trace);
		//Reset color to NON_BACKGROUND color
		maze.recolor(x,  y, NON_BACKGROUND);
		//Pop current Pair from trace
		trace.pop();
		return;

	}

	//Returns the shortest path in result
	public ArrayList<PairInt> findMazePathMin(int x, int y) {
		//Initialize new result list, which stores all final paths and print
		ArrayList<ArrayList<PairInt>> result = findAllMazePaths(x, y);
		//Initialize a new array with elements size of each result element
		int sizeArray[] = new int[result.size()];
		//Assign value to each index of size
		for (int i = 0; i < result.size(); i++) {
			sizeArray[i] = result.get(i).size();
		}
		//Find minimum element in array size
		int index = 0;
		int min = sizeArray[0];

		for (int i = 0; i < sizeArray.length - 1; i++) {
			if (sizeArray[i] < min) {
				min = sizeArray[i];
				index = i;
			}
		}

		//Return the shortest path
		return result.get(index);
	}

	/*<exercise chapter="5" section="6" type="programming" number="2">*/
	public void resetTemp() {
		maze.recolor(TEMPORARY, BACKGROUND);
	}
	/*</exercise>*/

	/*<exercise chapter="5" section="6" type="programming" number="3">*/
	public void restore() {
		resetTemp();
		maze.recolor(PATH, BACKGROUND);
		maze.recolor(NON_BACKGROUND, BACKGROUND);
	}
	/*</exercise>*/
}
/*</listing>*/


