public int get(int i) {
    if (a[i] == i)
        return i;
    return a[i] = get(a[i]);
}