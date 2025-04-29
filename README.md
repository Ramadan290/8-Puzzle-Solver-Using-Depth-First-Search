# 🧩 8-Puzzle Solver Using Depth First Search

This project implements a complete AI solution for solving the **8-Puzzle problem** using the **Depth First Search (DFS)** algorithm.  
The solver models each board configuration as a node, explores possible moves recursively, and traces the path from the initial state to the goal state.

---

## 🚀 Features
- **State Modeling:** Each puzzle configuration is stored as a `BoardNode` with depth, parent, and movement direction tracking.
- **DFS Search Algorithm:** Uses a Stack (LIFO) structure to explore nodes deeply before backtracking.
- **Path Reconstruction:** Upon finding the goal, the program traces and prints the full sequence of moves.
- **Cycle Detection:** Avoids revisiting already-explored board states using HashMaps.
- **Abstract Interface:** A `Search` interface allows for future extension to other search algorithms (e.g., BFS, A*).

---

## 🛠️ Technologies Used
- Java 11+
- Standard Java Collections (`Stack`, `Queue`, `HashMap`, etc.)



---

## ▶️ How to Run
1. Compile all `.java` files.
2. Run `main.java`.
3. The program will:
   - Display the moves from the starting board to the goal board.
   - Show direction, depth, and board layout at each step.
   - Print total time (nodes visited).

---

## 🧠 Personal Note
This project represents my **first major experience designing a full AI search algorithm in Java**.  
It involved significant learning about recursion, data structures (Stacks, HashMaps), search strategies, and clean code architecture.

Although I can now code more efficiently, this project remains a strong foundation for my future work in AI and problem-solving.

---

