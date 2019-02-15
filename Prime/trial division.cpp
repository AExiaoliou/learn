#include <cmath>

bool fool(int x) {
    bool isPrime = true;
    for (int i = 2; i < sqrt(x); i++) 
        if (x % i == 0) {
            isPrime = false;
            break;
        }
    }
    return isPrime;
}
