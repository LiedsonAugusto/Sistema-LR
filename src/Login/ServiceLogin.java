package Login;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class de serviços que se comunica unicamente com o Repository de Contas, essa class presta serviços tanto para 
 * administrador quanto para funcionário e não é responsabilidade dessa class separar ações por funções.
 * 
 * Essa é a única class que não presta serviço de criação de objetos pois a mesma envia para o repository 
 * os dados criptografados, pois nesse caso estamos simulando uma situação de comunicação local/servidor.
 * 
 * Sobre a criptografia, a class possui um método privado que "quebra" todos os dados de String, dados esses que 
 * transitam entre classes. ( A escolha de fazer a criptografia manualmente foi proposital, sabemos que existem 
 * formas profissionais de criptografia, mas optamos pela experiência de criar nossa propria criptografia. )
 * 
 * @author Joseff
 *
 */
public class ServiceLogin {

    private RepositoryContas repositoryContas;
    
    /**
     * Construtor da class que recebe um Repository criado pelo inicializador.
     * O objetivo é, ao finalizar os estudos de banco de dados, utilizar o construtor
     * para 'alimentar' os repositorios que serão zerados toda vez que o aplicativo
     * iniciar (obviamente dependendo do tamanho do banco de dados), pois a busca em
     * HashMaps foi escolhida como padrão.
     * 
     * @param repositoryContas | Objeto criado no inicializador e deve vir com alguns
     * usuários padrão para teste e um SuperUser que ainda será implementado.
     */
    public ServiceLogin(RepositoryContas repositoryContas) {
    	this.repositoryContas = repositoryContas;
    }

    /**
     * @author Joseff
     * 
     * Consultar no repository se existe um par de ID|Senha 
     * permitindo ou não o login do Funcionário.
     * 
     * @param ID | Código de identificação do Funcionário.
     * @param senha | Senha que deve estar contido no Funcionário
     * @return Boolean que sinaliza se o usuário possue essa senha ou não, validando assim 
     * o acesso ao sistema.
     */
    public boolean validaLoginFuncionario(String ID, String senha) {
    	return this.repositoryContas.contemFuncionario(ID, quebrar(senha));
    }
    
    /**
     * @author Joseff
     * 
     * Consulta no repository se existe um par de ID|Senha 
     * permitindo ou não o login do Administrador.
     * 
     * @param ID | Código de identificação do Administrador
     * @param senha | Senha que deve estar contido no Administrador
     * @return Boolean que sinaliza se o usuário possue essa senha ou não, validando assim 
     * o acesso ao sistema.
     */
    public boolean validaLoginAdm(String ID, String senha) {
    	return this.repositoryContas.contemAdministrador(ID, quebrar(senha));
    }

    /**
     * @author Joseff
     * 
     * Solicita para o repository que crie e armazene um novo
     * Funcionário em seu banco de dados.
     * 
     * @param idFuncionario | Código de identificação de um novo Funcionário.
     * @param senha | Senha que será associada ao funcionário e utilizada no
     * momento do login.
     * @param nome | Nome do usuário.
     */
    public void adicionaFuncionario(String idFuncionario, String senha, String nome){
    	this.repositoryContas.putFuncionario(idFuncionario, quebrar(senha), nome);
    }

    /**
     * @author Joseff
     * 
     * Solicita ao repository que remova um determinado funcionário, caso exista.
     * 
     * @param idFuncionario | Código do funcionário que será removido.
     */
    public void removeFuncionario(String idFuncionario) {
    	this.repositoryContas.removeFuncionario(idFuncionario);
    }

    /**
     * @author Joseff
     * 
     * Solicita para o repository que crie e armazene um novo
     * Administrador em seu banco de dados.
     * 
     * @param ID | Código de identificação de um novo Administrador.
     * @param senha | Senha que será associada ao Administrador e utilizada no
     * momento do login.
     * @param nome | Nome do Administrador.
     */
    public void adicionaADM(String ID, String senha, String nome) {
    	this.repositoryContas.putAdministrador(ID, quebrar(senha), nome);
    }

