@Override
public String next() throws IOException {
    if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
        stringTokenizer = new StringTokenizer(reader.readLine());
    }
    return stringTokenizer.nextToken();
}