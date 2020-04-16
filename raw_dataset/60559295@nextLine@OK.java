public String nextLine() throws IOException {
    if (!hasNextLine())
        throw new NullPointerException();
    StringBuilder sb = new StringBuilder();
    while (buf[now] != '\n') {
        sb.append(buf[now]);
        if (!move())
            return sb.toString();
    }
    now++;
    return sb.toString();
}