public void join(int x, int y, int[] pre) {
    int a = find(x, pre);
    int b = find(y, pre);
    if (a != b) {
        pre[a] = b;
    }
}