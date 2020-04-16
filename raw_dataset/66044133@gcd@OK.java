static int gcd(int a, int b) {
    if (b % a == 0)
        return a;
    return gcd(b % a, a);
}