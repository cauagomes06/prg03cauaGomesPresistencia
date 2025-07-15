package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Prg03springApplication {

	public static void main(String[] args) {
   
        ConfigurableApplicationContext context = 
                new SpringApplicationBuilder(Prg03springApplication.class).headless(false).run(args);


                CursoListar telacursosListar = context.getBean(CursoListar.class);
                telacursosListar.setVisible(true);

        }
}
