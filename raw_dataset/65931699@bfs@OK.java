public void bfs(Vertex<T> x) {
    AdjVertex<T> s = (AdjVertex<T>) x;
    for (Vertex<T> u : vertices) {
        u.setColor(Vertex.WHITE);
        u.setD(Integer.MAX_VALUE);
        u.setPred(null);
    }
    s.setColor(Vertex.GRAY);
    s.setD(0);
    s.setPred(null);
    Queue<AdjVertex<T>> q = new LinkedList<>();
    q.offer(s);
    while (!q.isEmpty()) {
        AdjVertex<T> u = q.poll();
        for (int i = 0; i < u.getAdjList().size(); i++) {
            AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
            if (v.getColor() == Vertex.WHITE) {
                v.setColor(Vertex.GRAY);
                v.setD(u.getD() + 1);
                v.setPred(u);
                q.offer(v);
            }
        }
        u.setColor(Vertex.BLACK);
    }
}