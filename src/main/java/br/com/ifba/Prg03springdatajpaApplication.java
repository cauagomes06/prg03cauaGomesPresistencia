package br.com.ifba;

import br.com.ifba.curso.view.CursoListar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Prg03springdatajpaApplication {


	public static void main(String[] args) {
   
        ConfigurableApplicationContext context = 
                new SpringApplicationBuilder(Prg03springdatajpaApplication.class).headless(false).run(args);


                CursoListar telacursosListar = context.getBean(CursoListar.class);
                telacursosListar.setVisible(true);

        }

}
