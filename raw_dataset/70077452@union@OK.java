public boolean union(int a, int b) {
    if ((a = find(a)) == (b = find(b)))
        return false;
    if (s[a] == s[b])
        s[a]--;
    if (s[a] <= s[b]) {
        s[b] = a;
        sizeOf[a] += sizeOf[b];
        impossible[a] |= impossible[b];
    } else {
        s[a] = b;
        sizeOf[b] += sizeOf[a];
        impossible[b] |= impossible[a];
    }
    a = find(a);
    return true;
}