static // O(log e)
long Pow(// O(log e)
long a, // O(log e)
int e, // O(log e)
int mod) {
    a %= mod;
    long res = 1;
    while (e > 0) {
        if ((e & 1) == 1)
            res = (res * a) % mod;
        a = (a * a) % mod;
        e >>= 1;
    }
    return res;
}