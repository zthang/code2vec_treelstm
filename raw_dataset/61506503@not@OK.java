public static int not(int c, int c2) {
    boolean[] n = new boolean[4];
    n[c] = true;
    n[c2] = true;
    for (int i = 1; i <= 3; i++) {
        if (!n[i])
            return i;
    }
    return 0;
}