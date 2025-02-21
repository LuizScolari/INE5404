package DS3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
    
/**
 Classe que representa uma categoria de produtos.
 Cada categoria pode conter subcategorias e uma lista de produtos associados.
 */
public class Categoria implements Serializable {
	/**
	 Carrega uma hierarquia de categorias de um arquivo texto.

	 @param fileName O nome do arquivo onde a hierarquia foi salva.

	 @return A categoria raiz carregada do arquivo.

	 @throws IOException Em caso de erro ao ler o arquivo.

	 <p>
	 Este método utiliza um BufferedReader, Scanner ou outra classe para ler os dados do arquivo texto (alem de Paths, Path, Files)
	 O arquivo deve ter sido salvo usando o método {@link #salvarCategoria(Categoria, String)}, que deve ter salvo na
	 estrutura, esperada, que é:
	 - Linha de categoria: "CATEGORIA;nivel;nomeCategoria"
	 - Linha de produto: "PRODUTO;atributosCSVDoProduto"

	 O "nivel" da categoria raiz é 0. O nível de suas subcategorias é 1, e assim por diante.
	 Com o nível de cada categoria é possível reconstruir a árvore de categorias.
	 </p>
	 */
	public static Categoria carregarCategoria(String fileName) throws IOException {
            
            try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                Stack<Categoria> pilhaCategorias = new Stack<>();
                Stack<Integer> pilhaNiveis = new Stack<>();
                Categoria raiz = null;
                
                while(reader.ready()){
                    String[] partes = reader.readLine().split(";");
                    if(partes[0].equals("CATEGORIA")){
                        Categoria novaCategoria = new Categoria(partes[2].trim());
                        int nivel = Integer.parseInt(partes[1].trim());
                        if(raiz == null) raiz = novaCategoria;
                        else{
                            while(!pilhaNiveis.isEmpty() && pilhaNiveis.peek()>=nivel){
                                pilhaCategorias.pop();
                                pilhaNiveis.pop();
                            }
                            pilhaCategorias.peek().adicionarSubcategoria(novaCategoria);
                        }
                        pilhaCategorias.push(novaCategoria);
                        pilhaNiveis.push(nivel);
                    } else if(partes[0].equals("PRODUTO")){
                        pilhaCategorias.peek().adicionarProduto(Produto.carregarProduto(String.join(";", partes)));
                    }
                }               
                return raiz;
            }
	}

	/**
	 Desserializa uma instância de Categoria a partir de um arquivo, reconstruindo
	 toda a hierarquia de subcategorias e produtos associados.

	 @param fileName O caminho do arquivo de onde a categoria será carregada.

	 @return Uma instância de Categoria reconstruída a partir do arquivo.

	 @throws IOException            Caso ocorra algum problema durante a operação de leitura no arquivo.
	 @throws ClassNotFoundException Caso a classe Categoria ou qualquer uma das suas dependências
	                                não seja encontrada durante a desserialização.

	 <p>
	 Este método lê uma hierarquia completa de categorias e produtos de um arquivo previamente
	 salvo por meio de serialização. Ele garante:
	 <ul>
	 <li>A recriação da estrutura completa de subcategorias.</li>
	 <li>A manutenção dos produtos em suas respectivas categorias.</li>
	 </ul>
	 Para isso, o método:
	 <ul>
	 <li>Utiliza um {@link FileInputStream} para abrir o arquivo de entrada.</li>
	 <li>Cria um {@link ObjectInputStream} para ler o objeto da categoria principal.</li>
	 <li>Retorna a instância desserializada, que inclui todas as dependências (produtos e subcategorias).</li>
	 </ul>
	 A desserialização requer que todas as classes envolvidas (como Categoria e Produto)
	 implementem a interface {@link java.io.Serializable}.
	 </p>
	 */
	public static Categoria carregarObjetoCategoria(String fileName) throws IOException, ClassNotFoundException {

            try(FileInputStream file = new FileInputStream(fileName);
                    ObjectInputStream input = new ObjectInputStream(file)){
                        return(Categoria) input.readObject();
            }
	}

	/**
	 Salva a hierarquia de uma categoria em um arquivo texto.
	 Cada categoria é salva com seus produtos e subcategorias.

	 @param categoria A categoria raiz a ser salva.
	 @param fileName  O nome do arquivo onde a categoria será salva.

	 @throws IOException Em caso de erro ao gravar no arquivo.

	 <p>
	 Este método utiliza um BufferedWriter ou Formatter ou outra classe para gravar os dados no arquivo texto
	 (alem das classes usuais Paths, Path).
	 A estrutura salva deve segir o formato:
	 - Linha de categoria: "CATEGORIA;nivel;nomeCategoria"
	 - Linha de produto: "PRODUTO;atributosCSVDoProduto"

	 O "nivel" da categoria raiz é 0. O nível de suas subcategorias é 1, e assim por diante.
	 Com o nível de cada categoria é possível reconstruir a árvore de categorias.

	 Uma forma recomendada de implementar esse método é de forma recursiva, invocando o método
	 {@link salvarCategoriaRecursivo} a partir do nível 0 de categoria.
	 </p>
	 */
	public static void salvarCategoria(Categoria categoria, String fileName) throws IOException {
        /*
         * IMPLEMENTE
         */
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                salvarCategoriaRecursivo(categoria, writer,0);
            }
	}

	/**
	 Serializa uma instância de Categoria, incluindo toda a hierarquia de subcategorias
	 e produtos associados, para um arquivo.

	 @param categoria A instância de Categoria a ser salva.
	 @param fileName  O caminho do arquivo onde a categoria será serializada.

	 @throws IOException Caso ocorra algum problema durante a operação de escrita no arquivo.

	 <p>
	 Este método salva toda a hierarquia de uma categoria no disco, preservando:
	 <ul>
	 <li>Os produtos pertencentes à categoria principal.</li>
	 <li>Todas as subcategorias e seus respectivos produtos, de forma recursiva.</li>
	 </ul>
	 Para isso, o método:
	 <ul>
	 <li>Utiliza um {@link FileOutputStream} para criar um fluxo de saída para o arquivo.</li>
	 <li>Cria um {@link ObjectOutputStream} para escrever a instância da categoria
	 e toda a sua estrutura.</li>
	 <li>Escreve o objeto da categoria principal no arquivo, serializando também
	 todas as dependências (produtos e subcategorias).</li>
	 </ul>
	 A serialização requer que todas as classes envolvidas (como Categoria e Produto)
	 implementem a interface {@link java.io.Serializable}.
	 </p>
	 */
	public static void salvarObjetoCategoria(Categoria categoria, String fileName) throws IOException {
        /*
         * IMPLEMENTE
         */
            try(FileOutputStream file = new FileOutputStream(fileName);
                    ObjectOutputStream out = new ObjectOutputStream(file)){
                        out.writeObject(categoria);
            }
	}

	/**
	 Método auxiliar para salvar categorias e subcategorias recursivamente.

	 @param categoria A categoria atual sendo salva.
	 @param writer    O BufferedWriter usado para gravar no arquivo.
	 @param nivel     O nível hierárquico da categoria atual.

	 @throws IOException Em caso de erro ao gravar no arquivo.
	 */
	private static void salvarCategoriaRecursivo(Categoria categoria, BufferedWriter writer, int nivel) throws IOException {

            writer.write("CATEGORIA;" + nivel + ";" + categoria.getNome());
            writer.newLine();
            for(Produto produto : categoria.getProdutos()){
                writer.write(produto.salvarProduto());
                writer.newLine();
            }
            for(Categoria subcategoria : categoria.getSubcategorias()){
                salvarCategoriaRecursivo(subcategoria,writer,nivel+1);
            }
	}

	public Categoria(String nome) {
		this.nome = nome;
		this.subcategorias = new ArrayList<>();
		this.produtos = new ArrayList<>();
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public void adicionarSubcategoria(Categoria subcategoria) {
		subcategorias.add(subcategoria);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Categoria)) {
			return false;
		}
		Categoria categoria = (Categoria) o;
		return Objects.equals(nome, categoria.nome)
				&& Objects.equals(subcategorias, categoria.subcategorias)
				&& Objects.equals(produtos, categoria.produtos);
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	@Override
	public int hashCode() { // sobreposto por causa do metodo equals()
		return Objects.hash(nome, subcategorias, produtos);
	}

	@Override
	public String toString() {
		return "Categoria{"
				+ "nome='" + nome + '\''
				+ ", subcategorias=" + subcategorias
				+ ", produtos=" + produtos
				+ '}';
	}

	private String nome;
	private List<Produto> produtos;
	private List<Categoria> subcategorias;
}
