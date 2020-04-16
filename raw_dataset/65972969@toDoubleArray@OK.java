public static double[] toDoubleArray(float[] arr) {
    return asList(arr).stream().mapToDouble(a -> a).toArray();
}