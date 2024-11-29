package br.com.rmcs.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}

@RestController()
@RequestMapping("api")
class TestController {
	@GetMapping()
	public String getMethodName(@RequestParam String name) {
		return "Hello " + name;
	}

	@GetMapping("aluno")
	public String getAluno() {
		return Aluno.builder().ra("123").nome("Fulano").build().toString();
	}
	
}
