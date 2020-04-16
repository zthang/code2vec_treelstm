int getRoot(int i) {
    int curr = i;
    while (root[curr] != curr) curr = root[curr];
    while (i != curr) {
        int tmp = i;
        i = root[i];
        root[tmp] = curr;
    }
    return curr;
}