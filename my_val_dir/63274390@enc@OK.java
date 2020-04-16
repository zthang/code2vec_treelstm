int enc(String x) {
    char[] arr = x.toCharArray();
    int v = 0;
    for (int i = 0; i < arr.length; i++) {
        v |= 1 << (arr[i] - 'a');
    }
    return v;
}