static String read() throws IOException {
    String line = "";
    while (line.length() == 0) {
        line = s1.readLine();
        continue;
    }
    return line;
}