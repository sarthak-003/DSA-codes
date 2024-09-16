class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }
        helper(mat, q, visited, ans);
        return ans;
    }

    private static void helper(int[][] mat, Queue<int[]> q, boolean[][] visited,int[][] ans) {
        while (!q.isEmpty()) {
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            ans[row][col] = front[2];
            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, 1, 0, -1 };
            for (int t = 0; t < 4; t++) {
                int nrow = row + delrow[t];
                int ncol = col + delcol[t];
                if (nrow >= 0 && ncol >= 0 && nrow < mat.length && ncol < mat[0].length
                        && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.add(new int[] { nrow, ncol, front[2] + 1});
                }
            }
        }
    }
}