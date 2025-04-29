package Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**This Class traces back through the search and returns information**/
public class Paths_Taken {
	List<BoardNode> path;
	Info info; //creating object that will be used to print Time and Space


	/*Method used to find Path*/
	public Paths_Taken(BoardNode initialNode, BoardNode goalNode, Info inf) {
		path = this.getPath(initialNode, goalNode);
		this.info = inf;
	}
	

	/*Method used to trace back to node's parent to go up*/
	private List<BoardNode> getPath(BoardNode initialNode, BoardNode goalNode) {
		BoardNode tempNode = goalNode;
		List<BoardNode> list = new ArrayList<BoardNode>();
		
		while(!(tempNode.equals(initialNode))) {
			list.add(tempNode);
			tempNode = tempNode.getParent();
		}

		list.add(initialNode);
		return list;  // a list of the path is returned in reverse order
	}
	

	/*Method ued to print info from Initial Node to Goal Node*/
	public void printPath() {
		int size = path.size();

		for(int i= size-1;i>=0;i--) {
			System.out.println();
			System.out.println();
			System.out.println("Direction Moved: " + path.get(i).getDir());
			System.out.println("Depth: " + path.get(i).getDepth());
			System.out.println();
			System.out.println("Current Node: \n");
			System.out.println(Arrays.deepToString(path.get(i).getMatrix()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
			System.out.println();
		}
		System.out.println("**********Goal Reached***********");
		System.out.println("Time: " + info.getTime()); // There is a problem in time it is not working as it should be but this is an extra thing i added sooooooo....
	}
}


