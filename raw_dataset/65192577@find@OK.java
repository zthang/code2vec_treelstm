public TaskD.Node find() {
    return p.p == p ? p : (p = p.find());
}