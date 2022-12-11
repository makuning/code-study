#define _CRT_SECURE_NO_WARNINGS 1 

#include <stdio.h>

int main() {
	int num1 = 0, num2 = 0, score = 100;
	int i;
	char str;
	scanf("%d %c", &i, &str);

	while (i < 5) {
		if (str == 'T')
			num1++;
		else if (str == 'F') {
			score = score - 10;
			num2++;
		}
		i++;
	}

	printf("num1=%d,num2=%d,score=%d\n", num1, num2, score);
}