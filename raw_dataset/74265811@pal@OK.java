static boolean pal(String s) {
    int n = s.length();
    int l = 0;
    int r = n - 1;
    int flag = 0;
    while (l < r) {
        if (s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        } else {
            flag = 1;
            break;
        }
    }
    if (flag == 1)
        return false;
    else
        return true;
}