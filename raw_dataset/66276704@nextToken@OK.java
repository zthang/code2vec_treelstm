String nextToken() {
    while (!stok.hasMoreTokens()) {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (s == null) {
            return null;
        }
        stok = new StringTokenizer(s);
    }
    return stok.nextToken();
}