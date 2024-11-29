package br.com.rmcsa.restdemoh2;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;

@SpringBootApplication
public class Restdemoh2Application {

	public static void main(String[] args) {
		SpringApplication.run(Restdemoh2Application.class, args);
	}

}

@Data
@Builder
class Demo{
	Long id;
	String description;  

}

@RestController()
@RequestMapping("/demo")
class DemoController {
	DemoService demoService = new DemoService();

	@GetMapping("/{id}")
	public Demo getDemo(@PathVariable("id") Long id) {
		return demoService.getDemo(id).orElse(null);
	}
}

@Service
class DemoService{
	DemoRepository demoRepository = new DemoRepository();

	public Optional<Demo> getDemo(Long id) {
		return demoRepository.findById(id);
	}

}

class DemoRepository extends JpaRespository<Demo, Long>{
	
}
