int getParent(int i) {
    if (p[i] == i) {
        return i;
    }
    return p[i] = getParent(p[i]);
}