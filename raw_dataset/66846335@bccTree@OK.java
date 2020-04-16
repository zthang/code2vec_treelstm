// # Make sure to call run before calling this function.
// Function returns a new graph such that all biconnected
// components are compressed into one node. Cut nodes will
// be in multiple components, so these nodes will also have
// their own component by themselves. Edges in the graph
// represent components to articulation points
// map is an integer array that will store the mapping
// for each node in the old graph into the new graph.
// Cut points to their special component, and every other node
// to their specific component. //$
MagicComponents bccTree(int[] map) {
    int[] cut = new int[n];
    Arrays.fill(cut, -1);
    int size = bccs.size();
    for (int i : cuts) map[i] = cut[i] = size++;
    MagicComponents g = new MagicComponents(size);
    int[] used = new int[n];
    for (int i = 0; i < bccs.size(); ++i) {
        ArrayList<Edge> list = bccs.get(i);
        for (Edge e : list) {
            for (int node : new int[] { e.u, e.v }) {
                if (used[node] != i + 1) {
                    used[node] = i + 1;
                    if (cut[node] != -1)
                        g.addEdge(i, cut[node]);
                    else
                        map[node] = i;
                }
            }
        }
    }
    return g;
}