public static int floorLog(int x) {
    return x < LIMIT ? CACHE[x] : (BITS + CACHE[x >>> BITS]);
}