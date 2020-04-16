public int min(int[] ar) {
    int ret = ar[0];
    for (int itr : ar) ret = Math.min(ret, itr);
    return ret;
}