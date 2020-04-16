	public int dp(int ind, int origeven) {

		if(ind < 0 || ind >= n) {
			return -2;
		}

		if(memo[ind][origeven] != -2) {
			return memo[ind][origeven];
		}

		if(a[ind] % 2 != origeven) {
			memo[ind][origeven] = 0;
			return memo[ind][origeven];
		}
		
		int way1 = 1 + dp(ind - a[ind], origeven);
		int way2 = 1 + dp(ind + a[ind], origeven);

		if(way1 <= 0 && way2 <= 0) {
			memo[ind][origeven] = -1;
			return memo[ind][origeven];
		}

		if(way1 <= 0) {
			memo[ind][origeven] = way2;
			return memo[ind][origeven];
		}

		if(way2 <= 0) {
			memo[ind][origeven] = way1;
			return memo[ind][origeven];
		}

		memo[ind][origeven] = Math.min(way1, way2);
		return memo[ind][origeven];
	}