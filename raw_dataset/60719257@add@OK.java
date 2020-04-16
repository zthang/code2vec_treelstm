static int add(int a, int b) {
    if (a + b >= div)
        return (int) (a + b - div);
    return (int) a + b;
}