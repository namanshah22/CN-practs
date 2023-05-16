#include <stdio.h>

int main()
{
    int a[20], b[30], i, j, count, n;
    
    printf("Enter frame size: ");
    scanf("%d", &n);
    
    printf("Enter the frame in the form of 0 and 1: ");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);
    
    i = 0;
    count = 0;
    j = 0;
    
    while (i < n)
    {
        b[j] = a[i];
        
        if (a[i] == 1)
        {
            count++;
            
            if (count == 5)
            {
                count = 0;
                j++;
                b[j] = 0;
            }
        }
        else
        {
            count = 0;
        }
        
        i++;
        j++;
    }
    
    printf("After Bit Stuffing: ");
    for (i = 0; i < j; i++)
    {
        printf("%d", b[i]);
    }
    
    return 0;
}
