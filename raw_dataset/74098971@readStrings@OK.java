public String[] readStrings() throws IOException {
    return reader.readLine().split("\\s");
}