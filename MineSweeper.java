class MineSweeper {
    
    //top,right,bottom,left and all diagonals
    int directions[][] = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int row = click[0];
        int col = click[1];
        
        //If we find a unreavled mine then change it to 'X' and return
        if(board[row][col] == 'M' || board[row][col] == 'X'){
            
            board[row][col] = 'X';
            return board;
        }
        
        //If it is E then we check its adjacent neighbors recursively and update accordingly to B if no adj M or to (1 to 8) depending on total num of M
        dfs(board, row, col);
        
        return board;
    }
    
    public void dfs(char[][] board, int r, int c){
        
        //If it is not E then return
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E'){
            
            return;
        }

        //it will count total num of adjacent mines 
        int num = countMine(board, r, c);
        
        //If no adjacent mines then we recursively iterate through each neighbors
        if(num == 0){
           
         //Since no adj mines then it will be B. And we do it at start because we dont want to explore the same cell in future. Cuz if we dnt change it will remain E and we keep exploring   
         board[r][c] = 'B';
            
        //If it is E then we check all 8 of its neighbors 
        for(int dir[] : directions){
            
            int adjRow = r + dir[0];
            int adjCol = c + dir[1];
            
            //We are going outside the board
            if(adjRow < 0 || adjRow >= board.length || adjCol < 0 || adjCol >= board[0].length)
                continue;
            
            //Explore the neighbors
            dfs(board, adjRow, adjCol);
        } 
        }
        else{
            
            board[r][c] = (char)('0' + num);
        }
         
    }
    
    //It will count num of mines adjacent to a block and return it
    public int countMine(char[][] board, int x, int y){
        
        int num = 0;
        
        for(int dir[] : directions){
            
            int nr = x + dir[0];
            int nc = y + dir[1];
            
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length)
                continue;
            
            //If we have adjacent mines then count it
            if(board[nr][nc] == 'M' || board[nr][nc] == 'X')
                num++;
        }
        
        return num;
        
    }
}
