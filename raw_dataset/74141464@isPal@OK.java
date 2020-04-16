public static boolean isPal(String s) {
    boolean t = true;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            t = false;
            break;
        }
    }
    return t;
}