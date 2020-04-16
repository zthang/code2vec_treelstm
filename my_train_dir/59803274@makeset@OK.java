void makeset(int i) {
    par[i] = i;
    size[i] = 1;
    rank[i] = 0;
    hs.add(i);
}