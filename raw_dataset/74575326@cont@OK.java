public static boolean cont(String a, String b) {
    int n = b.length();
    for (int i = 0; i < a.length() - n; i++) {
        if (sub(a.substring(i, i + n), b))
            return true;
    }
    return false;
}