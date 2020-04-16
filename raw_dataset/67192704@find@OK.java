static int find(int i) {
    if (dsu[i] == -1) {
        return i;
    } else {
        dsu[i] = find(dsu[i]);
        return dsu[i];
    }
}