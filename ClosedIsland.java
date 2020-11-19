class ClosedIsland {
    public int closedIsland(int[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int closedIsland = 0, rows = grid.length, cols = grid[0].length;
        
        //0 = land, 1 = water, -1 = we mark -1 for visited cells
        //The closed island will never be on perimeter as the corner cells are not surrounded by any water. Hence we skip all corner cells
        for(int r = 1; r < rows - 1; r ++){
            
            for(int c = 1; c < cols - 1; c++){
                
                //If we find a land we perform DFS and then check whether it is closed or not
                if(grid[r][c] == 0){
                    
                    if(isClosedIsland(grid, r, c, rows, cols))
                        closedIsland++;
                }
            }
        }
        
        return closedIsland;
        
    }
    
    public boolean isClosedIsland(int[][] grid, int i, int j, int rows, int cols){
        
        //If we find a water (ie 1) then we return true cuz then it is a closed island. If we find -1 (visited cell) then return true cuz we dont need to do dfs on cell which has already been seen / done before
        if(grid[i][j] == 1 || grid[i][j] == -1)
            return true;
        
        //If the cell is in perimeter then it can't be closed island
        if(i == 0 || j == 0 || i == rows - 1 || j == cols - 1)
            return false;
        
        //If we reached here then it means this cell is land which is not on perimeter, mark as visited
        grid[i][j] = -1;
        
        //Perform DFS on the land cell
        boolean top = isClosedIsland(grid, i - 1, j, rows, cols);
        
        boolean right = isClosedIsland(grid, i, j + 1, rows, cols);
        
        boolean bottom = isClosedIsland(grid, i + 1, j, rows, cols);
        
        boolean left = isClosedIsland(grid, i, j - 1, rows, cols);
        
        //If we find water on all 4 sides of cell then it is a closedIsland
        return top && right && bottom && left;
              
    }
}
