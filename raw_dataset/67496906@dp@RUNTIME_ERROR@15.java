	int dp(int i, int p) {
		if (dp[p][i] != trash)
			return dp[p][i];
		int ans = trash;
		if (r[i] != trash) {
			if (pd[r[i]] == p)
				ans = 1;
			else
				ans = min(ans, 1 + dp(r[i], p));
		}
		if (l[i] != trash) {
			if (pd[l[i]] == p)
				ans = 1;
			else
				ans = min(ans, 1 + dp(l[i], p));
		}

		done[i] = true;
		return dp[p][i] = ans;
	}