public void addEdge(int src, int des, int dist) {
    adj.putIfAbsent(src, new HashMap<>());
    adj.get(src).put(des, dist);
}