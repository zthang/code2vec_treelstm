public void addEdge(Node a, Node b, int len) {
    Edge e = new Edge();
    e.a = a;
    e.b = b;
    e.len = len;
    a.next.add(e);
    b.next.add(e);
}