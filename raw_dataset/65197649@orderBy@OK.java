public static void orderBy(int[] base, int[]... arrays) {
    int[] order = ArrayUtils.order(base);
    order(order, base);
    for (int[] array : arrays) {
        order(order, array);
    }
}