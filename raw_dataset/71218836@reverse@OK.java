public static String reverse(String s1) {
    String s2 = "";
    for (int i = 0; i < s1.length(); i++) {
        s2 = s1.charAt(i) + s2;
    }
    return s2;
}