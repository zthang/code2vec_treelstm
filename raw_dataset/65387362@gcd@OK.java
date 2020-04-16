static int gcd(int a, int b) {
    if (b == 0)
        return 0;
    return gcd(b, a % b);
}