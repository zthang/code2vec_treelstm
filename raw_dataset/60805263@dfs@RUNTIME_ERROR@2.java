	private static void dfs(int u, int prev, long curCost) {
		List<Integer> next = edges[u];
		if (next == null || next.isEmpty()) {
			maxLine = Math.max(maxLine, curCost);
			return;
		}
		visit[u] = true;
		curCost += weight[u];

		for (int v : next) {
			if (v == prev) continue;
			if (visit[v]) {
				circle[u] = true;
				circleExist = true;
			} else {
				dfs(v, u, curCost);
				if (circle[v]) circle[u] = true;
			}
		}

		curCost -= weight[u];
		visit[u] = false;
	}