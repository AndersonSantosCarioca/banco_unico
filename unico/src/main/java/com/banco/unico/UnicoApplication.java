package com.banco.unico;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banco.unico.entities.Cliente;
import com.banco.unico.entities.Endereco;

@SpringBootApplication
public class UnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnicoApplication.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.println("Seu nome:");
		String nome = sc.nextLine();

		System.out.println("Qual seu cep?");
		String cep = sc.nextLine();

		Endereco endereco = Endereco.getEnderecoByCep(cep);

		System.out.println("Rua: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Cidade: " + endereco.getLocalidade());
		System.out.println("Estado: " + endereco.getUf());

		System.out.println("Número: ");
		String numero = sc.nextLine();
		endereco.setNumero(numero);

		System.out.println("Complemento: ");
		String complemento = sc.nextLine();
		endereco.setComplemento(complemento);

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEndereco(endereco);

		System.out.println(cliente);

		sc.close();

	}

}
