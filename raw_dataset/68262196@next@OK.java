public String next() {
    if (token == null || !token.hasMoreElements()) {
        try {
            token = new StringTokenizer(in.readLine());
        } catch (Exception e) {
        }
        return next();
    }
    return token.nextToken();
}