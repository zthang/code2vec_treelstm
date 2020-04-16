private Splay rootOf(Splay x) {
    Splay.splay(x);
    return Splay.selectMinAsRoot(x);
}