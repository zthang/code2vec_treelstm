	public Object solve () {
		int N = sc.nextInt();
		D = sc.nextLongs(N);
		long [][] C = new long [N][2];
		for (int i : rep(N))
			C[i] = new long [] { i, sc.nextLong() };
		K = sc.nextLongs();

		sort(C, lby(1));

		boolean [] Q = new boolean [N], V = new boolean [N];
		for (int j : rep(N)) {
			int m = (int)C[j][0]; long c = C[j][1];
			for (int n : rep(N))
				if (Q[n] && dist(m, n) < c)
					Q[m] = true;
			if (!Q[m])
				Q[m] = V[m] = true;
		}

		long [][] E = new long [N][3]; int c = 0;
		for (int j : rep(N))
			for (int i : rep(j))
				E[c++] = new long [] { i, j, dist(i, j) };

		sort(E, lby(2));

		Q = V.clone();
		List<long[]> LE = new ArrayList<>();
		DSU dsu = new DSU(N);

		for (long [] e : E) {
			int i = (int)e[0], j = (int)e[1];
			if (!Q[i] || !Q[j])
				if (dsu.add(i, j))
					LE.add(e);
			if (Q[i] || Q[j])
				Q[i] = Q[j] = true;
		}

		long res = 0;

		List<Integer> LV = new ArrayList<>();
		for (int j : rep(N)) {
			int i = (int)C[j][0];
			if (V[i]) {
				res += C[j][1];
				LV.add(i+1);
			}
		}

		for (long [] e : LE)
			res += e[2];

		print(res);
		print(LV.size());
		print(LV);
		print(LE.size());
		for (long [] e : LE)
			print(e[0] + 1, e[1] + 1);
		return null;
	}