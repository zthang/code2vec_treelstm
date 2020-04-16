public static char upp(char pc) {
    if (pc == '9')
        return '0';
    else
        return (++pc);
}