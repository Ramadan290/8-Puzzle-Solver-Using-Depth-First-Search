package Puzzle;
import java.util.ArrayList;
import java.util.List;

/**This class contains all the states on the Board , All Movements , Depth , Space and Goal (when reached)**/
public class BoardNode {
		
	private  int[][]  state = new int [3][3];
	private List<BoardNode> children;
	private BoardNode parent;
	private int depth;
	private int blankrow;
	private int blankcol;
	private Directions direction;
	private String stringState;

	
	public BoardNode(int [][] state) {
		this.state = state; // the state
		this.depth = 1; // the depth
		this.children = new ArrayList<BoardNode>(); //the children of the node
		this.parent = null;
		this.stringState = stringBoard();
		this.direction = null;

		//This loop is to decide the blank box (I decided the blank is going to be 0)
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=2; j++) {
				if(state[i][j]==0) {
					this.blankrow = i;
					this.blankcol = j;
					break;
				}
			}
		}
		
	}

	//This Method returns the Board in the form of a string so we can print it (I didn't do that myself but i understand it)
	public String stringBoard() {
		StringBuilder stringBuilder = new StringBuilder(); // StringBuilder is a known class used to convert anything into string much like parse method
		for (int i =0; i<state.length; i++) {
			for(int j = 0; j<state[i].length;j++ ) {
				stringBuilder.append(state[i][j]);
			}
		}
		return stringBuilder.toString();
	}
	
	public void addChild(BoardNode child) { //adding Child node
		child.setParent(this);
		child.setDepth(this.getDepth()+1);
		this.children.add(child);
	
	}
	
	public void setParent(BoardNode parent) { //setting the Parent of the node
		this.parent = parent;
	} //setting child parent
	
	public void setDepth(int depth) {  //setting the Depth of the node
		this.depth = depth;
	} // used to determine depth
	public int getDepth() {  //getting the Depth of the node
		return depth;
	}
	
	public BoardNode getParent() {  //getting the Parent of the node
		return parent;
	}
	
	public int getRowBlank() {  //getting the Row of the zero tile
		return blankrow;
	}
	
	public int getColBlank() { //getting the Column of the zero tile
		return blankcol;
	}
	
	public int [][] getMatrix(){ //getting the state in array form
		return state;
	}

	
	
	public List<BoardNode> getChildren(){ //getting the children
		return children;
	}
	public void setChildren(List<BoardNode> children) { //setting the children
		this.children =  children;
	}

	/*VIS*/
	//Creating the possible states from the current Node (Very important reconsider changing it if u find an error it will probably be here (This is me Abdallah))
	public BoardNode createChild(int a, int b) {
		int temp[][] = new int[state.length][state.length];
		for(int i=0; i<state.length; i++)
			  for(int j=0; j<state[i].length; j++)
			    temp[i][j]=state[i][j];
		temp[blankrow][blankcol] = temp[a][b];
		int cost = state[a][b]; 
		temp[a][b] = 0;
		BoardNode child = new BoardNode(temp);
		addChild(child);
		return child;
	}
	
	public void setDir(Directions directions) {			//setting the Direction moved
		this.direction = directions;
	}
	public Directions getDir() {				//getting the direction moved
		return direction;
	}
	
	public boolean isGoal() {				//checking if node is goal node
		boolean result = false;
		int [][] goal = {
				  		 {1,2,3},
						 {4,5,6},
						 {7,8,0}
		};
		BoardNode goalNode = new BoardNode(goal);
		result = this.equals(goalNode);
		return result;
	}


	@Override
	public boolean equals(Object object ) {    //equals for HashMap
		
		if(!(object instanceof BoardNode)) {
			return false;
		}
		BoardNode check = (BoardNode) object;
		
		return check.getString().equals(this.getString());
	}
	
	@Override
	public int hashCode() {			//Hashcode generated from String version of board
		int result = 17;
		result = 37 * result + this.getString().hashCode();
		return result;
	}
	
	public String getString() {			//getting String version of Board
		return stringState;
	}

}
