private static JN getj(int ints) {
    int r = uf.root(ints);
    if (jns[r] == null) {
        jns[r] = new JN(0, -1, -1);
    }
    return jns[r];
}