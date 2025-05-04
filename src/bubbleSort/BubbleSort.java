package bubbleSort;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = {5, 6, 3, 45, 1, 3, 9};
		
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			cnt++;
			// Without optimization: (the length of j loop).
			for(int j = 0; j < arr.length-1-i; j++) {
				cnt++;
				if(arr[j] > arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				System.out.print("Inside nested loop: ");
				for(int k: arr) {
					System.out.print(k+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("Ouside nested loop: ");
			// Print out the array for our reference of how the array is being is sorted.
			for(int k: arr) {
				System.out.print(k+" ");
			}
			System.out.println();
			System.out.println();

		}
		System.out.println("");
	}
}
