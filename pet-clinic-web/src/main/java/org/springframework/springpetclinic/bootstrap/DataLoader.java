package org.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.PetType;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Eren");
		owner1.setLastName("Jeager");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Levi");
		owner2.setLastName("Ackerman");
		ownerService.save(owner2);
		
		System.out.println("Loaded owner...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Erwin");
		vet1.setLastName("Daijo");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Mikasa");
		vet2.setLastName("Ackerman");
		vetService.save(vet2);
		
		System.out.println("Loaded vets...");
	}

}
