		int dfs(int cur, ArrayList<Integer>[] g, boolean vis[], int low[], int[] lvl, int hash[]) {
			lvl[cur] = low[cur] = times;
			hash[times] = cur;
			times++;
			int reach = low[cur];
			vis[cur] = true;
			for(int to:g[cur]) {
				if(vis[to]) {
					reach = Math.min(reach, low[to]);
				}else {
					int tmp = dfs(to,g,vis,low,lvl,hash);
					reach = Math.min(reach, tmp);
				}
			}
			if(reach<low[cur]) low[cur] = reach;
			return low[cur];
		}