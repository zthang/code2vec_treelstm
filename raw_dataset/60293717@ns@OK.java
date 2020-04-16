String ns() {
    while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
        try {
            stringTokenizer = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return stringTokenizer.nextToken();
}