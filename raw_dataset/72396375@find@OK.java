public int find(int a) {
    return p[a] == p[p[a]] ? p[a] : (p[a] = find(p[a]));
}