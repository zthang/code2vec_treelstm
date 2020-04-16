public static int max(int[] ar) {
    return Arrays.stream(ar).max().getAsInt();
}