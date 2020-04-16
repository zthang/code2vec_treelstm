public StringTokenizer getStringTokenizer() throws IOException {
    String line = bufferedReader.readLine().replaceAll("\\s+$", "");
    return new StringTokenizer(line, " ");
}