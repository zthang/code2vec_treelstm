static void root(int n, int p) {
    tree[n].p = p;
    for (int ch : tree[n].ch) {
        if (ch != p) {
            root(ch, n);
        }
    }
}