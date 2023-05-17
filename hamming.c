#include <stdio.h>

int main() {
    int data[4];          // Data bits
    int dataatrec[7];     // Received data bits
    int c, c1, c2, c3, i; // Parity and index variables

    printf("Enter 4 bits of data one by one\n");
    for (i = 0; i < 4; i++) {
        scanf("%d", &data[i]);
    }

    // Calculation of even parity
    data[6] = data[0] ^ data[2] ^ data[4];
    data[5] = data[0] ^ data[1] ^ data[4];
    data[3] = data[0] ^ data[1] ^ data[2];

    printf("\nEncoded data is\n");
    for (i = 0; i < 7; i++) {
        printf("%d", data[i]);
    }

    printf("\n\nEnter received data bits one by one\n");
    for (i = 0; i < 7; i++) {
        scanf("%d", &dataatrec[i]);
    }

    // Calculate the parity bits at the receiver's end
    c1 = dataatrec[6] ^ dataatrec[4] ^ dataatrec[2] ^ dataatrec[0];
    c2 = dataatrec[5] ^ dataatrec[4] ^ dataatrec[1] ^ dataatrec[0];
    c3 = dataatrec[3] ^ dataatrec[2] ^ dataatrec[1] ^ dataatrec[0];
    c = c3 * 4 + c2 * 2 + c1;

    if (c == 0) {
        printf("\nNo error while transmission of data\n");
    } else {
        printf("\nError at position %d\n", c);
        printf("Data sent: ");
        for (i = 0; i < 7; i++) {
            printf("%d", data[i]);
        }
        printf("\nData received: ");
        for (i = 0; i < 7; i++) {
            printf("%d", dataatrec[i]);
        }
        printf("\nCorrected message is\n");

        dataatrec[7-c] = 1-dataatrec[7-c];

        for (i = 0; i < 7; i++) {
            printf("%d", dataatrec[i]);
        }
    }

    return 0;
}
