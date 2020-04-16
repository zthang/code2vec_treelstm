public static long[] ila(String[] s) {
    long[] array = new long[s.length];
    for (int i = 0; i < s.length; i++) {
        array[i] = Long.parseLong(s[i]);
    }
    return array;
}