static void DfsB(int o) {
    v[o] = true;
    m++;
    int x = 0;
    for (int i : B[o]) {
        if (!c[i]) {
            DfsG(i);
            x++;
        }
    }
    if (x == 0) {
        b = o;
    }
}