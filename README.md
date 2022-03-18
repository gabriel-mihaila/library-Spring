# library-Spring
## Despre proiect
Proiectul reprezinta o biblioteca online unde clientii pot imprumuta diferite carti. Concret, baza relationala este impartita in 4, astfel:
- tabela Client (caracterizata prin id, nume, adresa, email si varsta)
- tabela Book (caracterizata prin id, nume, autor, categorie, cantitate)
- tabela Category (caracterizata prin id si nume)
- tabela Borrow (face legatura intre client si carti, fiind caracterizata prin id, id_client, id_carte si cantitatea de carti imprumutata)

## Baza de date
![image](https://user-images.githubusercontent.com/72153726/158917259-e268acef-23d1-4612-8538-085907cec80f.png)

## Functionalitati
Functionalitatile implementate pana acum sunt operatiile de insert, update, delete, precum si getAll pentru fiecare tabela in parte.

  ### getAll (GET)
  ![image](https://user-images.githubusercontent.com/72153726/158917461-89d1137a-f84b-40c1-93d8-998b166ddf87.png)
  
  ### insert (POST)
  ![image](https://user-images.githubusercontent.com/72153726/158917582-a4a60c74-2c9c-47d4-a322-8ae0689b270f.png)
  
  De asemenea, inainte de a introduce un nou client, am verificat daca adresa pe care a atribuit-o exista sau nu in baza de date.


