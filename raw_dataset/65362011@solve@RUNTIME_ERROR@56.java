	void solve() {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt(), m = scn.nextInt();
			int[] arr = scn.nextIntArray(n);
			if (n == 2 || m < n) {
				out.println(-1);
				continue;
			}

			int[][] E = new int[n * (n - 1) / 2][];
			for (int i = 0, k = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					E[k++] = new int[] { i, j, arr[i] + arr[j], 0 };
				}
			}
			Arrays.parallelSort(E, (o1, o2) -> o1[2] - o2[2]);

			int z = 0;
			int[][] ans = new int[m][];
			
			long cost = 0;

			int[] size = new int[n];
			boolean[][] done = new boolean[n][n];
			for (int[] e : E) {
				int i = e[0], j = e[1], k = e[2];
				if (size[i] < 2 && size[j] < 2) {
					size[i]++;
					size[j]++;
					cost += k;
					e[3] = 1;
					ans[z++] = new int[] {i + 1, j + 1};
					done[i][j] = done[j][i] = true;
				}
			}
			
			int[][] need = new int[n - 1][2];
			for (int i = 0; i < n; i++) {
				if (size[i] >= 2) {
					continue;
				}
				for (int j = 0, k = 0; j < n; j++) {
					if (i != j) {
						need[k][0] = j;
						need[k][1] = arr[i] + arr[j];
						k++;
					}
				}
				Arrays.parallelSort(need, (o1, o2) -> o1[1] - o2[1]);
				for (int j = 0; j < n - 1; j++) {
					if (!done[i][need[j][0]] && size[i] < 2) {
						cost += need[j][1];
						size[i]++;
						done[i][need[j][0]] = done[need[j][0]][i] = true;
						ans[z++] = new int[] { i + 1, need[j][0] + 1 };
					}
				}
			}
			
			for(int[] e : E) {
				if(z < m) {
					cost += e[2];
					done[e[0]][e[1]] = done[e[1]][e[0]] = true;
					ans[z++] = new int[] { e[0] + 1, e[1] + 1 };
				}
			}
			
			out.println(cost);
			for(int[] e : ans) {
				out.println(e[0] + " " + e[1]);
			}
		}
	}