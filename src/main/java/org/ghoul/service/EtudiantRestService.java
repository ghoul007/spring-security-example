package org.ghoul.service;

import org.ghoul.dao.EtudiantRepository;
import org.ghoul.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantRestService {
	@Autowired
     private EtudiantRepository etudiantRepository;
	
	@Secured(value={"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value="/saveEtudiant", method= RequestMethod.GET)
	public Etudiant saveEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/etudiants", method= RequestMethod.GET)
	public Page<Etudiant> listEtudiant(int page, int size){
		return etudiantRepository.findAll(new PageRequest(page, size));
	}
}
