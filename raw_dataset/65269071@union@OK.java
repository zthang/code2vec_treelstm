static void union(subset[] s, int i, int j) {
    int x = find(s, i);
    int y = find(s, j);
    if (x == y)
        return;
    if (s[x].r > s[y].r)
        s[y].p = x;
    else if (s[x].r < s[y].r)
        s[x].p = y;
    else {
        s[y].p = x;
        s[x].r++;
    }
}