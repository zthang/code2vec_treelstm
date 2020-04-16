public int find(int a) {
    if (p[a] == p[p[a]]) {
        return p[a];
    }
    find(p[a]);
    delta[a] ^= delta[p[a]];
    return p[a] = find(p[a]);
}