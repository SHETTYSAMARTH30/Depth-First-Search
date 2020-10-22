/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class LeftMostColumnOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        //Start at top right of matrix, if its 0 then move down cuz there wont be any 1's on left
        //If you find 1 keep moving left to find least column index
        
        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = col - 1;
        
        while(currentRow < row && currentCol >= 0){
            
            if(binaryMatrix.get(currentRow, currentCol) == 0){
                currentRow++;
            }
            else{
                
                currentCol--;
            }
        }
        
        // If we never left the last column, this is because it was all 0's.
        return (currentCol == col - 1) ? -1: currentCol + 1;
    }
}
