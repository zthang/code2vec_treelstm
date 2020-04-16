public static void unite(int a, int b) {
    int fx = find(a);
    int fy = find(b);
    if (fx != fy)
        pre[fx] = fy;
}