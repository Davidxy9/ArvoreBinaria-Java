import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int noRecebe;
		
		
		NoArvore abb = new NoArvore();
		
		
		try {
			
			FileInputStream arquivo = new FileInputStream("arquivo.txt");
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			
			String linha;
			
			do {
				
				linha = br.readLine();
				if (linha != null) {
					
					String[] palavras = linha.split(",");
					
					for (int i = 0; i < palavras.length; i++) {
						
						int numeroConvertido = Integer.parseInt(palavras[i]);
						abb.insere(abb, numeroConvertido);
					}
					
				}
				
			}while (linha != null);
			
			arquivo.close();
			input.close();
			br.close();
			
		} catch (Exception e){
			System.out.println("Erro ao ler");
		}
		

		System.out.println("Digite um numero do nó para procurar:");
		noRecebe = teclado.nextInt();
		
		NoArvore resultado = abb.busca(abb, noRecebe);
		
		if(resultado == null)
			System.out.println("Não encontrei o nó: " +noRecebe);
		else
			System.out.println("Encontrei o nó: "+resultado.valor);
		

		abb.imprime(abb);
		

		System.out.println("Digite o numero do nó para remover");
		noRecebe = teclado.nextInt();
		
		abb.remove(abb, noRecebe);

		abb.imprime(abb);
		
		teclado.close();
	}

}
