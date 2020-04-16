private static long cal(ArrayList<ArrayList<Integer>> list, int[] vis, int node, int prev, int prev2, int[][] col) {
    int curr = 6 - prev - prev2;
    long cost = 0;
    int first = list.get(node).get(0);
    if (vis[first] == 0) {
        cost += col[curr - 1][first];
        vis[first] = curr;
        cost += cal(list, vis, first, curr, prev, col);
    }
    if (list.get(node).size() == 2) {
        int second = list.get(node).get(1);
        if (vis[second] == 0) {
            cost += col[curr - 1][second];
            vis[second] = curr;
            cost += cal(list, vis, second, curr, prev, col);
        }
    }
    return cost;
}