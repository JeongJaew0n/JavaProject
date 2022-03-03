package search;

class test {
    public static void main(String[] args) {
        int[] testArray = new int[10];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i*2;
        }
        for (int i : testArray) {
            System.out.print(i + " ");
        }

        int findingNumber = 5;
        int k = MyBinarySearch.binSearch(testArray, findingNumber);

        System.out.println("\n 찾는 숫자: " + findingNumber + "/찾은 숫자: " + k);
    }
}

public class MyBinarySearch {
    static int binSearch(int[] intArray, int findingNumber) {
        int m = intArray.length/2;
        int L = 0;
        int R = intArray.length - 1;
//
        int foundNumber;

        while (true) {
            if(L>=R || intArray[m] == findingNumber) {
                foundNumber = intArray[m];
                break;
            }
            if(intArray[m] < findingNumber) {
                L = m+1;
                m = (L+R)/2;
                continue;
            }
            R = m-1;
            m = (L+R)/2;
        }
        return foundNumber;
    }
}

