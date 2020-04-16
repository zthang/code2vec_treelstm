public int hashCode() {
    long x = (1l * first * inf + second) % mod;
    x = (x * inf + third) % mod;
    return (int) x;
}