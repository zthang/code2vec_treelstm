static int find(int x) {
    if (anc[x] != x) {
        anc[x] = find(anc[x]);
    }
    return anc[x];
}