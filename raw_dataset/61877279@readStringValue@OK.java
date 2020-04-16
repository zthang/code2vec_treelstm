public String readStringValue() throws IOException {
    return bufferedReader.readLine().replaceAll("\\s+$", "");
}