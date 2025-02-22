
class Solution {
    static int countWays(String s) {
        // code here
        int[][][] dp = new int[s.length()][s.length()][2];
        for(int i =0;i < s.length();i++) {
            for(int j =0;j < s.length();j++) {
                dp[i][j][0] = -1;
                 dp[i][j][1] = -1;
            }
        }
        return recur(s,0,s.length() - 1,true,dp);
    }
    public static int recur(String s,int start,int end,boolean isTrue,int[][][] dp) {
        
        if(start == end) {
            if(isTrue) {
                if(s.charAt(start) == 'T') {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else {
                 if(s.charAt(start) == 'F') {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        int value1 = isTrue?1:0;
        if(dp[start][end][value1] != -1) {
            return dp[start][end][value1];
        }
       
        int count  =0;
        for(int i = start + 1;i < end; i=  i + 2) {
            int leftTrue = recur(s,start,i - 1,true,dp);
            int leftFalse = recur(s,start,i - 1,false,dp);
            int rightTrue = recur(s,i + 1, end,true,dp);
            int rightFalse = recur(s,i + 1, end,false,dp);
            if(s.charAt(i) == '|') {
                if(isTrue) {
                    count = count + leftTrue*rightTrue + leftTrue*rightFalse + leftFalse*rightTrue;
                }
                else {
                    count = count + leftFalse*rightFalse;
                }
            }
            else if(s.charAt(i) == '&') {
                 if(isTrue) {
                    count = count + leftTrue*rightTrue;
                }
                else {
                    count = count + leftFalse*rightFalse + leftTrue*rightFalse + leftFalse*rightTrue;
                }
            }
            else {
                 if(isTrue) {
                    count = count  + leftTrue*rightFalse + leftFalse*rightTrue;
                }
                else {
                    count = count + leftFalse*rightFalse+ leftTrue*rightTrue;
                }
            }
        }
        dp[start][end][value1] = count;
        return count;
    }
    
}
