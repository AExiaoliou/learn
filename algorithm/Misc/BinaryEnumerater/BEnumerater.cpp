class BEnumerater {
public:
	BEnumerater(int length);
	~BEnumerater();
	int length();
	int possibilitise();
	bool hasnext();
	bool* next();
	bool* last();
	bool* rnext();
	bool* rlast();
private:
	int len;
	int poss;
	int sentinel = 0;
	bool** enumer;
};
BEnumerater::BEnumerater(int length) {
	len = length;
	poss = 1 << len;

	enumer = new bool *[poss];
	for (int i = 0; i < poss; i++)
		enumer[i] = new bool[len];

	for (int i = 0; i < poss; i++)
		for (int j = 0; j < len; j++)
			enumer[i][j] = i & (1 << j);
}
BEnumerater::~BEnumerater() {
	for (int i = 0; i < poss; i++)
		delete[] enumer[i];
	delete[] enumer;
}
int BEnumerater::length() { return len; }
int BEnumerater::possibilitise() { return poss; }
bool BEnumerater::hasnext() { return sentinel >= 0 && sentinel < poss; }
bool* BEnumerater::next() { return enumer[sentinel++]; }
bool* BEnumerater::last() { return enumer[--sentinel]; }
bool* BEnumerater::rnext() {
	sentinel++;
	return enumer[poss - sentinel];
}
bool* BEnumerater::rlast() {
	sentinel--;
	return enumer[poss - sentinel];
}

int main() {
	auto enumer = BEnumerater(4);
	while (enumer.hasnext()) {
		auto a = enumer.next();
		for (int i = 0; i < enumer.length(); i++)
			printf(a[i] ? "1" : "0");
		printf("\n");
	}
}
/*
output:
0000
1000
0100
1100
0010
1010
0110
1110
0001
1001
0101
1101
0011
1011
0111
1111
*/
