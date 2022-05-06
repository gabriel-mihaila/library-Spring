# library-Spring
## Despre proiect
Proiectul reprezinta o biblioteca online unde clientii pot imprumuta diferite carti. Concret, baza relationala este impartita in 4, astfel:
- tabela Client (caracterizata prin id, nume, adresa, email si varsta)
- tabela Book (caracterizata prin id, nume, autor, categorie, cantitate)
- tabela Category (caracterizata prin id si nume)
- tabela Borrow (face legatura intre client si carti, fiind caracterizata prin id, id_client, id_carte si cantitatea de carti imprumutata)

## Baza de date
![image](https://user-images.githubusercontent.com/72153726/158917259-e268acef-23d1-4612-8538-085907cec80f.png)

## Diagrama UML
![image](https://user-images.githubusercontent.com/72153726/167049127-4d03f756-c6bd-49ad-ba81-38395d349e0c.png)

## Functionalitati (exemple)
Functionalitatile implementate pana acum sunt operatiile de insert, update, delete, precum si getAll pentru fiecare tabela in parte.

  ### getAll (GET)
  ![image](https://user-images.githubusercontent.com/72153726/158917461-89d1137a-f84b-40c1-93d8-998b166ddf87.png)
  
  ### insert (POST)
  ![image](https://user-images.githubusercontent.com/72153726/158917582-a4a60c74-2c9c-47d4-a322-8ae0689b270f.png)
  
  De asemenea, inainte de a introduce un nou client, am verificat daca adresa pe care a atribuit-o exista sau nu in baza de date.
  
  ![image](https://user-images.githubusercontent.com/72153726/158917817-741e5d81-712b-43e5-a62f-c2cc0232c9d2.png)
  
  Atunci cand introduc un nou imprumut, ma asigur intai daca cantitatea imprumutata este mai mica decat cantitatea existatenta a cartii. Daca acest fapr este respectat, pe langa faptul ca am inserat noul imrpumut, voi actualiza si noua cantitate ramasa de carti.

  ### delete (DELETE)
  ![image](https://user-images.githubusercontent.com/72153726/158918030-0b09588f-cc1c-439d-90d3-464856201cb6.png)

  Inainte de a sterge o carte, ma asigur ca aceasta exista in baza de date.
  
  ![image](https://user-images.githubusercontent.com/72153726/158918118-0a1e685c-bbc4-4d57-a07e-0fabc2996bfc.png)

  Dupa ce ma asigur ca respectivul imprumut exista in baza de date, voi restitui cantitatea imprumutata inapoi cartii respective (ca si cum clientul a restituit cartile inapoi la biblioteca).
  
  ### update (PUT)
  ![image](https://user-images.githubusercontent.com/72153726/158918296-e89bd0e3-7610-4d72-b9c5-12764694062a.png)

  Inainte de a actualiza numele categoriei, ma asigur ca aceasta exista in baza de date. Daca exista, voi modifica numele doar daca acesta nu e null si este diferit fata de numele curent.
