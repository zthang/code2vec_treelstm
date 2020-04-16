static void union(int i, int j) {
    i = find(i);
    j = find(j);
    if (i != j && size[i] < size[j]) {
        int tmp = i;
        i = j;
        j = tmp;
    }
    parent[j] = i;
    if (size[i] == size[j]) {
        size[i]++;
    }
}