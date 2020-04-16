int lcm(int[] a) {
    int rv = a[0];
    for (int i = 1; i < a.length; i++) {
        rv = (rv * a[i]) / gcd(rv, a[i]);
    }
    return rv;
}