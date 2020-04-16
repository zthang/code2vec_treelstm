public static void deepFill(Object array, long val) {
    if (!array.getClass().isArray()) {
        throw new IllegalArgumentException();
    }
    if (array instanceof long[]) {
        long[] longArray = (long[]) array;
        Arrays.fill(longArray, val);
    } else {
        Object[] objArray = (Object[]) array;
        for (Object obj : objArray) {
            deepFill(obj, val);
        }
    }
}