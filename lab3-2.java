import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void Random(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            Random random = new Random();
            arr[i] = random.nextInt(100 - (-100)) + (-100);
        }
    }

    public static void Input(int[] arr)
    {
        System.out.println("\nВведіть елементи:");
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

    public  static int MaxI(int[] arr)
    {
        int max_i = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[i] > arr[max_i])
                max_i = i;

        return max_i+1;
    }

    public static int FirstZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) return i;
        }
        return -1;
    }

    public static int LastZero(int[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] == 0) return i;
        }
        return -1;
    }

    public static int Fn(int[] arr, int first, int last) throws Exception {
        if(first == -1 || last == -1) throw new Exception("Немає нульових елементів!");
        else if(first == last ) throw new Exception("В масиві лише один нульовий елемент!");
        else if(first == last-1 ) throw new Exception("Між першим і останнім нульовими елементами немає інших елементів!");

        int sum = 0;
        for (int i = first+1; i < last; i++) {
            sum+=Math.abs(arr[i]);
        }
        return sum;
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
		char inputted;
        do
        {
            System.out.println("Оберіть метод заповнення масиву:");
            System.out.println("1 — ввід елементів з клавіатури");
            System.out.println("2 — рандомайзер.");
            System.out.print("Метод: ");
            inputted = in.next().charAt(0);

            switch (inputted) {
                case '1' -> Input(arr);
                case '2' -> Random(arr);
                default -> System.out.println("Повторіть ввід даних");
            }
            System.out.println();
        } while (inputted != '1' && inputted != '2');

        System.out.println("Масив: ");
        Output(arr);
		
		System.out.println("Номер максимального елемента масиву: " + MaxI(arr));
		
		try
		{
			System.out.println("Сума модулів елементів масиву, розташованих між першим й останнім нульовими елементами: " + Fn(arr, FirstZero(arr), LastZero(arr)));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
    }
}