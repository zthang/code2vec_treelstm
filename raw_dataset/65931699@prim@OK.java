public void prim(Vertex<T> s) {
    AdjVertex<T> r = (AdjVertex<T>) s;
    for (Vertex<T> u : vertices) {
        u.setD(INF);
        u.setColor(Vertex.WHITE);
    }
    r.setD(0);
    r.setPred(null);
    PriorityQueue<AdjVertex<T>> queue = new PriorityQueue<>();
    for (Vertex<T> u : vertices) {
        queue.add((AdjVertex<T>) u);
    }
    while (!queue.isEmpty()) {
        AdjVertex<T> u = queue.poll();
        for (Edge<T> e : u.getAdjList()) {
            AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
            if (v.getColor() == Vertex.WHITE && e.getWeight() < v.getD()) {
                queue.remove(v);
                v.setD(e.getWeight());
                queue.add(v);
                v.setPred(u);
            }
        }
        u.setColor(Vertex.BLACK);
    }
}