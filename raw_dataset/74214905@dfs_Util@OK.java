public static int dfs_Util() {
    int n = permutation.length;
    points = new ArrayList<Integer>();
    visited = new boolean[n];
    int min = n;
    for (int i = 1; i < n; i++) {
        if (!visited[i]) {
            points.clear();
            dfs(i);
            int z = points.size();
            for (int j = 1; j * j <= z; j++) {
                if (z % j == 0) {
                    if (check(points, j)) {
                        min = Integer.min(min, j);
                    }
                    if (check(points, z / j)) {
                        min = Integer.min(min, z / j);
                    }
                }
            }
        }
    }
    return min;
}