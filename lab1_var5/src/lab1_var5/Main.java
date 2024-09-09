package lab1_var5;

import java.util.Scanner;

public class Main {
	static double newton_method(int num, double start, double precision, int iter_limit) {
		long m = System.currentTimeMillis();
		boolean success = false; 
		double alg_step = start;
		for (int i = 0; i < iter_limit; i++) {
			alg_step = (alg_step + num/alg_step)/2;
			if (Math.abs((Math.pow(alg_step, 2)/num - 1)) * 100 < precision) {
				success = true;
				break;
			}
		}
		if (success) {
			return (double) (System.currentTimeMillis() - m);
		}else {
			return 0;
		}
		
	}
	
	static double include_method(int num) {
		long m = System.currentTimeMillis();
		Math.sqrt(num);
		return (double) (System.currentTimeMillis() - m);
	}
	
	static void model() {
			
	}
	
	static <T> void view(T key) {
		System.out.println(key.toString());
	}
	
	static void controller() {
		Scanner sc = new Scanner(System.in);
        int i = 2;
        view("Введите целое число: ");
        if(sc.hasNextInt()) { 
          i = sc.nextInt(); 
          System.out.println(i*2);
        } else {
          view("Вы ввели не целое число");
        }
	}

	public static void main(String[] args) {
		controller();
	}

}
