static String StSort(String s) {
    StringBuilder sb = new StringBuilder(s);
    int lg = sb.length();
    int l;
    int r;
    int gaze;
    for (int i = 1; i < lg; i++) {
        l = 0;
        r = i - 1;
        while (l <= r) {
            gaze = (l + r) / 2;
            if (sb.charAt(gaze) <= sb.charAt(i)) {
                l = gaze + 1;
            } else if (sb.charAt(gaze) > sb.charAt(i)) {
                r = gaze - 1;
            }
        }
        sb.insert(l, sb.charAt(i));
        sb.deleteCharAt(i + 1);
    }
    return sb.toString();
}