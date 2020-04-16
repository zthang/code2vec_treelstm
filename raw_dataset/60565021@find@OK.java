int find(int p) {
    int rt = p;
    while (rt != id[rt]) rt = id[rt];
    while (p != rt) {
        int next = id[p];
        id[p] = rt;
        p = next;
    }
    return rt;
}