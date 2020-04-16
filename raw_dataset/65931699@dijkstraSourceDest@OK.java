public void dijkstraSourceDest(Vertex<T> x, Vertex<T> y) {
    AdjVertex<T> s = (AdjVertex<T>) x;
    initSingleSource(s);
    PriorityQueue<AdjVertex<T>> queue = new PriorityQueue<>();
    queue.add(s);
    AdjVertex<T> u = null;
    while (!queue.isEmpty()) {
        u = queue.poll();
        for (Edge<T> e : u.getAdjList()) {
            AdjVertex<T> v = (AdjVertex<T>) e.getDestination();
            double weight = e.getWeight();
            double distanceFromU = u.getD() + weight;
            if (distanceFromU < v.getD()) {
                queue.remove(v);
                v.setD(distanceFromU);
                v.setPred(u);
                queue.add(v);
            }
        }
        if (u.compareTo(y) == 0)
            break;
    }
}