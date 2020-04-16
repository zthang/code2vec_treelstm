private static void dfs(D order, int[] res) {
    if (order != null) {
        dfs(order.left, res);
        res[order.v.index] = e;
        e++;
        dfs(order.right, res);
    }
}