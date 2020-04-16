public int getSet(int n) {
    if (p[n] == n)
        return n;
    else
        return p[n] = getSet(p[n]);
}