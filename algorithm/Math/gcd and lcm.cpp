//input a, b
//base ver.
int gcd(int a, int b){
    int tmp;
    while((tmp = a % b) != 0){
        a = b;
        b = tmp;
    }
    return b;
}

//recursion ver.
//Depending on modern compiler, it will not be slower than base ver, and do not worry about the stack depth.
int gcd(int a, int b){
    return b == 0 ? a : gcd(b, a % b);
}

int lcm(int a, int b){
    return a * b / gcd(a, b);
}

//if two number's gcd is 1, they are coprime.
bool coprime(int a, int b){
    return gcd(a, b) == 1;   
}

//always got
int ab(int gcd, int lcm){
    return gcd * lcm;//ans is a * b   
}


