private int getHash(int value) {
    int hash = IntHash.hash(value);
    int result = hash;
    for (int i : SHIFTS) {
        result ^= hash >> i;
    }
    result %= values.length;
    if (result < 0) {
        result += values.length;
    }
    return result;
}