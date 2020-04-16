public String next() {
    if (hasNext())
        return tokenizer.nextToken();
    else
        throw new NoSuchElementException();
}