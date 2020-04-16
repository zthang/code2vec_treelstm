static int find(int x) {
    return (p[x] == x) ? x : (p[x] = find(p[x]));
}