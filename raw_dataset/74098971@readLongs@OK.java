public long[] readLongs() throws IOException {
    return toLongArray(reader.readLine());
}