package br.com.desafios;

import java.io.IOException;
import java.util.Scanner;

public class DiffArray {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		int n;
		int i;
		int[] lista;
		int max;
		int exemplo1[] = {7, 2, 3, 10, 2, 4, 8, 1};
		int exemplo2[] = {6, 7, 9, 5, 6, 3, 2};
				
		i = 0;
		n=0;
		max=0;
		
	
		lista = exemplo1; 
		System.out.println("Lista exemplo: ");
		for (i=1;i<lista.length-1;i++) {
			System.out.println(lista[i]+", ");
		}
		max = maxDifference(lista);
		System.out.printf("A maior diferença entre todos os numeros da lista é: " + max);
	}

	
	static int maxDifference(int[] a) {
		int max;
		int n;
		int i = 1;
		int j;
		int dif;

		max = -1;
		n = a[0];//a.length;

		for (j = i + 1; j < n; j++) {
			for (i = 1; i < j; i++) {

				if ((a[j] > a[i]) && (max < (a[j] - a[i]))) {
					dif = a[j] - a[i];
					System.out.printf(a[j] + "-" + a[i] + "=" + dif + ";");
					max = dif;
				}

			}
		}

		return max;
	}

}
