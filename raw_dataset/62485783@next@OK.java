String next() throws IOException {
    while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
        String line = bufferedReader.readLine();
        if (line == null) {
            return null;
        }
        stringTokenizer = new StringTokenizer(line);
    }
    return stringTokenizer.nextToken();
}