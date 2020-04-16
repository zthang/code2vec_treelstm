private void fillMax(int[] max) {
    for (int i = 1; i <= n; i++) {
        if (!nodes[i].v) {
            Set<Integer> nds = dfs(i);
            int maxhere = 0;
            for (int num : nds) {
                maxhere = Math.max(num, maxhere);
            }
            for (int num : nds) {
                max[num] = maxhere;
            }
        }
    }
}