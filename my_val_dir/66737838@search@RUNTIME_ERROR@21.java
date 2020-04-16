		public long search(int[] arr, long[] dp, int pos, int abspos, long[] ans) {
			if(isopposite(arr[pos],arr[abspos])) return 0;
			if(dp[pos]==-1) return INFINITY;
			if(dp[pos]!=0) return dp[pos];
			int rightpos = pos + arr[pos];
			int leftpos = pos - arr[pos];
			if(leftpos<0 && rightpos>=arr.length) {
				dp[pos] = -1;
				return INFINITY;
			}
			if(leftpos<0 || leftpos==abspos) {
				if(rightpos==abspos) return INFINITY;
				dp[pos] = 1 + search(arr,dp,rightpos,abspos,ans);
				return dp[pos];
			}
			if(rightpos>=arr.length || rightpos==abspos) {
				if(leftpos==abspos) return INFINITY;
				dp[pos] = 1 + search(arr,dp,leftpos,abspos,ans);
				return dp[pos];
			}
			long left = 1 + search(arr,dp,leftpos,abspos,ans);
			long right = 1 + search(arr,dp,rightpos,abspos,ans);
			long cnt = Math.min(left, right);
			if(cnt==INFINITY) cnt=-1;
			dp[abspos] = cnt;
			return dp[abspos];
		}