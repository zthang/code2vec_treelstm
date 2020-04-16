public void connect(int i, int j) {
    int root1 = find(i);
    int root2 = find(j);
    ds[root1] = root2;
}