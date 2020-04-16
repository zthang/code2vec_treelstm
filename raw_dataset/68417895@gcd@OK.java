static long gcd(long ans, long b) {
    if (b == 0) {
        return ans;
    }
    return gcd(b, ans % b);
}