	void solve() {
		int n = scn.nextInt(), m = scn.nextInt(), k = scn.nextInt();
		int[] arr = scn.nextIntArray(k);
		boolean[] spcl = new boolean[n];
		for (int i = 0; i < k; i++) {
			arr[i]--;
			spcl[arr[i]] = true;
		}
		int[] from = new int[m], to = new int[m];

		boolean spc = false;
		for (int i = 0; i < m; i++) {
			from[i] = scn.nextInt() - 1;
			to[i] = scn.nextInt() - 1;
			if (spcl[from[i]] && spcl[to[i]]) {
				spc = true;
			}
		}
		int[][] g = packU(n, from, to);

		int[] dist1 = dist(g, 0);
		if (spc) {
			out.println(dist1[n - 1]);
			return;
		}
		int[] dist2 = dist(g, n - 1);

		int[][] dist = new int[n][2];
		for (int i = 0; i < n; i++) {
			dist[i][0] = dist[i][1] = -1;
		}

		int[][] q = new int[n][2];
		int p = 0;
		for (int i = 0; i < k; i++) {
			q[p][0] = arr[i];
			q[p++][1] = arr[i];
			dist[arr[i]][0] = 0;
			dist[arr[i]][1] = arr[i];
		}

		int ans = dist2[0];
		int rv = 0;

		Random r = new Random();

		for (int y = 0; y < 100 && k>20000; y++) {
			for (int x = 0; x < k; x++) {
				int i = r.nextInt(k), j = r.nextInt(k);
				while (i == j) {
					j = r.nextInt(k);
				}
				int d1 = dist1[arr[i]] + dist2[arr[j]];
				int d2 = dist1[arr[j]] + dist2[arr[i]];
				rv = Math.max(rv, 1 + Math.min(d1, d2));
			}
		}
for(int i=0;i<k&&k<=20000;i++)for(int j=i+2;j<n;j++){
int d1 = dist1[arr[i]] + dist2[arr[j]];
				int d2 = dist1[arr[j]] + dist2[arr[i]];
				rv = Math.max(rv, 1 + Math.min(d1, d2));
}

		out.println(Math.min(ans, rv));
	}