static int gcd(int a, int b) throws IOException {
    return (b == 0) ? a : gcd(b, a % b);
}