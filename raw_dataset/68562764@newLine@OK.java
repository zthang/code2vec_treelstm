private void newLine() {
    if (line == null || eol()) {
        line = split(readLine());
        index = 0;
    }
}