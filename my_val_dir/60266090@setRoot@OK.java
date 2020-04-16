public void setRoot(int i) {
    if (rootOf(i) == i) {
        return;
    }
    Splay.splay(nodes[i]);
    Splay l = Splay.splitLeft(nodes[i]);
    if (l == Splay.NIL) {
        return;
    }
    Splay a = Splay.selectMinAsRoot(l);
    Splay b = Splay.selectMaxAsRoot(nodes[i]);
    if (nodes[a.id] == a) {
        Splay.splitLeft(b);
        destroy(b);
    } else {
        l = Splay.splitRight(a);
        destroy(a);
    }
    Splay newNode = alloc(i);
    Splay.splay(nodes[i]);
    Splay.splay(l);
    Splay.merge(nodes[i], Splay.merge(l, newNode));
}