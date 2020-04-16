public int floorLog(int x) {
    if (x >= cache.length) {
        return log2.floorLog(x);
    }
    return cache[x];
}