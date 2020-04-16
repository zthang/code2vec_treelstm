private static int ceil(double d) {
    int ret = (int) d;
    return ret == d ? ret : ret + 1;
}