class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    int curr = dfs(grid, row,col);
                    area = Math.max(area, curr);
                }
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || 
        col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(grid,row+1,col) + dfs(grid, row-1, col) +
            dfs(grid, row, col+1) + dfs(grid, row, col-1);
    }
}