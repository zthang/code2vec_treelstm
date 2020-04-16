	static void dfs2(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i], nc = c + dy[i];
			if(valid(nr,nc) && grid[nr][nc] == -1) {
				if(adj[nr][nc].r == adj[r][c].r && adj[nr][nc].c == adj[r][c].c) {
					grid[nr][nc] = (i + 2) % 4;
					dfs2(nr,nc);
				}
			}
		}
	}