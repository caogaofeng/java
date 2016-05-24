import java.util.Arrays;
import java.util.Scanner;

public class LotterDrawing {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("How many numbers do you need to draw? ");
		int k = in.nextInt();

		System.out.println("What is the highest nubmer you can draw? ");
		int n = in.nextInt();

		// fill a array with numbers 1 2 3 4 .... n
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		// draw k numbers and put them into a second array
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			int r = (int) (Math.random() * n);
			result[i] = numbers[r];

			// 确保不会再抽到这个值，这里用数组的最后一个值改写numbers[r],并将n-1
			numbers[r] = numbers[n - 1];
			n--;
		}

		Arrays.sort(result);
		System.out
				.println("Bet the foolowing combination . It'll make you rich !");
		for (int r : result)
			System.out.println(r);
	}

}
