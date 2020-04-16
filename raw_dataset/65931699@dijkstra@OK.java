public void dijkstra(Vertex<T> x) {
    AdjVertex<T> s = (AdjVertex<T>) x;
    initSingleSource(s);
    PriorityQueue<AdjVertex<T>> queue = new PriorityQueue<>();
    queue.add(s);
    while (!queue.isEmpty()) {
        AdjVertex<T> u = queue.poll();
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
    }
}