	static int go (int indx, boolean odd) {
		
		if (indx < 0 || indx >= n) return oo;
		if (arr[indx] % 2 == 0 && odd) return 0;
		if (arr[indx] % 2 != 0 && !odd) return 0;
				
		int plus = 1 + go (indx + arr[indx], odd);
		int minus = 1 + go (indx - arr[indx], odd);
		
		return Math.min(plus, minus);
	}