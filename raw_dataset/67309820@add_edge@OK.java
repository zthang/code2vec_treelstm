public void add_edge(Node other) {
    edges.add(other);
    other.edges.add(this);
}