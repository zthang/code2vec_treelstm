int gcd(int s, int l) {
    if (s == 0) {
        return l;
    }
    return gcd(l % s, s);
}