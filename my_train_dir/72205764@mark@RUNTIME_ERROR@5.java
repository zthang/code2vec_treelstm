	static int mark(int node, int t) {
		if (node == t)
			return mark[node] = 0;
		int max = (int) 1e9;
		for (int v : g[node]) {
			if (!vis[v]) {
				int temp = 1 + mark(v, t);
				max = Math.min(max, temp);
			}
		}
		return mark[node] = max;
	}