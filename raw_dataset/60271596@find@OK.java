long find(int a, int b) {
    int root_a = root(a);
    int root_b = root(b);
    if (root_a == root_b)
        return 0;
    else
        return sz[root_a] * sz[root_b];
}