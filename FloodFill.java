class FloodFill {

    //You can find my basic code in comments that might work for most DFS problems
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int color = image[sr][sc];
        
        if(color != newColor){
            
            dfs(image, sr, sc, color, newColor);
        }
        
        return image;
        
    }
    
    public void dfs(int[][] image, int r, int c, int orgColor, int newColor){
        
        //If it is same as original color then change it to new color and check whether its neighbors has the same color too. If the neighbor has same color then change it too and then its neighbors too. So DFS
        if(image[r][c] == orgColor){
            
            image[r][c] = newColor;
            
            //If neighbors have the same color then we chnage it too
            if(r >= 1)
                dfs(image, r - 1, c, orgColor, newColor);
            
            if(r+1 < image.length)
                dfs(image, r + 1, c, orgColor, newColor);
            
            if(c >= 1)
                dfs(image, r, c - 1, orgColor, newColor);
            
            if(c+1 < image[0].length)
                dfs(image, r, c + 1, orgColor, newColor);
                
        }
    }
}
