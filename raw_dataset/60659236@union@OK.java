int union(int p, int q) {
    int proot = find(p);
    int qroot = find(q);
    if (proot == qroot)
        return 1;
    id[proot] = qroot;
    return 0;
}