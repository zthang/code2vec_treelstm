static int find(subset[] s, int x) {
    if (s[x].p == x)
        return x;
    s[x].p = find(s, s[x].p);
    return s[x].p;
}