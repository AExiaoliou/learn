//The easiest to remember and write
int lowbit(int x) {
    return x & (-x);
}

//or 
int lowbit(int x) {
    return x&-x; //but not intuitive for reader 
}

//this guy is the easiest to figure out by yourself
int lowbit(int x) {
    return x & (x ^ (x - 1));
}

//lowbit can check one num is it equals to 2^n ?
bool is2(int x) {
    return lowbit(x) == x;   
}

//or 2^n - 1
bool is2_(int x) {
    return lowbit(x + 1) == x + 1;
}

//remove lowest bit 1
void remove_last_bit1(int & x) {
    x ^= lowbit(x);   
}
