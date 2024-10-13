class Solution {
    static void bfs(int[][] grid,boolean[][] visited,Queue<int[]> q,int[] ans){
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow>=0 && ncol>=0 && ncol<grid[0].length && nrow<grid.length && grid[nrow][ncol] == 1 && !visited[nrow][ncol]){
                    ans[1]+=1;
                    visited[nrow][ncol] = true;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] ans = {0,0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    ans[0]+=1;
                    if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                        ans[1]+=1;
                        visited[i][j] = true;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        bfs(grid,visited,q,ans);
        return ans[0]-ans[1];
    }
}