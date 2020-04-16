	void dfs(int u) {
		dfsStack[u] = 1;
		stack.addLast(u);
		int v = goTo[u];
		if(dfsStack[v] == 1) {
			int mask = 0, uhoh = 0, ptr = 0;
			while(!stack.isEmpty()) {
				int cur = stack.pollLast();
				list[ptr++] = cur;
				int id = where.get(unMap[cur]);
				if((mask&(1<<id)) != 0) uhoh = 1;
				mask |= 1<<id;
				if(cur == v) break;
			}
			for(int i = 0; i < ptr; i++) {
				if(uhoh > 0) cycleMask[list[i]] = -1;
				else cycleMask[list[i]] = mask;
			}
		}
		else if(dfsStack[v] == 2) {
			while(!stack.isEmpty()) {
				int i = stack.pollFirst();
				cycleMask[i] = -1;
			}
			return;
		}
		else {
			par[v] = u;
			dfs(v);
		}
		dfsStack[u] = 2;
	}