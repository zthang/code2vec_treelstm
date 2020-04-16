public void add(Vertex other) {
    others.add(other);
    other.others.add(this);
}