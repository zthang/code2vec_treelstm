public void make(int i, int j) {
    int i1 = get(i);
    int j1 = get(j);
    if (i1 != j1) {
        size[j1] += size[i1];
        a[i1] = j1;
    }
}