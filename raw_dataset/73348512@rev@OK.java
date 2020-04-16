static String rev(String r) {
    String s = "";
    int i = r.length() - 1;
    while (i >= 0) {
        s = s + r.charAt(i);
        i--;
    }
    return s;
}