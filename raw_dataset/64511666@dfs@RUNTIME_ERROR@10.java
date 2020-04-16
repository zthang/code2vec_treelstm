	static boolean dfs(int u) {
		visited[u] = 1;
		stack.push(u);

		for (int v : adj[u]) {
			if (visited[v] == 2)
				return false;
			if (visited[v] == 1) {
				while (true) {
					int x = stack.pop();
					visitedMsk |= 1 << toBox.get(val.get(x));
					path.add(x);
					if (x == v)
						break;
				}
				visited[u] = 2;

				return true;
			}
			boolean ret = dfs(v);
			visited[u] = 2;
			return ret;
		}
		visited[u] = 2;

		return false;
	}