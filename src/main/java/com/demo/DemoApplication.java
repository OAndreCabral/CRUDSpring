package com.demo;

import com.demo.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Produto produto = new Produto();

		List<Produto> listaProduto = new ArrayList<>();

		for (int i = 0; i <= 9; i++) {
			produto = new Produto();
			produto.setCodigo(Long.valueOf(1 + i));
			produto.setDescricao("teste " + i);
			produto.setValor(29.90 + i);
			listaProduto.add(produto);
		}

		/*for 0*/
		for (Produto produtos : listaProduto) {
			if (produtos != null) {
				System.out.println(produtos.getDescricao());
			}
		}
	}
}
