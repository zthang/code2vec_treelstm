public void add(Vertex other) {
    neighbors.add(other);
    other.rev.add(this);
}