int costChoice(int i) {
    int other = i < half ? i + half : i - half;
    i = find(i);
    other = find(other);
    if (impossible[i])
        return sizeOf[other];
    if (impossible[other])
        return sizeOf[i];
    return Math.min(sizeOf[i], sizeOf[other]);
}