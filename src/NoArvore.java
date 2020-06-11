
public class NoArvore {
	int			valor;
	NoArvore	direita;
	NoArvore	esquerda;

	public NoArvore busca(NoArvore no, int valorprocurado) {
		if(no == null)
			return null;
		
		if(no.valor > valorprocurado)
			return busca(no.esquerda, valorprocurado);
		else if(no.valor < valorprocurado)
			return busca(no.direita, valorprocurado);
		else
			return no;
	}
	
	public NoArvore insere(NoArvore no, int novovalor) {
		if(no == null) {
			no = new NoArvore();
			no.valor = novovalor;
			no.esquerda = no.direita = null;
		}
		else if(novovalor < no.valor)
			no.esquerda = insere(no.esquerda, novovalor);
		else if(novovalor > no.valor)
			no.direita = insere(no.direita, novovalor);
	
		return no;
	}

	public void imprime(NoArvore raiz) {
		if (raiz != null) {
			imprime(raiz.esquerda);
			System.out.println(raiz.valor);
			imprime(raiz.direita);
		}
	}
	
	public NoArvore remove(NoArvore raiz, int valoraremover) {
		// faz a busca pelo valor a ser removido
		if (raiz == null)
			return null;
		else if (raiz.valor > valoraremover)
			raiz.esquerda = remove(raiz.esquerda, valoraremover);
		else if (raiz.valor < valoraremover)
			raiz.direita = remove(raiz.direita, valoraremover);
		else {	// passar por aqui significa que achou o n� com o
				// valora remover procurado e agora vai remove-lo
				// segundo as 4 situa��es a seguir:
			// N�o ter filhos (esquerda e direita == null)
			if (raiz.esquerda == null && raiz.direita == null) {
				raiz = null;
			}
			// Ter filho apenas � direita (esquerda == null)
			else if (raiz. esquerda == null) {
				raiz = raiz.direita;
			}
			// Ter filho apenas � esquerda (direita == null)
			else if (raiz.direita == null) {
				raiz = raiz.esquerda;
			}
			// Ter dois filhos (esquerda e direita != null)
			else {

				NoArvore sub_direita = raiz.direita;
				
				while (sub_direita.esquerda != null) {
					sub_direita = sub_direita.esquerda;
				}
				
				raiz.valor = sub_direita.valor;
				sub_direita.valor = valoraremover;
				raiz.direita = remove(raiz.direita, valoraremover);
			}
		}
		return raiz;		
	}
}



