# Game of Life
## Conway's Game of Life 
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life


Initially, some cells are specified in a given matrix. Then the game is set in motion, meaning that the cells start living their lives according to predefined rules. The rules determine whether a cell will survive, die, or reproduce. The decision is based on the number of neighbors a given cell has.

### Rules:
Each cell can have up to 8 neighbors (above, below, to the right, to the left, and diagonally).

* If a cell has fewer than 2 neighbors, it dies (underpopulation).
* If a cell has more than 3 neighbors, it dies (overpopulation).
* If a cell has 2 or 3 neighbors, it continues to live.
* If a dead cell (i.e., an empty cell) has exactly 3 neighbors, it comes to life (reproduction).

