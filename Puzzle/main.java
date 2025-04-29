package Puzzle;

public class main {

	public static void main(String[] args) {

		// Board with the Initial state (as mentioned in Assignment)
		int[][] Node = {
				{1, 3, 6},
				{4, 2, 8},
				{7, 5, 0},
		};

		// Initial Node
		BoardNode Board = new BoardNode(Node);

		Search search; //Creating Object of Search
		System.out.println("*****************************Algorithm for 8 puzzle Board*****************************\n");
		System.out.println("^^^^^^^^^^^^^^^Depth First Search^^^^^^^^^^^^^^^");
		search=new DFS(Board);
		search.search();
	}
}

	




