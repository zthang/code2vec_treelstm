    public static int solve(int pos, int even, int count){
        if(pos < 1 || pos > n){
            return Integer.MAX_VALUE;
        }
        if(dp[pos][even] != -1){
            return count + dp[pos][even];
           
        }
        if((even == 1 && arr[pos - 1] % 2 == 1) || (even == 0 && arr[pos - 1] % 2 == 0)){
            return count;
        }
        int res = 0;
        res += Math.min(solve(pos - arr[pos - 1], even, count + 1), solve(pos + arr[pos - 1], even, count + 1));
        dp[pos][even] = res - count;
        return res;
    }