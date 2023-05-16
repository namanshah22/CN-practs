#include <stdio.h>
#include <string.h>

int main() {
    int n, i;
    printf("Enter the number of strings: ");
    scanf("%d", &n);
    char s[n][50];
    int a[n];
    printf("Enter strings: \n");
    for (i = 0; i < n; i++) {
        scanf("%s", s[i]);
        a[i] = strlen(s[i]);
    }
    printf("Output: \n");
    for (i = 0; i < n; i++) {
        printf("%d%s", a[i] + 1, s[i]);
    }
    return 0;
}