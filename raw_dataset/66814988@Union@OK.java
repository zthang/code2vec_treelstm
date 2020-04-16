void Union(int a, int b) {
    p[Find(b)] = Find(a);
}