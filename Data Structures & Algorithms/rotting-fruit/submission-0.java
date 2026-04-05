class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;



        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row,col});
                }
                else if(grid[row][col] == 1){
                    freshCount++;
                }
            }
        }
        // All oranges are already rotten
        if(freshCount == 0){
            return 0;
        }

        int[][] dircs = {{1,0}, {-1,0},{0,1},{0,-1}};

        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int[] curr = queue.poll();

                int i = curr[0];
                int j = curr[1];

                for(int[] dir : dircs){
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(new_i >=0 && new_i < rows && new_j>= 0 && new_j < cols && grid[new_i][new_j] == 1){
                        grid[new_i][new_j] = 2;
                        queue.offer(new int[]{new_i,new_j});
                        freshCount--;
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0? minutes -1 : -1;
    }
}