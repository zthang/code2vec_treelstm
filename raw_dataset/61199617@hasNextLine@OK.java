public boolean hasNextLine() throws IOException {
    return now < len || refill();
}