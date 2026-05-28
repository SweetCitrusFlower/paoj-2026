Tema: platforma food delivery

Obiecte:
 1. Comanda (Record: Map<Produs, Integer> produseCuCantitate, LocalDateTime dataPlasare, Curier curier, Adresa locatie, AdresaLivrare adresaLivrare)
 2. Produs (Class: String denumire, int pret, CategorieProdus categorie, List<Ingredient> listaIngrediente)
 3. CategorieProdus (Enum: BOL_POKE, SALATA, GARNITURA, DESERT)
 4. Ingredient (Class: String nume, CategorieIngredient categorie, int stoc)
 5. CategorieIngredient(Enum: BAZA, GREEN, PROTEINA, DRESSING, TOPPING, DESERT)
 6. Persoana (Class: String nume, String prenume, String nrTelefon)
 7. Angajat (Class: extends Pesoana; salariu)
 8. Curier (Class: extends Angajat)
 9. Bucatar (Class: extends Angajat)
 10. Client (Class: extends Persoana; CardFidelitate cardFidelitate, List<AdresaLivrare> listaAdreseLivrare, List<Comanda> listaComenzi)
 11. CardFidelitate (Class: int nrProduseIntroduse, List<Reducere> listaReduceri)
 12. Reducere (Class: Function<Comanda, Comanda> functieAplicareReducere, String descriere)
 13. Adresa (Class: String numeStrada, int nrStrada, int codPostal)
 14. AdresaLivrare (Class: extends Adresa; int nrApartament)
 15. Adresa (Class: extends Adresa; List<Angajat> listaAngajati)
 
 Servicii:
 1. ServiciuPrincipal
	- logare client
	- logare admin
	--- iesire din aplicatie

 2. ServiciuClient
	- plasare comanda
	- afisare produse:  cel putin una din categoriile BOL_POKE, SALATA, GARNITURA, DESERT; 
						sortare dupa pret / alfabetic / dupa popularitate
						toate produsele / doar cele disponibile
	- verificare card de fidelitate
	- adaugare adresa livrare
	- stergere adresa livrare
	- afisare istoric comenzi
	--- delogare

 3. ServiciuAdmin
	- adaugare ingredient
	- adaugare produs
	- adaugare angajat
	- afisare toate ingredientele
	- afisare toate produsele
	- afisare toti angajatii
	- afisare toti clientii
	--- delogare