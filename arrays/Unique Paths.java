class Solution {
    public int uniquePaths(int m, int n) {
        //int a = (((m+n-2)*m)/(n-1));
        int res = 1;
        for(int i = 1; i <= m-1; i++){
            res = res * (n-1+i)/i;
        }
        return (int)res;
    }
}
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(m-1, n-1, memo);
    }

    private int dfs(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) return 1; // base case
        if (memo[i][j] != -1) return memo[i][j];
        memo[i][j] = dfs(i-1, j, memo) + dfs(i, j-1, memo);
        return memo[i][j];
    }
}
*/
