Nazdravan Georgiana Alexandra 324CB

In primul rand, citesc input-uri din fisier, si-mi creez listele cu brokeri,
        clienti, produse, licitatii totale posibile si adaug si admin-ul.
Sistem de licitatie + FIRE DE EXECUTIE:
        Se citesc din fisierul de comenzi o licitatie, care imi da id-ul 
        produsului, al clientului care liciteaza pentru ea si suma maxima pe 
        care clientul isi permite sa o dea. Cand citesc o comanda de tip 
        "liciteaza", caut in casa de licitatii sa vad daca gasesc clientul cu
        id-ul respectiv. Daca exista, folosesc metoda liciteazaProdus pentru a-i 
        da clientului un broker si pentru a pune in HashMap-ul clientului id-ul 
        produsului si cat poate da maxim pe el.
        Apelez metoda verificaParticipanti, care, in primul rand, verifica daca
        numarul participantilor a atins acel numar necesar, specific fiecarei 
        licitatii, apoi, daca este atins acel numar, se incepe licitatia(adica 
        un thread) si se anunta toti brokerii de start(update).
        In run, apelez metoda turnOn, care cauta in lista de brokeri sa vada
        clientul caruia liciteaza pentru produsul care are id-ul dat ca parametru.
        Metoda start, realizeaza o parte din legatura casa de licitatii-clienti. 
        Cand ma duc pe send pentru clienti, ma duc, practic, catre metoda care imi
        calculeaza cat va oferi un client la acel pas. Cand ma duc pe send pentru 
        casa de licitatii(tehnica specifica folosita pentru design pattern-ul 
        Mediator) ajung in metoda sendMessage din Broker. Aici folosesc un bool, 
        folosit ca un artificiu, pentru a sti in ce directie ma duc cu mesajul. 
        Prin intermediul acestei metode, clientii primesc de la casa id-ul 
        produsul si pretul maxim de la pasul anterior, iar casa primeste id-ul 
        produsului si pretul maxim pe care il ofera un client, urmand sa faca maximul.
        In receive din client, doar se fac verificarile si se adauga in lista pentru 
        a tine evidenta. In receive din casa de licitatii, se verifica daca acest pret 
        nou este mai mare decat cel vechi si se modifica in lista.
        Firul de executie pentru o licitatie se incheie atunci cand nr maxim de 
        pasi este atins. Atunci, in run, apelez metodaLicitatie, pentru ca casa
        de licitatii sa o inchida in mod oficial si sa anunte castigatorul.

GENERICITATE:
        Am folosit colectii pentru genericitate. In general, am folosit clasa 
        abstracta ArrayList si Hashmap-uri. In broker, am utilizat interfata List.

CONCEPTE POO:
        -INCAPSULARE: majoritatea variabilelor sunt private; astfel, e nevoie de 
        getteri pentru a le obtine.
        -MOSTENIRE: sunt multe mosterniri in acest proiect. Spre exemplu, Tablou, 
        Mobila si Bijuterie mostenesc clasa parinte Produs, avand campurile comune
        de id, nume etc, insa fiecare din acestea avand si campurile lor specifice. 
        De asemenea, si Broker si Administrator mostenesc Angajat, folosindu-se de 
        campul CNP din clasa parinte. Nu in ultimul rand, exista 2 tipuri de 
        clienti, persoane fizice si persoane juridice, iar aceste doua clase 
        mostenesc clasa parinte Client.
        -ABSTRACTIZARE: clasele Produs si Client sunt abstracte deoarece niciodata 
        nu vor fi instantiate cu ele insele,
        mereu vor fi instantiate cu un copil.
        -POLIMORFISM: merge mana in mana cu abstractizarea, caci sunt folosite 
        proceduri de tipul Produs t = new Tablou().

DESIGN PATTERNS:
        -FACTORY: Inspirandu-ma din laboratorul de design pattern-uri, am folosit 
        acest Design Pattern in combinatie cu Singleton. Este folosita cu scopul
        de a crea un obiect. Totodata, folosindu-l, apropie proiectul de principiile 
        SOLID.
        -SINGLETON: Am folosit si in cadrul Produsului, dar cel mai bine se vede 
        utilitatea lui in cazul clasei Casa de licitatii, deoarece se stie sigur 
        ca este una singura. Astfel, nu am mai dat-o ca parametru, ci doar am 
        apelat getInstance() cand am avut nevoie de ea.
        -BUILDER: Tot un Design Pattern care creeaza obiecte, folosit in loc de 
        constructori.
        -MEDIATOR: Fiind interzisa comunicarea directa dintre casa de licitatii 
        si clienti, mi s-a parut ca cel mai eficient mod
        prin care sa fac acest lucru este folosind un design pattern.
        -OBSERVER: Cand o licitatie incepe, casa de licitatii trebuie sa-si 
        anunte toti brokerii de start, caci toti participa.


