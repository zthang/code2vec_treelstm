static // O(log e)
long modPow(// O(log e)
long ways, // O(log e)
long count, // O(log e)
long mod) {
    ways %= mod;
    long res = 1;
    while (count > 0) {
        if ((count & 1) == 1)
            res = (res * ways) % mod;
        ways = (ways * ways) % mod;
        count >>= 1;
    }
    return res % mod;
}