public static Splay merge(Splay a, Splay b) {
    if (a == NIL) {
        return b;
    }
    if (b == NIL) {
        return a;
    }
    a = selectMaxAsRoot(a);
    a.setRight(b);
    a.pushUp();
    return a;
}