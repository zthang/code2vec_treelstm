public int find_set(int i) {
    return pset[i] == i ? i : (pset[i] = find_set(pset[i]));
}