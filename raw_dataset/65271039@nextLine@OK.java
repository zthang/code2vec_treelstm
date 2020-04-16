String nextLine() {
    while (buffer[curr] != '\n') toNextChar();
    int start = ++curr;
    while (curr < end && buffer[curr] != '\n') ++curr;
    if (curr < end)
        return new String(buffer, start, curr - start);
    StringBuilder sb = new StringBuilder(buffer.length);
    while (curr == end) {
        sb.append(new String(buffer, start, curr - start));
        reloadBuffer();
        if (eof)
            return sb.toString();
        start = 0;
        while (curr < end && buffer[curr] != '\n') ++curr;
    }
    sb.append(new String(buffer, start, curr - start));
    return sb.toString();
}