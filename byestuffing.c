#include <stdio.h>

int main()
{
    char input[100], stuffed[200];
    int i, j, k;
    
    printf("Enter the input data: ");
    scanf("%s", input);
    
    j = 0;
    stuffed[j++] = 'D';
    stuffed[j++] = 'L';
    stuffed[j++] = 'E';
    
    for (i = 0; input[i] != '\0'; i++)
    {
        if (input[i] == 'D' && input[i + 1] == 'L' && input[i + 2] == 'E')
        {
            stuffed[j++] = 'D';
            stuffed[j++] = 'L';
            stuffed[j++] = 'E';
            stuffed[j++] = 'D';
        }
        else
        {
            stuffed[j++] = input[i];
        }
    }
    
    stuffed[j++] = 'D';
    stuffed[j++] = 'L';
    stuffed[j++] = 'E';
    
    printf("After Byte Stuffing: ");
    for (k = 0; k < j; k++)
    {
        printf("%c", stuffed[k]);
    }
    
    return 0;
}
