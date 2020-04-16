private static String asString(final int[] a) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length; i++) {
        sb.append(a[i]);
        sb.append(' ');
    }
    return sb.toString();
}