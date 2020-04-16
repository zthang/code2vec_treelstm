private static String getBinaryStr(int n, int j) {
    String str = Integer.toBinaryString(n);
    int k = str.length();
    for (int i = 1; i <= j - k; i++) {
        str = "0" + str;
    }
    return str;
}