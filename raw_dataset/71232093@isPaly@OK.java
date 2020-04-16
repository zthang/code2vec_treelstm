public static boolean isPaly(String string) {
    for (int i = 0; i < string.length() / 2; i++) {
        if (string.charAt(i) != string.charAt(string.length() - i - 1))
            return false;
    }
    return true;
}