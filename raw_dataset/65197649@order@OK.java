public static void order(int[] order, int[] array) {
    int[] tempInt = new int[order.length];
    for (int i = 0; i < order.length; i++) {
        tempInt[i] = array[order[i]];
    }
    System.arraycopy(tempInt, 0, array, 0, array.length);
}