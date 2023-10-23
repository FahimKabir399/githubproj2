#include <stdio.h>
#include <string.h>


void word_caesar(char* word, int shift) {
    int length = strlen(word);
    for (int i = 0; i < length; i++) {
        char* ch = &word[i];
        if (*ch >= 'A' && *ch <= 'Z') {  // Uppercase letter
            *ch = (*ch - 'A' + shift) % 26 + 'A';
        } else if (*ch >= 'a' && *ch <= 'z') {  // Lowercase letter
            *ch = (*ch - 'a' + shift) % 26 + 'a';
        }
    }
}

int main() {
    char word[100];
    int shift;

    printf("Enter a word: ");
    scanf("%s", word);

    printf("Enter the shift amount: ");
    scanf("%d", &shift);

    word_caesar(word, shift);

    printf("Caesar cipher result: %s\n", word);

    return 0;
}
