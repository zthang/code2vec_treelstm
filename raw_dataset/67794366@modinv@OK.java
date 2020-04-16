static int modinv(int a, int m) {
    int g = gcd(a, m);
    if (g != 1)
        return 0;
    else {
        return power(a, m - 2, m);
    }
// return 0;
}