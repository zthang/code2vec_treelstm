public String readWord() throws IOException {
    skip();
    int start = pos;
    while (pos < line.length() && !isSpace(line.charAt(pos))) {
        pos++;
    }
    return line.substring(start, pos);
}