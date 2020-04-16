static int find(int i) {
    if (p[i] == i)
        return i;
    return p[i] = find(p[i]);
}