	int dp(int i, int p) {
		if (pd[i] == p)
			return dp[p][i] = 0;
		if (dp[p][i] != trash)
			return dp[p][i];
		int ans = trash;
		if (l[i] != trash)
			ans = min(ans, 1 + dp(l[i], p));
		if (r[i] != trash)
			ans = min(ans, 1 + dp(r[i], p));
		done[p][i] = true;
		return dp[p][i] = ans;
	}