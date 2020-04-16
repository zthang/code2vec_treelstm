// # Make sure to call run before calling this function.
// Function returns a new graph such that all two connected
// components are compressed into one node and all bridges
// in the previous graph are the only edges connecting the
// components in the new tree.
// map is an integer array that will store the mapping
// for each node in the old graph into the new graph. //$
MagicComponents componentTree(int[] map) {
    boolean[] vis = new boolean[edges];
    for (Edge e : bridges) vis[e.id] = true;
    int numComp = 0;
    Arrays.fill(map, -1);
    for (int i = 0; i < n; ++i) {
        if (map[i] == -1) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            map[i] = numComp;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (Edge e : adj[node]) {
                    if (!vis[e.id] && map[e.v] == -1) {
                        vis[e.id] = true;
                        map[e.v] = numComp;
                        q.add(e.v);
                    }
                }
            }
            ++numComp;
        }
    }
    MagicComponents g = new MagicComponents(numComp);
    Arrays.fill(vis, false);
    for (int i = 0; i < n; ++i) {
        for (Edge e : adj[i]) {
            if (!vis[e.id] && map[e.v] < map[e.u]) {
                vis[e.id] = true;
                g.addEdge(map[e.v], map[e.u]);
            }
        }
    }
    return g;
}