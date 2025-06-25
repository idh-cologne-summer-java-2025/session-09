package SortAlgorthms;

public class SortAlgorithms {
	
	public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arrToSort, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }

        int midIdx = startIdx + (endIdx - startIdx) / 2;
        mergeSort(arrToSort, startIdx, midIdx);
        mergeSort(arrToSort, midIdx + 1, endIdx);
        merge(arrToSort, startIdx, midIdx, endIdx);
    }

    public static void merge(int[] arrToSort, int startIdx, int midIdx, int endIdx) {
        int[] leftArr = new int[midIdx - startIdx + 1];
        int[] rightArr = new int[endIdx - midIdx];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arrToSort[startIdx + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arrToSort[midIdx + i + 1];
        }

        int leftArrIdx = 0, rightArrIdx = 0, sortedArrIdx = startIdx;
        while ((leftArrIdx < leftArr.length) && (rightArrIdx < rightArr.length)) {
            if (leftArr[leftArrIdx] < rightArr[rightArrIdx]) {
                arrToSort[sortedArrIdx] = leftArr[leftArrIdx];
                leftArrIdx += 1;
            } else {
                arrToSort[sortedArrIdx] = rightArr[rightArrIdx];
                rightArrIdx += 1;
            }
            sortedArrIdx += 1;
        }

        while (leftArrIdx < leftArr.length) {
            arrToSort[sortedArrIdx] = leftArr[leftArrIdx];
            leftArrIdx += 1;
            sortedArrIdx += 1;
        }

        while (rightArrIdx < rightArr.length) {
            arrToSort[sortedArrIdx] = rightArr[rightArrIdx];
            rightArrIdx += 1;
            sortedArrIdx += 1;
        }
    }
    
    public static void quickSort(int[] arr) {
        quickSortWirth(arr, 0, arr.length - 1);
    }

    public static void quickSortWirth(int arr[], int l, int r) {
        int i, j, w, x;
        i = l;
        j = r;
        x = arr[(l + r) / 2];
        do {
            while (arr[i] < x)
                i++;
            while (x < arr[j])
                j--;
            if (i <= j) {
                w = arr[i];
                arr[i] = arr[j];
                arr[j] = w;
                i++;
                j--;
            }
        } while (i <= j);
        if (l < j)
            quickSortWirth(arr, l, j);
        if (i < r)
            quickSortWirth(arr, i, r);
    }
}
