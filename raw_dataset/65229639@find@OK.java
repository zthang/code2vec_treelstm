public Node find() {
    return p == null ? this : p.find();
}