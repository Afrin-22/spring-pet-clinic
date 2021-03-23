package org.springframework.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.petclinicdata.model.Owner;
import org.springframework.petclinicdata.model.Vet;
import org.springframework.petclinicdata.services.OwnerService;
import org.springframework.petclinicdata.services.VetService;
import org.springframework.petclinicdata.services.map.OwnerServiceMap;
import org.springframework.petclinicdata.services.map.VetServiceMap;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Eren");
		owner1.setLastName("Jeager");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Levi");
		owner2.setLastName("Ackerman");
		ownerService.save(owner2);
		
		System.out.println("Loaded owner...");
		
		Vet vet1 = new Vet();
		vet1.setId(2L);
		vet1.setFirstName("Erwin");
		vet1.setLastName("Daijo");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Mikasa");
		vet2.setLastName("Ackerman");
		vetService.save(vet2);
		
		System.out.println("Loaded vets...");
	}

}
