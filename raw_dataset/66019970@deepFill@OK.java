public static void deepFill(Object array, int val) {
    if (!array.getClass().isArray()) {
        throw new IllegalArgumentException();
    }
    if (array instanceof int[]) {
        int[] intArray = (int[]) array;
        Arrays.fill(intArray, val);
    } else {
        Object[] objArray = (Object[]) array;
        for (Object obj : objArray) {
            deepFill(obj, val);
        }
    }
}