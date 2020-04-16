private void union(int p, int q) {
    int proot = find(p);
    int qroot = find(q);
    if (proot > qroot) {
        id[qroot] = proot;
    } else {
        id[proot] = qroot;
    }
}