public void unify(int i, int j) {
    int a = find_set(i), b = find_set(j);
    if (a == b)
        return;
    numsets--;
    if (size[a] < size[b]) {
        pset[a] = b;
        size[b] += size[a];
    } else {
        pset[b] = a;
        size[a] += size[b];
    }
}