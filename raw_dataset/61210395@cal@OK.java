static int[] cal(double v) {
    int[] re = new int[2];
    if (v >= 0) {
        re[0] = (int) Math.floor(v);
        re[1] = (int) Math.ceil(v);
    } else {
        re[0] = (int) Math.ceil(v);
        re[1] = (int) Math.floor(v);
    }
    return re;
}