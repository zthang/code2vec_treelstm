public static int calpc(char[] pc) {
    int k1 = 1;
    int pc1 = 0;
    for (int k = 3; k >= 0; k--) {
        pc1 += (pc[k] - '0') * k1;
        k1 *= 10;
    }
    return pc1;
}