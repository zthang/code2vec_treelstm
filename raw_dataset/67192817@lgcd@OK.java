static long lgcd(long a, long b) {
    if (b == 0)
        return a;
    return lgcd(b, a % b);
}