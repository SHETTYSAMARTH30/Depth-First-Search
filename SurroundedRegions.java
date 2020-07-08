class SurroundedRegions {
    
    int rows = 0;
    int cols = 0;
    
    public void solve(char[][] board) {
        
        if(board == null || board.length == 0)
            return;
        
        //We will store all the borders of the array into list and check whether they are '0' or 'X'
        List<Pair<Integer,Integer>> borders = new LinkedList<Pair<Integer,Integer>>();
        
        rows = board.length;
        cols = board[0].length;
        
        //Storing all the first and last column border dimensions
        for(int r=0; r < rows; r++){
            
            borders.add(new Pair(r,0));
            borders.add(new Pair(r,cols-1));
        }
        
        //Storing the first row and last row column border dimensions
        for(int c=0; c < cols; c++){
            
            borders.add(new Pair(0,c));
            borders.add(new Pair(rows-1,c));
        }
        
        //Traversing through list and performing DFS on each cell
        for(Pair<Integer,Integer> pair : borders){
            
            DFS(board,pair.first,pair.second);
        }
        
        //After converting all the 'O' near the boundary to 'E', we again iterate the 2D matrix. If the cell is E that means it was connected to the 'O' near boundary hence we convert it back to 'O'. Convert the 'O' to 'X'
        
        for(int i=0; i<rows; i++){
            
            for(int j=0; j<cols; j++){
                
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                
                if(board[i][j] == 'E')
                    board[i][j] = 'O';
                

            }
        }
        
        
    }
    
    //We perform DFS (right -> bottom -> left -> up)
    public void DFS(char[][] board, int row, int col){
        
        if(board[row][col] != 'O')
            return;
        
        board[row][col] = 'E';
        
        //Check the right column
        if(col < cols-1)
            DFS(board,row,col+1);
        
        //Check the row below
        if(row < rows-1)
            DFS(board,row+1,col);
        
        //Check the left column
        if(col > 0)
            DFS(board,row,col-1);
        
        //Check the upper row
        if(row > 0)
            DFS(board,row-1,col);
        
    }
}

class Pair<U,V>{
    
    public U first;
    public V second;
    
    public Pair(U first,V second){
        
        this.first = first;
        this.second = second;
    }
}
