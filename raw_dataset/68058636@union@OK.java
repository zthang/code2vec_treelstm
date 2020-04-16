private boolean union(int p, int q) {
    int proot = find(p);
    int qroot = find(q);
    if (proot == qroot)
        return true;
    id[proot] = qroot;
    return false;
}