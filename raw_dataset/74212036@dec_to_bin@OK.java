public static StringBuilder dec_to_bin(long n) {
    // decimal to binary upto 30 binaries
    if (n == 0) {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < 30; i++) {
            str.append("0");
        }
        return str;
    }
    StringBuilder str = new StringBuilder("");
    while (n != 0) {
        str.append(n % 2L);
        n /= 2L;
    }
    str = str.reverse();
    StringBuilder tmp_str = new StringBuilder("");
    int len = str.length();
    while (len != 30) {
        tmp_str.append("0");
        len++;
    }
    tmp_str.append(str);
    return tmp_str;
}