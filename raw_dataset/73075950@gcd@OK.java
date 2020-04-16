// Find the GCD of two numbers
public static long gcd(long a, long b) {
    if (a < b)
        return gcd(b, a);
    if (b == 0)
        return a;
    else
        return gcd(b, a % b);
}