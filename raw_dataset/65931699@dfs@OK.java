public void dfs() {
    for (Vertex<T> u : vertices) {
        u.setColor(Vertex.WHITE);
        u.setPred(null);
    }
    int time = 0;
    for (Vertex<T> u : vertices) {
        if (u.getColor() == Vertex.WHITE)
            time = dfsVisit((AdjVertex<T>) u, time);
    }
}