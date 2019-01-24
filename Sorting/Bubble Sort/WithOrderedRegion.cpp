void Swaper(int& a, int& b) {}//suppose we have a swaper
void BubbleSort(int a[], int len) {
	int lastIndex = 0;
	int sortBorder = len - 1;
	for (int i = 0; i < sortBorder; i++) {
		bool isSorted = true;
		for (int j = i + 1; j < len; j++) {
			if (a[i] > a[j]) {
				Swaper(a[i], a[j]);
				lastIndex = j;
				isSorted = false;
			}
		}
		sortBorder = lastIndex;
		if (isSorted) break;
	}
}
