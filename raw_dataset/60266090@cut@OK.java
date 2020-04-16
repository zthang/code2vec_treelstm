public void cut(int i, int j) {
    long id = idOfEdge(i, j);
    Edge e = map.remove(id);
    Splay.splay(e.a);
    Splay al = Splay.splitLeft(e.a);
    Splay ar = Splay.splitRight(e.a);
    Splay l, r;
    if (rootOf(ar) == rootOf(e.b)) {
        Splay.splay(e.b);
        Splay bl = Splay.splitLeft(e.b);
        Splay br = Splay.splitRight(e.b);
        l = al;
        r = br;
    } else {
        Splay.splay(e.b);
        Splay bl = Splay.splitLeft(e.b);
        Splay br = Splay.splitRight(e.b);
        l = bl;
        r = ar;
    }
    Splay.splay(l);
    Splay.splay(r);
    l = Splay.selectMaxAsRoot(l);
    r = Splay.selectMinAsRoot(r);
    if (nodes[l.id] == l) {
        Splay rSnapshot = r;
        r = Splay.splitRight(r);
        destroy(rSnapshot);
    } else {
        Splay lSnapshot = l;
        l = Splay.splitLeft(l);
        destroy(lSnapshot);
    }
    Splay.merge(l, r);
    destroy(e.a);
    destroy(e.b);
}