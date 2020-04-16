public void flush() {
    for (String str : res) writer.printf("%s\n", str);
    res.clear();
    sb = new StringBuilder("");
}