public int nextInt() {
    String n = next();
    int r = 0;
    for (int l = 0; l < n.length(); l++) {
        r *= 10;
        r += n.charAt(l) - '0';
    }
    return r;
}