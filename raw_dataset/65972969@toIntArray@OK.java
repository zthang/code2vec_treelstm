public static int[] toIntArray(char[] arr) {
    return asList(arr).stream().mapToInt(a -> a).toArray();
}