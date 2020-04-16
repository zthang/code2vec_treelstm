	static int go (int indx, int odd) {
		
		if (indx < 0 || indx >= n) return oo;
		if (arr[indx] % 2 == 0 && odd == 1) return 0;
		if (arr[indx] % 2 != 0 && odd == 0) return 0;
		if (dp[indx][odd] != -1) return dp[indx][odd];
				
		int plus = 1 + go (indx + arr[indx], odd);
		int minus = 1 + go (indx - arr[indx], odd);
		
		return dp[indx][odd] = Math.min(plus, minus);
	}