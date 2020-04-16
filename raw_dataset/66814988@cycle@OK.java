boolean cycle(int a, int b) {
    return p[Find(a)] == p[Find(b)];
}