static boolean check(String a) {
    int len = a.length();
    char z;
    int l = 0;
    int r = len - 1;
    int p = 0;
    while (l <= r && p == 0) {
        if (a.charAt(l) == a.charAt(r)) {
            l++;
            r--;
        } else
            p = 1;
    }
    if (p == 0)
        return (true);
    else
        return (false);
}