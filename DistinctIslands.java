class DistinctIslands {
    
    //We will trace the path during DFS and store in set. The number of unique paths is result. 0 - start . 1- top, 2 - bottom, 3 - left, 4 - right, 0 - at end after tracing all 4 dir
    
    int[][] grid;
    List<Integer> shape;
    boolean[][] seen;
    
    public int numDistinctIslands(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        this.grid = grid;
        
        seen = new boolean[m][n];
        
        //It will store all the distinct island paths
        Set<List<Integer>> result = new HashSet<>();
        
        //Searching for island in the grid
        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){

                    shape = new ArrayList<Integer>();
                    
                    //We initially pass the direction as 0
                    dfs(i, j, 0);
                    
                    if(!shape.isEmpty()){
                         result.add(shape);
                    }
            }
        }
        
        return result.size();
    }
    
    public void dfs(int r, int c, int dir){
        
        if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 && !seen[r][c]){

            //Mark the cell as seen
            seen[r][c] = true;
            
            //Add direction to list
            shape.add(dir);
            
            dfs(r+1, c, 1);
            dfs(r-1, c, 2);
            dfs(r, c-1, 3);
            dfs(r, c+1, 4);
            
            //Add a number so that we have checked all the directions
            shape.add(0);

        }
    }   
    
}
