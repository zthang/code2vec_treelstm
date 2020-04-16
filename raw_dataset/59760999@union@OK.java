public void union(int i, int j) {
    i = find(i);
    j = find(j);
    if (sz[j] > sz[i]) {
        int temp = i;
        i = j;
        j = temp;
    }
    arr[j] = i;
    sz[i] += sz[j];
}