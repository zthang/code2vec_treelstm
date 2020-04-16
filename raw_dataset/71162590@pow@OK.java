static // O(log e)
long pow(// O(log e)
long a, // O(log e)
long e) {
    long res = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            res *= a;
        a *= a;
        e >>= 1;
    }
    return res;
}