		private static long find(long[] ans, int i, int[] a, boolean[] active, int p) {
			if(i < 1 || i >= a.length || active[i]) return  dp[i] = Integer.MAX_VALUE/100;
			
			if(a[i]%2 == p) return 0;
			if(dp[i] != Integer.MAX_VALUE/10) return dp[i];
			active[i] = true;
			long k = Math.min(find(ans,i+a[i],a,active,p),find(ans,i-a[i],a,active,p))+1;
			active[i] = false;
			return dp[i] =  k;
		}