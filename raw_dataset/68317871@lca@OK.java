public int lca(int x, int y) {
    int hb = i[x] == i[y] ? Integer.lowestOneBit(i[x]) : (1 << CachedLog2.floorLog(i[x] ^ i[y]));
    int hz = Integer.lowestOneBit(a[x] & a[y] & -hb);
    int ex = enterIntoStrip(x, hz);
    int ey = enterIntoStrip(y, hz);
    return preOrder[ex] < preOrder[ey] ? ex : ey;
}