import java.util.Scanner;

public class Main {

	public static void Input(int[] arr)
	{
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++)
			arr[i] = in.nextInt();
	}

	public static void Output(int[] arr)
	{
		for (int val: arr)
			System.out.print(val + " ");
		System.out.println();
	}

	public static int Fn(int[] arr)
	{
		int count = 0;
		for (int i = 0; i < arr.length; i++)
		{
			int first;
			int second;

			if(i == 0)
			{
				first = arr[arr.length-1];
				second = arr[i+1];
			}
			else if (i == arr.length - 1)
			{
				first = arr[i-1];
				second = arr[0];
			}
			else
			{
				first = arr[i-1];
				second = arr[i+1];
			}

			if(first < 0 != second < 0)
				count++;
		}

		return count;
	}

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		do {
			System.out.print("Введіть розмір масиву: ");
			n = in.nextInt();
			if(n < 1)
				System.out.println("Розмір не може бути меньше за 1!");
		}
		while (n < 1);
		int[] arr = new int[n];
		System.out.println("Введіть елементи масиву:");
		Input(arr);

		System.out.println("Масив: ");
		Output(arr);

		System.out.println("Кількість сусідств з різними знаками: " + Fn(arr));

    }
}
