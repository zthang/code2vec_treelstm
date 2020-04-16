char op(char ch) {
    switch(ch) {
        case 'R':
            return 'L';
        case 'L':
            return 'R';
        case 'U':
            return 'D';
        case 'D':
            return 'U';
    }
    return 'X';
}