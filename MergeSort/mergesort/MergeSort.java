package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		showArray(array1);
		mergeSort(array1);
		showArray(array1);
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
	

	
	private static int[] mergeSort(int[] theArray, int left, int right) {
		
		if(left==right) {
			int[] newArray = {theArray[left]};
			return newArray;
		}
		else {
			int mid = (right - left)/2 + left;
			int[] array1 = mergeSort(theArray,left,mid);
			int[] array2 = mergeSort(theArray,mid+1,right);
			
			int[] array3 = new int[ array1.length + array2.length];
			int index1 = 0;
			int index2 = 0;
			
			for(int i = 0; i < array3.length; i++) {
				if(index1 >= array1.length) {
					array3[i] = array2[index2];
					index2++;
				}
				else if(index2 >= array2.length) {
					array3[i] = array1[index1];
					index1++;
				}
				else {
					if(array1[index1] <= array2[index2]) {
						array3[i] = array1[index1];
						index1++;
					}
					else {
						array3[i] = array2[index2];
						index2++;
					}
				}
			}
			return array3;
		}

	}
	
	public static void mergeSort(int[] array) {
		int[] newArray = mergeSort(array,0,array.length-1);
		for(int i = 0; i < newArray.length; i++) {
			array[i] = newArray[i];
		}
	}
}
