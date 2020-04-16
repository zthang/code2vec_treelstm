public static Integer[] integerList(int fi, int fo) {
    Integer[] l = new Integer[fo - fi];
    for (int i = 0; i < fo - fi; i++) l[i] = fi + i;
    return l;
}