private int enterIntoStrip(int x, int hz) {
    if (Integer.lowestOneBit(i[x]) == hz)
        return x;
    int hw = 1 << CachedLog2.floorLog(a[x] & (hz - 1));
    return parent[head[i[x] & -hw | hw]];
}