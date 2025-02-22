class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int[][] dp = new int[arr.length][arr.length];
        for(int i =0;i < dp.length;i++) {
            for(int j = 0;j < dp.length;j++) {
                dp[i][j] = -1;
            }
        }
        return recur(arr,0,arr.length - 1,dp);
    }
    public static int recur(int[] arr, int start, int end,int[][] dp) {
        if(start +1 == end) {
            return 0;
        }
        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for(int i = start + 1;i < end;i++) {
            int value = arr[start]*arr[i]*arr[end] + recur(arr,start,i,dp) + recur(arr,i,end,dp);
            min = Math.min(value,min);
        }
        dp[start][end] = min;
        return min;
    }
}
