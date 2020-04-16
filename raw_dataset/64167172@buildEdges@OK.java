private static void buildEdges() {
    edges = new ArrayList<>();
    for (int ii = 0; ii <= n; ii++) {
        for (int jj = ii + 1; jj <= n; jj++) {
            if (ii == 0) {
                edges.add(new Edge(ii, jj, (long) nodes.get(jj).c));
            } else {
                int dist = Math.abs(nodes.get(ii).x - nodes.get(jj).x) + Math.abs(nodes.get(ii).y - nodes.get(jj).y);
                edges.add(new Edge(ii, jj, (long) (dist) * (long) (nodes.get(ii).k + nodes.get(jj).k)));
            }
        }
    }
    Collections.sort(edges);
}