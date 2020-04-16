public static boolean sub(String a, String b) {
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) == b.charAt(i) || a.charAt(i) == '?' || b.charAt(i) == '?')
            continue;
        return false;
    }
    return true;
}