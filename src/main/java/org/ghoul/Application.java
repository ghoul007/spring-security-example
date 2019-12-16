package org.ghoul;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.ghoul.dao.EtudiantRepository;
import org.ghoul.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
 
 
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("Hardy","Jeff",df.parse("1990-11-12")));
		etudiantRepository.save(new Etudiant("Cena","John",df.parse("1990-11-12")));
		etudiantRepository.save(new Etudiant("Ronaldo","Chris",df.parse("1990-11-12")));
		etudiantRepository.save(new Etudiant("Allen","Barry",df.parse("1990-11-12")));
		etudiantRepository.save(new Etudiant("Queen","Oliver",df.parse("1990-11-12")));

		List<Etudiant> etds=etudiantRepository.findAll();
		etds.forEach(e -> System.out.println(e.getNom()));
	 
	}

}
