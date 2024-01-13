# maze-game

## Overview

This Java application is designed to solve maze problems using backtracking. The program includes functionality to find a path through a maze and determine the shortest path.

## Getting Started

To run the Maze Game Application on your local machine, follow these steps:

1. Clone the repository to your local environment.
2. Compile and run the `MazeTest.java` file.

## Usage

1. Toggle cell colors by clicking on the buttons in the grid.
2. Click the "SOLVE" button to find a path through the maze.
3. Click the "RESET" button to reset the maze to its initial state.

## Files

- **Maze.java**: This file contains the main logic for solving maze problems using recursive backtracking. It includes methods for finding a path through a maze, finding all possible paths, and determining the shortest path.
- **TwoDimGrid.java**: The `TwoDimGrid` class represents a 2D grid of buttons that can be toggled between different colors. It is used to visualize the maze and interactively set the colors of cells.
- **GridColors.java**: An interface defining color constants used in the application, such as `PATH`, `BACKGROUND`, `NON_BACKGROUND`, `ABNORMAL`, and `TEMPORARY`.
- **MazeTest.java**: A test class that sets up the graphical user interface (GUI) for the maze-solving application. It includes buttons for solving and resetting the maze.
- **PairInt.java**: A utility class representing a pair of integer coordinates (x, y). It is used to store and manipulate coordinates within the application.

## Acknowledgments
The code is based on the work of Koffman and Wolfgang, the authors of the textbook (Data Structures: Abstraction and Design Using Java).
