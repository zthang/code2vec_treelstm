private static void doChaining(int pos, int count, ArrayList<Integer>[] adj, int[] weights, ArrayList<String> chainList) {
    if (pos == weights.length || count == weights.length) {
        return;
    }
    if (adj[pos].size() < 2) {
        int to = getTarget(pos, adj);
        adj[pos].add(to);
        adj[to].add(pos);
        chainList.add(pos + 1 + " " + (to + 1));
        cost += weights[pos] + weights[to];
        count++;
        doChaining(pos, count, adj, weights, chainList);
    } else {
        doChaining(pos + 1, count, adj, weights, chainList);
    }
}