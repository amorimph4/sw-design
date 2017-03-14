package impacta.com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

public class Agenda {

	private static Scanner entrada = new Scanner(System.in);
	private static List<Contato> contatos = new ArrayList<>();
	public static void main (String[]arg){
		boolean sair = false;
		while(!sair){
			int opcao= apresentarMenuPrincipal();
			switch (opcao) {
			case 1: inserirContato(); break;
			case 2: buscarContato();  break;
			case 3: sair = true; break;
			
			default: out.println("erro: opcao invalida ");
				
			}
		}
		
		out.println("\n Fim de programa");	
	}
	private static int apresentarMenuPrincipal() {
		
		boolean  inteiro  = false ;
		int opcao = 0 ;
		while (!inteiro){
			
			out.println("\nAgenda telefonica ");
			out.println("(1) Inserir");
			out.println("(2)buscar ");
			out.println("(3)sair ");
			out.println("Escolha uma opçao ");
			String s = entrada.nextLine(); 
			try{
				opcao = Integer.parseInt(s);
				inteiro = true;
			}catch(Exception e){
				out.println("ERRO: opção deve ser um valor inteiro");
			}
			
		}return opcao;
		
		
	}
	private static void inserirContato(){
		out.println("\nINSERÇÃO DE NOVO CONTATO");
		String nome = lernome();
		String telefone = lertelefone();
		Contato c = new Contato (nome, telefone);
		if(contatos.contains(c)){
			out.println("Contato ja existe na agenda");
		}else{
			contatos.add(c);
			out.println("contato inserido!");
		}
	}
	private static String lernome(){
		boolean valido = false;
		String nome = "";
		while(!valido){
			out.println("Nome: ");
			nome = entrada.nextLine();
			if(nome.length()==0 || nome.length()>200){
				out.print("ERRO: nome de tamanho invalido");
			}else{valido = true;}
		}
		return nome;
	}
	private static String lertelefone(){
		boolean valido = false;
		String telefone = "";
		while(!valido){
			out.println("Telefone: ");
			telefone = entrada.nextLine();
			if(telefone.length()==0 || telefone.length()>25){
				out.println("ERRO: telefone de tamanho invalido!");
			} else{valido = true;}
		}return telefone;
	}
	private static void buscarContato(){
		out.println("\nBUSCA DE CONTATOS");
		String nome = lernome();
		List<Contato> resultado = new ArrayList<>();
		for(Contato c: contatos){
			if(nome.equals(c.getNome())){
				resultado.add(c);
			}
		}
		if(resultado.size()==0){
			out.println("\nResultado da busca: ");
		}else{
			out.println("\nResultado da busca: ");
			for (Contato c : resultado){
				out.println(c);
			}
		}
	}

}

