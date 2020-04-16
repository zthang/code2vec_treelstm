private void skip() throws IOException {
    while (true) {
        if (pos >= line.length()) {
            line = reader.readLine();
            pos = 0;
        }
        while (pos < line.length() && isSpace(line.charAt(pos))) {
            pos++;
        }
        if (pos < line.length()) {
            return;
        }
    }
}