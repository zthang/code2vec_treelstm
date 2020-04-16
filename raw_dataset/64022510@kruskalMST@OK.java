public ArrayList<Edge> kruskalMST() {
    PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingLong(o -> o.weight));
    // add all the edges to priority queue, //sort the edges on weights
    for (int i = 0; i < allEdges.size(); i++) {
        pq.add(allEdges.get(i));
    }
    // create a parent []
    int[] parent = new int[vertices];
    // makeset
    makeSet(parent);
    ArrayList<Edge> mst = new ArrayList<>();
    // process vertices - 1 edges
    int index = 0;
    while (index < vertices - 1) {
        Edge edge = pq.remove();
        // check if adding this edge creates a cycle
        int x_set = find(parent, edge.source);
        int y_set = find(parent, edge.destination);
        if (x_set == y_set) {
        // ignore, will create cycle
        } else {
            // add it to our final result
            mst.add(edge);
            index++;
            union(parent, x_set, y_set);
        }
    }
    return mst;
}