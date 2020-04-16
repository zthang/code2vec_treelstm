public static int[] KMP(String val) {
    int i = 0;
    int j = -1;
    int[] result = new int[val.length() + 1];
    result[0] = -1;
    while (i < val.length()) {
        while (j >= 0 && val.charAt(j) != val.charAt(i)) {
            j = result[j];
        }
        j++;
        i++;
        result[i] = j;
    }
    return result;
}