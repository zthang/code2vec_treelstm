static int hash(long key) {
    long hash = key * 1000000007;
    hash ^= hash >> 16;
    hash ^= hash >> 24;
    return (int) hash;
}