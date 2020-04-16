public void addEdge(Node a, Node b) {
    Edge e = new Edge();
    e.a = a;
    e.b = b;
    a.next.add(e);
    b.next.add(e);
}