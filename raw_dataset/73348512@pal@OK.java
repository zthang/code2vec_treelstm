static boolean pal(String s) {
    int n = s.length(), i1 = 0, i2 = n - 1;
    while (i1 < i2) {
        if (s.charAt(i1) != s.charAt(i2))
            return false;
        i1++;
        i2--;
    }
    return true;
}