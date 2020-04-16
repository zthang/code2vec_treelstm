public String sn() {
    while (token == null || !token.hasMoreTokens()) {
        try {
            token = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    return token.nextToken();
}