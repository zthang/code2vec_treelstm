void expand() {
    if (size >= data.length) {
        data = copyOf(data, (data.length << 1) + 1);
    }
}