public int find(int p) {
    while (iDs[p] != p) {
        p = iDs[p];
    }
    return p;
}