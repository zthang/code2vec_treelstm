public static int inter(String a, String b) {
    int n = min(a.length(), b.length());
    if (cont(a, b) || cont(b, a))
        return n;
    while (n > 0) {
        if (sub(a.substring(a.length() - n), (b.substring(0, n))))
            return n;
        n--;
    }
    return 0;
}