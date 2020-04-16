static void Union(int x, int y) {
    int xset = find(x);
    int yset = find(y);
    if (xset != yset)
        comp--;
    parent[xset] = yset;
}