private static String getVal(String str, int k) {
    int val = str.length() - k;
    if (val % 2 != 0) {
        String flip = str.substring(0, k);
        String org = str.substring(k);
        StringBuilder input1 = new StringBuilder();
        input1.append(flip);
        return org + input1.reverse();
    } else {
        return str.substring(k) + str.substring(0, k);
    }
}