package com.reenprogram;
public class Task2 {
	public static void main(String args[]) {
		for (int i = 4; i >= 1; i--) {
			for (int j = 1; j <= 4; j++) {
				if (i == j) {
					System.out.print("* ");
				} else {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}
