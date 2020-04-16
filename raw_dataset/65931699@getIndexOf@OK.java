public int getIndexOf(Vertex<T> v) {
    int index = -1;
    boolean searching = true;
    for (int i = 0; i < vertices.size() && searching; i++) {
        if (vertices.get(i) == v) {
            index = i;
            searching = false;
        }
    }
    return index;
}