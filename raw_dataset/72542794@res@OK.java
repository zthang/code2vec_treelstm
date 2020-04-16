static char res(int r, int c, int pr, int pc) {
    for (int i = 0; i < 4; i++) {
        if (r == pr + dirR[i] && c == pc + dirC[i]) {
            return chrs[i];
        }
    }
    return 'X';
}