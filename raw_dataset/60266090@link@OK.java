public void link(EdgeInfo info) {
    int i = info.a;
    int j = info.b;
    setRoot(i);
    setRoot(j);
    Edge e = new Edge();
    long id = idOfEdge(i, j);
    e.a = alloc(-i * 10000 - j);
    e.b = alloc(-i * 10000 - j);
    e.a.info = info;
    e.a.pushUp();
    e.b.pushUp();
    map.put(id, e);
    Splay.splay(nodes[i]);
    Splay.splay(nodes[j]);
    Splay.merge(nodes[i], e.a);
    Splay.merge(nodes[j], e.b);
    Splay.splay(nodes[i]);
    Splay.splay(nodes[j]);
    Splay.merge(nodes[i], nodes[j]);
    Splay newNode = alloc(i);
    Splay.splay(nodes[i]);
    Splay.merge(nodes[i], newNode);
}