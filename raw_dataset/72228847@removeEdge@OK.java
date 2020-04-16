public void removeEdge(int src, int des) {
    if (adj.containsKey(src) && adj.get(src).containsKey(des)) {
        adj.get(src).remove(des);
    }
}