    /**
     * @author Joseff
     * 
     * Esse processo só deve ser efetuado por um SuperUsuário
     * Solicita para o repository a remoção de um Administrador específico.
     * 
     * @param ID | Código de identificação do Administrador.
     */
    public void removeADM(String ID) {
    	this.repositoryContas.removeADM(ID);
    }
    
    /**
     * @author Joseff
     * 
     * Solicita ao repository todas as chaves dos Funcionários
     * armazenados no sistema. ( Método normalmente utilizado em validadores
     * ou coisas do tipo )
     * 
     * @return Set de Strings com todas as chaves de Funcionários já armazenadas.
     */
    public Set<String> getChavesFuncionario() {
    	return this.repositoryContas.getChaveFuncionario();
    }
    
    /**
     * @author Joseff
     * 
     * Solicita ao repository todas as chaves dos Administradores
     * armazenados no sistema. ( // )
     * 
     * @return Set de Strings com todas as chaves de Administradores já armazenadas.
     */
    public Set<String> getChavesADM() {
    	return this.repositoryContas.getChaveADM();
    }

    // Método deve ser detalhado, Documentação barrada.
	public void alteraSenhaFuncionario(String ID, String novaSenha) {
		this.repositoryContas.alteraSenhaFuncionario(ID, quebrar(novaSenha));
	}
	// Método deve ser detalhado, Documentação barrada.
	public void alteraSenhaAdminstrador(String ID, String novaSenha) {
		this.repositoryContas.alteraSenhaAdminsitrador(ID, quebrar(novaSenha));
	}

	/**
	 * @author Joseff
	 * 
	 * Chave importante para a comunicação service/repository, pois é ela
	 * a responsavel por quebrar todos os dados importantes que vão transitar 
	 * via "rede" ( simulação até agora, no nosso caso )
	 * 
	 * Classe utilizada inicialmente para quebrar senha, por isso do param
	 * senha, entretanto pode ser utilizada para qualquer quebra de String 
	 * dentro da class.
	 * 
	 * @param senha | String que deseja quebrar.
	 * @return String criptografada que contém as instruções de como montar.
	 */
	private String quebrar(String senha) {
		String[] grupoSoma7  = {"q", "e", "t", "u", "o", "l"};
		String[] grupoSoma12 = {"w", "r", "y", "i", "p", "k"};
		String[] grupoSoma20 = {"j", "g", "d", "a", "x", "v", "n"};
		String[] grupoSoma9  = {"h", "f", "s", "z", "c", "b", "m"};
		String[] alfabeto = {"w", "r", "y", "i", "p", "k", "h", "f", "s", "z", "c", "b", "m", "q", "e", "t", "u", "o", "l", "j", "g", "d", "a", "x", "v", "n"};
		HashSet<String> setSoma7 = new HashSet<>();
		HashSet<String> setSoma12 = new HashSet<>();
		HashSet<String> setSoma20 = new HashSet<>();
		HashSet<String> setSoma9 = new HashSet<>();
		Random gerador = new Random();
		
		for (String letra : grupoSoma7) {
			setSoma7.add(letra);
		}
		for (String letra : grupoSoma12) {
			setSoma12.add(letra);
		}
		for (String letra : grupoSoma20) {
			setSoma20.add(letra);
		}
		for (String letra : grupoSoma9) {
			setSoma9.add(letra);
		}
		
		String senhaInvertida = "";
		String retorno = "";
		int soma;
		char[] letras = senha.toCharArray();
		for (int i = letras.length - 1; i > -1 ; i--) {
			senhaInvertida += letras[i];
		}

		for (char letra : senhaInvertida.toCharArray()) {
			String letraAleatoria = alfabeto[gerador.nextInt(26)];
			if (setSoma7.contains(letraAleatoria)) { 
				soma = 7;
			} else if (setSoma12.contains(letraAleatoria)) {
				soma = 12;
			} else if (setSoma20.contains(letraAleatoria)) {
				soma = 20;
			} else {
				soma = 9;
			}

			String hexadecimal = String.format("%x", ((int) letra + soma));
			retorno += hexadecimal + letraAleatoria;
		}
		return retorno;
	}
	
	public String montar(String criptografia) {
		//TODO Responsável pela criptografia do repository deve implementar o processo reverso.
		return null;
	}
	
}