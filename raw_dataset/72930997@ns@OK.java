String ns() {
    if (ip == null || !ip.hasMoreTokens()) {
        try {
            ip = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }
    return ip.nextToken();
}