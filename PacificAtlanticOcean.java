class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> cells = new ArrayList<>();
        
        if(matrix.length == 0 || matrix == null)
            return cells;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        //The cells which can flow to pacific will be marked with 1
        int[][] pacific = new int[row][col];
        
        //The cells which can flow to atlantic will be marked with 1
        int[][] atlantic = new int[row][col];
        
        //We start from corner cells and perform DFS. The cells that we reach during DFS are the cells that can flow to a particular ocean. Hence mark that cell as 1
        
        //1. Start from top and bottom rows
        for(int i = 0; i < col; i++){
            
            //Start from pacific ocean at top and see what all cells can we reach. If we reach a particular cell mark it 1 in pacific matrix
            dfs(matrix, 0, i, Integer.MIN_VALUE, pacific);
            
            //Start from atlantic ocean at bottom and see what all cells can we reach. If we reach a particular cell mark it 1 in atlantic matrix
            dfs(matrix, row - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        //2. Start from Leftmost and Rightmost corner edges
        for(int i = 0; i < row; i++){
            
            //Start from pacific ocean at left and see what all cells can we reach. If we reach a particular cell mark it 1 in pacific matrix
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
            
            //Start from atlantic ocean at right and see what all cells can we reach. If we reach a particular cell mark it 1 in atlantic matrix
            dfs(matrix, i, col - 1, Integer.MIN_VALUE, atlantic);
        }
        
        //Then we check which cells in both matrix have 1 cuz that cells are reachable to both oceans
        for(int m = 0; m < row; m++){
            
            for(int n = 0; n < col; n++){
                
                //Foll cell reaches both oceans or can be reached from both ocean hence add that to list
                if(pacific[m][n] == 1 && atlantic[m][n] == 1){
                    
                    List<Integer> res = new LinkedList<>();
                    res.add(m);
                    res.add(n);
                    cells.add(res);
                }
            }
        }
        
        return cells;
    }
    
    public void dfs(int[][] matrix, int row, int col, int prevVal, int[][] ocean){
        
        //Step 1: Check necessary conditions ie Row and column bounds
        if(row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1)
            return;
        
        //Check whether a particular cell has been reached before from that ocean, if yes then do not perform DFS on it
        if(ocean[row][col] == 1)
            return;
        
        //Step 2: Process the cells
        
        //The cells can flow from higher to lower or equal value cell only. Since we are coming from reverse the value of cell must be greater or equal to prev value or else cell cant flow
        if(matrix[row][col] < prevVal)
            return;
            
        //Since we can reach this cell from particular ocean mark as 1 and then perform dfs and check for all its neighboring cells
        ocean[row][col] = 1;
        
        //Top
        dfs(matrix, row - 1, col, matrix[row][col], ocean);
        
        //Right
        dfs(matrix, row, col + 1, matrix[row][col], ocean);
        
        //Bottom
        dfs(matrix, row + 1, col, matrix[row][col], ocean);
        
        //Left
        dfs(matrix, row, col - 1, matrix[row][col], ocean);     
    }
}
