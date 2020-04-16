boolean hasNext() {
    while (tok == null || !tok.hasMoreElements()) {
        try {
            tok = new StringTokenizer(buf.readLine());
        } catch (Exception e) {
            return false;
        }
    }
    return true;
}