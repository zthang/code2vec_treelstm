	static void dfs(Node[][] a, Node end, char[][] ans, int x, int y, int prex, int prey, int n) {
		if (x - 1 >= 0 && a[x - 1][y].equals(end) && ans[x - 1][y] == 0) {
			ans[x - 1][y] = 'D';
			dfs(a, end, ans, x - 1, y, x, y, n);
		}
		if (x + 1 < n && a[x + 1][y].equals(end) && ans[x + 1][y] == 0) {
			ans[x + 1][y] = 'U';
			dfs(a, end, ans, x + 1, y, x, y, n);
		}
		if (y - 1 >= 0 && a[x][y - 1].equals(end) && ans[x][y - 1] == 0) {
			ans[x][y - 1] = 'R';
			dfs(a, end, ans, x, y - 1, x, y, n);
		}
		if (y + 1 < n && a[x][y + 1].equals(end) && ans[x][y + 1] == 0) {
			ans[x][y + 1] = 'L';
			dfs(a, end, ans, x, y + 1, x, y, n);
		}
	}