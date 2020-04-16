static void pushup(int num, int le, int ri) {
    a[num].all = (a[le].all * a[ri].all) % dd;
    a[num].le = (a[le].le + a[le].all * a[ri].le) % dd;
    a[num].ri = (a[ri].ri + a[ri].all * a[le].ri) % dd;
    a[num].tot = (a[le].tot + a[ri].tot + a[le].ri * a[ri].le) % dd;
// a[num].res[1] = Math.min(a[le].res[1],a[ri].res[1]);
}