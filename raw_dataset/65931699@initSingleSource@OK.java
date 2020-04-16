private void initSingleSource(AdjVertex<T> s) {
    for (Vertex<T> u : vertices) {
        u.setD(INF);
        u.setPred(null);
    }
    s.setD(0);
}