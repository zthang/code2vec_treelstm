private int hash(long x) {
    int h = Long.hashCode(x);
    return h ^ (h >>> 16);
}