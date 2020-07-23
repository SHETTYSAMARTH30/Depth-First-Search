class WordSearch {
    
    int[][] dim = {{0,1},{1,0},{0,-1},{-1,0}};
    int rows;
    int cols;
    char[][] board;
    
    public boolean exist(char[][] board, String word) {
        
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        
        //We check each element of the 2D array
        for(int i=0; i<rows; i++){
            
            for(int j=0; j<cols; j++){
                
                boolean result = backtrack(i,j,word,0);
                
                //We have found the word
                if(result)
                    return true;
            }
        }
        
        return false;
        
    }
    
    //We perform DFS on the given cell, since we change the value of a cell if we found a match we call it backtracking(We dont want to use the same cell again hence we change)
    
    public boolean backtrack(int row, int col, String word, int index){
        
        //We have checked all the indexes of the word hence we stop
        if(index >= word.length())
            return true;
        
        //Check all the boundaries and if the letter is not found in that cell then return
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index))
            return false;
        
        boolean ret = false;
        
        //Since we cannot use the same cell again, we change its value
        board[row][col] = '#';
        
        //We perform DFS to find the next letter in the word
        //We go right->bottom->left->top
        
        for(int d[]: dim){
            
            //We check the next letter in the word
            ret = backtrack(row+d[0], col+d[1], word, index+1);
            
            if(ret)
                break;
        }
        
        //Since we changed the value, replace # with original letter
        
        board[row][col] = word.charAt(index);
        
        return ret; 
        
    }
}
