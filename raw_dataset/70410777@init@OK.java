static void init(int[] f) {
    o = f;
    int len = o.length;
    a = new S[len * 4];
    build(1, 0, len - 1);
}