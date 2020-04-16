public static String rev(String str) {
    int n = str.length();
    char[] ch = str.toCharArray();
    char temp = ' ';
    for (int i = 0; i < n / 2; i++) {
        temp = ch[i];
        ch[i] = ch[n - i - 1];
        ch[n - i - 1] = temp;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) sb.append(ch[i]);
    return sb.toString();
}