static long getgcd(long a, long b) {
    if (b == 0)
        return a;
    return getgcd(b, a % b);
}