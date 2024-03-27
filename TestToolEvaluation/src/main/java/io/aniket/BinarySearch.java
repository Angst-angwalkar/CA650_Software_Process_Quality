package io.aniket;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public BinarySearch(){};

    public int search(List<Integer> arr, int elem) throws IndexOutOfBoundsException{

        if (arr instanceof ArrayList == false){
            throw new IllegalArgumentException("Invalid Array Type");
        }

        if (arr.isEmpty()){
            throw new IndexOutOfBoundsException("Invalid Array Size");
        }
        else if (arr.size() == 1) {
            return -1;
        }

        int low = 0;
        int high = arr.size();
        int mid = -1;
        int count = 0;

        while (low < high){
            count++;
            mid = (low + high) / 2;
            int guess = arr.get(mid);

            if (guess == elem){
                return mid;
            } else if (guess > elem) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return mid;
    }


    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
    }
}
