public static String reversed(String s) {
    char[] chars = new char[s.length()];
    for (int i = 0; i < chars.length; i++) {
        chars[i] = s.charAt(chars.length - 1 - i);
    }
    return new String(chars);
}