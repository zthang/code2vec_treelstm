private JN add(JN oth) {
    state = ustate(state, oth.state);
    pr1 = un(pr1, oth.pr1);
    pr2 = un(pr2, oth.pr2);
    return this;
}