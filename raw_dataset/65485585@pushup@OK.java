static void pushup(int num, int le, int ri) {
    a[num].c = Math.max(a[le].c, a[ri].c);
}