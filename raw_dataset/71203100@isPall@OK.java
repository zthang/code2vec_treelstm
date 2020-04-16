static boolean isPall(String s) {
    int n = s.length();
    int l = 0;
    int r = n - 1;
    while (l < r) {
        if (s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        } else
            return false;
    }
    return true;
}