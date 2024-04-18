// C++ program to find minimum sum of two numbers 
// formed from digits of the array. 
//#include <bits/stdc++.h> 
#include <stdio.h>
#include <stdlib.h>
//using namespace std; 
  
// Function to find and return minimum sum of 
// two numbers formed from digits of the array. 
int solve(int arr[], int n) 
{ 
    // sort the array 
    sort(arr, arr + n); 
    
    // let two numbers be a and b 
    int a = 0, b = 0; 
    for (int i = 0; i < n; i++) 
    { 
        // fill a and b with every alternate digit 
        // of input array 
        if (i & 1) 
            a = a*10 + arr[i]; 
        else
            b = b*10 + arr[i]; 
    } 
  
    // return the sum 
    return a + b; 
} 
  
// Driver code 
int main() 
{ 
    int arr[] = {6, 8, 4, 5, 2, 3}; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    printf("%d", solve(arr, n)); 
    return 0; 
}