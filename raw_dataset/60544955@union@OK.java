public void union(int i, int j) {
    i = find(i);
    j = find(j);
    if (i == j) {
        return;
    }
    if (size[i] < size[j]) {
        int temp = i;
        i = j;
        j = temp;
    }
    arr[j] = i;
    size[i] += size[j];
}