	public static long dfs(int a[], int ind, long dp[][], boolean odd, int parent){
		
		if(ind<0||ind>=a.length)
			return Integer.MAX_VALUE;
		
		if(odd){
			if(parent !=-1){
				if((a[ind])%2!=0)
				{
					return 0;
				}
			}
			if(dp[ind][0]!=0)
				return dp[ind][0];
			dp[ind][0] = 1 + Math.min(dfs(a, ind + a[ind], dp, odd, ind), dfs(a, ind - a[ind], dp, odd, ind));
			return dp[ind][0];
		}
		else{
			if(parent !=-1){
				if((a[ind])%2==0)
				{
					return 0;
				}
			}
			if(dp[ind][1]!=0)
				return dp[ind][1];
			dp[ind][1] = 1 + Math.min(dfs(a, ind + a[ind], dp, odd, ind), dfs(a, ind - a[ind], dp, odd, ind));
			return dp[ind][1];
		}
	}