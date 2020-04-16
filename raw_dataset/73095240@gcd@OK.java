public long gcd(long r, long ans) {
    if (r == 0)
        return ans;
    return gcd(ans % r, r);
}