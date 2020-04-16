public static void dfs(Node[] nodes, int[][] nn, int i, Map<Integer, Boolean> route, int currentColor) {
    if (nodes[i] != null) {
        if (nodes[i].getNexts() == null || nodes[i].getNexts().size() == 0) {
            return;
        }
        if (nodes[i].isSucceed()) {
            return;
        }
        // 放到路上
        route.put(i, true);
        List<Integer> nexts = nodes[i].getNexts();
        for (int next : nexts) {
            // 表示在路上
            if (route.containsKey(next)) {
                nn[i][next] = currentColor + 1;
                if (max < currentColor + 1) {
                    max = currentColor + 1;
                }
            } else {
                nn[i][next] = currentColor;
                dfs(nodes, nn, next, route, currentColor);
            }
        }
        nodes[i].setSucceed(true);
        route.remove(i);
    }
}