public int max(int[] ar) {
    int ret = ar[0];
    for (int itr : ar) ret = Math.max(ret, itr);
    return ret;
}