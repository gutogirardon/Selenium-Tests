package utils;

import java.util.Random;

public class Geradores {

	private static Random rand = new Random();
	private static char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray();
	private static char[] numeros = "1234567890".toCharArray();

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));
		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		return primDig.toString() + segDig.toString();
	}

	public static String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + calcDigVerif(iniciais);
	}

	public static boolean validaCPF(String cpf) {
		if (cpf.length() != 11)
			return false;
		String numDig = cpf.substring(0, 9);
		return calcDigVerif(numDig).equals(cpf.substring(9, 11));
	}
	
	/*
	 * Gerar o nome com x caracteres
	 */
	public static String nomeAleatorio (int nCaracteres) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < nCaracteres; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras [ch]);
	    }    
	    return sb.toString();    
	}
	
	/*
	 * Gera x numeros aleatorios para teste de capacidade de campo
	 */
	public static String numerosAleatorios (int nCaracteres) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < nCaracteres; i++) {
	        int ch = rand.nextInt (numeros.length);
	        sb.append (numeros [ch]);
	    }    
	    return sb.toString();    
	}

	public static void main(String args[]) {
		System.out.println(geraCPF());
		System.out.println(validaCPF(geraCPF()));
		System.out.println(nomeAleatorio(100));
	}
}
