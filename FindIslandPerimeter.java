public class FindIslandPerimeter{
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0; 
        for(int i = 0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j]==1) {
                    //The idea here is that each cell has 4 sides, so each additional grid cell can increase maximum of 4 units of perimeter
                    perimeter = perimeter + 4;
                    //but here we need to consider the joined "sides"
                    perimeter = perimeter - checkNeighbor(grid, i, j);
                }
            }
        }
        return perimeter; 
    }
    
    private static int checkNeighbor(int[][] grid, int row, int col) {
        int connectBorder = 0; 
        //here we check the grid cell's 4 neighbors, every joined side will decrease perimeter by 1, and we're calculating how many joined side each grid cell has
        if (row-1 >= 0) {
            if (grid[row-1][col] == 1) connectBorder++; 
        }
        if (row+1 < grid.length) {
            if (grid[row+1][col] == 1) connectBorder++;
        }
        if ((col-1 >= 0) && (grid[row][col-1] == 1)) connectBorder++; 
        if ((col+1 < grid[0].length) && (grid[row][col+1] == 1)) connectBorder++; 
        return connectBorder; 
    }
    public static void main(String []args){
        int[][] myGrid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        FindIslandPerimeter fip = new FindIslandPerimeter(); 
        int totalPerimeter = fip.islandPerimeter(myGrid); 
        System.out.println("Island perimeter is "+totalPerimeter);
    }
}
