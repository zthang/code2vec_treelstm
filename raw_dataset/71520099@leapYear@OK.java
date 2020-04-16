private boolean leapYear(int i) {
    return i % 400 == 0 || (i % 4 == 0 && i % 100 != 0);
}