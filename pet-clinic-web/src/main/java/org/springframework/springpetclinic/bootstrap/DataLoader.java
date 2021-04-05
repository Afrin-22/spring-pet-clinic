package org.springframework.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.springpetclinic.model.Owner;
import org.springframework.springpetclinic.model.Pet;
import org.springframework.springpetclinic.model.PetType;
import org.springframework.springpetclinic.model.Speciality;
import org.springframework.springpetclinic.model.Vet;
import org.springframework.springpetclinic.model.Visit;
import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.springpetclinic.services.PetTypeService;
import org.springframework.springpetclinic.services.SpecialityService;
import org.springframework.springpetclinic.services.VetService;
import org.springframework.springpetclinic.services.VisitService;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, 
			SpecialityService specialityService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}



	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		
		if(count == 0)
			loadData();
	}



	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Eren");
		owner1.setLastName("Jeager");
		owner1.setAddress("123 Shiganshina");
		owner1.setCity("Tokyo");
		owner1.setTelephone("3124214235");
		
		Pet erensPet = new Pet();
		erensPet.setName("Shiba");
		erensPet.setOwner(owner1);
		erensPet.setBirthDate(LocalDate.now());
		erensPet.setPetType(savedDogPetType);
		
		owner1.getPets().add(erensPet);		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Levi");
		owner2.setLastName("Ackerman");
		owner2.setAddress("456 Amegakure");
		owner2.setCity("Osaka");
		owner2.setTelephone("3124214235");
		
		Pet levisPet = new Pet();
		levisPet.setName("KawaiiNeko");
		levisPet.setOwner(owner2);
		levisPet.setBirthDate(LocalDate.now());
		levisPet.setPetType(savedCatPetType);
		
		owner2.getPets().add(levisPet);				
		ownerService.save(owner2);
		
		System.out.println("Loaded owner...");

		Visit catVisit = new Visit();
		catVisit.setPet(levisPet);
		catVisit.setLocalDate(LocalDate.now());
		catVisit.setDescription("Sneezy kitty");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded visit...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Erwin");
		vet1.setLastName("Daijo");
		vet1.getSpecialities().add(savedSurgery);
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
			
		Vet vet2 = new Vet();
		vet2.setFirstName("Mikasa");
		vet2.setLastName("Ackerman");
		vet2.getSpecialities().add(savedDentistry);

		vetService.save(vet2);
		
		System.out.println("Loaded vets...");
	}

}
