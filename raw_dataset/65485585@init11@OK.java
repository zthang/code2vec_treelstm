static void init11(int[] f) {
    o = f;
    int len = o.length;
    a = new S[len * 4];
    build1(1, 0, len - 1);
}