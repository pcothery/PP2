package mergeSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class MemoryMergeSort {

	public static void mergeSort(int[] arr, int arrSize) {
		if (arrSize < 2) {
			return;
		}
		int mid = arrSize / 2;
		int[] l = new int[mid];
		int[] r = new int[arrSize - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = arr[i];
		}
		for (int i = mid; i < arrSize; i++) {
			r[i - mid] = arr[i];
		}
		mergeSort(l, mid);
		mergeSort(r, arrSize - mid);

		merge(arr, l, r, mid, arrSize - mid);
	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

	public static void main(String[] args) {
		Random ran = new Random();
		try {
			for (int i = 1; i < 10; i++) {
				File csv = new File(Math.pow(10, i) + "data.csv");
				PrintWriter pw = new PrintWriter(csv);
				for (int j = 0; j < 1000; j++) {
					int[] temp = new int[(int) Math.pow(10, i)];
					for (int k = 0; k < (Math.pow(10, i)); k++) {
						temp[k] = ran.nextInt();
					} // populate test array
					long startTime = System.currentTimeMillis();
					mergeSort(temp, (int) Math.pow(10, i));
					long endTime = System.currentTimeMillis();
					pw.println(j + "," + startTime + "," + endTime + "," + (endTime - startTime));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
