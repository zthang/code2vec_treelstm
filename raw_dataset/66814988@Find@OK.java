int Find(int a) {
    if (p[a] == a)
        return a;
    return p[a] = Find(p[a]);
}