static boolean hasNext() {
    while (tok == null || !tok.hasMoreTokens()) try {
        tok = new StringTokenizer(in.readLine());
    } catch (Exception e) {
        return false;
    }
    return true;
}