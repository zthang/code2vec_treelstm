static int max(int... a) {
    int ret = a[0];
    for (int i = 1; i < a.length; i++) ret = Math.max(ret, a[i]);
    return ret;
}