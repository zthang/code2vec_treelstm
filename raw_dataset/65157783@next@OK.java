String next() throws IOException {
    int c;
    for (c = scan(); c <= 32; c = scan()) ;
    StringBuilder sb = new StringBuilder();
    for (; c > 32; c = scan()) {
        sb.append((char) c);
    }
    return sb.toString();
}