package Visao;

import Modelo.Usuario;
import Util.JPAUtil;
import Util.UsuarioDAO;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

public class TesteUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = JPAUtil.getEntityManager();
        // Solicitar informações do usuário
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite a data de nascimento (no formato YYYY-MM-DD):");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

        System.out.println("Digite o sexo (M/F):");
        char sexo = scanner.nextLine().charAt(0);

        System.out.println("Digite o logradouro:");
        String logradouro = scanner.nextLine();

        System.out.println("Digite o número:");
        int numero = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o setor:");
        String setor = scanner.nextLine();

        System.out.println("Digite a cidade:");
        String cidade = scanner.nextLine();

        System.out.println("Digite o UF (Estado, ex: SP):");
        String uf = scanner.nextLine();

        // Criar instância de Usuario com as informações fornecidas
        Usuario novoUsuario = new Usuario(nome, dataNascimento, sexo, logradouro, numero, setor, cidade, uf);

        // Exibir os detalhes do novo usuário
        System.out.println("\nNovo usuário criado:");
        System.out.println("Nome: " + novoUsuario.getNome());
        System.out.println("Data de Nascimento: " + novoUsuario.getData_nascimento());
        System.out.println("Sexo: " + novoUsuario.getSexo());
        System.out.println("Logradouro: " + novoUsuario.getLogradouro());
        System.out.println("Número: " + novoUsuario.getNumero());
        System.out.println("Setor: " + novoUsuario.getSetor());
        System.out.println("Cidade: " + novoUsuario.getCidade());
        System.out.println("UF: " + novoUsuario.getUf());

        // Fechar o scanner
        scanner.close();

        UsuarioDAO udao = new UsuarioDAO(em);

        em.getTransaction().begin();
        udao.incluir(novoUsuario);
        em.getTransaction().commit();


        em.close();
    }
}