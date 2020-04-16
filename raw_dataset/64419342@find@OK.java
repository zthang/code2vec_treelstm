public int find(int t, int i) {
    if (time[i] > t) {
        return i;
    } else {
        return find(t, root[i]);
    }
}