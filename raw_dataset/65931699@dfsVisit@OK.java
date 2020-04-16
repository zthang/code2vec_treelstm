private int dfsVisit(AdjVertex<T> u, int time) {
    time++;
    u.setD(time);
    u.setColor(Vertex.GRAY);
    for (int i = 0; i < u.getAdjList().size(); i++) {
        AdjVertex<T> v = (AdjVertex<T>) u.getAdjList().get(i).getDestination();
        if (v.getColor() == Vertex.WHITE) {
            v.setPred(u);
            time = dfsVisit(v, time);
        }
    }
    u.setColor(Vertex.BLACK);
    time++;
    u.setF(time);
    return time;
}