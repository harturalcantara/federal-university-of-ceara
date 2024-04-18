#include <stdio.h>

#define double f = -INFINITY;




int find_majority_element(int arr[], int length);

int main() {
    int arr[] = { 12, 3, 1, 1, 3, 4, 2, 2, 9, 6, 2, 1, 2 };
    int length = sizeof(arr)/sizeof(int);

    int result = find_majority_element(arr, length);

    if (result == -1) {
        printf("None");
    } 
    
    else {
        printf("Majoritary: %d\n", result);
    }
    return 0;
}




int find_majority_element(int arr[], int length) {

    if (length == 2) {
        if (arr[0] == arr[1]) {
            return arr[0];
        } 
        else {
            return -1;
        }
    } 
    else if (length == 1) {
        return arr[0];
    }

    int *leftHalf = arr;
    int *rightHalf = arr + length/2;

    int element1 = find_majority_element(leftHalf, length/2);
    //int element2 = find_majority_element(rightHalf, length/2);
    int element2 = find_majority_element(rightHalf, length - length/2);

    if (element1 == -1 && element2 >= 0) {
        return element2;
    } 
    else if (element2 == -1 && element1 >= 0) {
        return element1;   
    }

    if (element1 == element2) {
        return element1;
    } 
    else {
        return -1;
    }

}