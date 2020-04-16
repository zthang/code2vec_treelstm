public void setSet(int set) {
    int bitCount = 0;
    while (set != 0) {
        meanings[bitCount] = set & -set;
        bits[bitCount] = 0;
        set -= meanings[bitCount];
        bitCount++;
    }
    remain = 1 << bitCount;
    next = 0;
}