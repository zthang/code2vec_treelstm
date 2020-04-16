public static long power(long x, long y, long mods) {
    if (y == 0)
        return 1 % mods;
    long u = power(x, y / 2, mods);
    u = ((u) * (u)) % mods;
    if (y % 2 == 1)
        u = (u * (x % mods)) % mods;
    return u;
}