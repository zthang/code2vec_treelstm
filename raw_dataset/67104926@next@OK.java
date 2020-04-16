public String next() {
    if (token == null || !token.hasMoreElements()) {
        try {
            token = new StringTokenizer(in.readLine());
        } catch (IOException ex) {
        }
        return next();
    }
    return token.nextToken();
}