static boolean chk(int par, int chld) {
    boolean f = false;
    if (rng[par][0] <= rng[chld][0] && rng[par][1] >= rng[chld][1])
        f = true;
    return f;
}