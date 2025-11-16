#include <iostream>
using namespace std;

class Client {
public:
    int id;
    string nom;
    string prenom;
    
    Client() {
        id = 0;
        nom = "";
        prenom = "";
    }
    
    Client(int i, string n, string p) {
        id = i;
        nom = n;
        prenom = p;
    }
    
    Client(Client &c) {
        id = c.id;
        nom = c.nom;
        prenom = c.prenom;
    }
    
    void afficher() {
        cout << "Client " << id << " : " << nom << " " << prenom << endl;
    }
};

class Compte {
public:
    int numero;
    float solde;
    Client *client;
    static int nbComptes;
    
    Compte() {
        numero = 0;
        solde = 0;
        client = NULL;
        nbComptes++;
    }
    
    Compte(int n, float s, Client *c) {
        numero = n;
        solde = s;
        client = c;
        nbComptes++;
    }
    
    Compte(Compte &c) {
        numero = c.numero;
        solde = c.solde;
        client = c.client;
        nbComptes++;
    }
    
    ~Compte() {
        nbComptes--;
    }
    
    void afficher() {
        cout << "Compte numero " << numero << ", Solde : " << solde << " DH" << endl;
        if (client != NULL) {
            client->afficher();
        }
    }
    
    static void afficherNbComptes() {
        cout << "Nombre total de comptes : " << nbComptes << endl;
    }
};

int Compte::nbComptes = 0;

float calculInteret(float solde, float taux) {
    return solde * (1 + taux/100);
}

int main() {
    Client c1(1, "Alami", "Ahmed");
    Client c2(2, "Idrissi", "Fatima");
    
    Compte cpt1(101, 5000, &c1);
    Compte cpt2(102, 3000, &c2);
    
    cpt1.afficher();
    cpt2.afficher();
    
    Compte::afficherNbComptes();
    
    Compte cpt3(cpt1);
    cpt3.afficher();
    
    Compte::afficherNbComptes();
    
    float nouveauSolde = calculInteret(cpt1.solde, 5);
    cpt1.solde = nouveauSolde;
    cpt1.afficher();
    
    Compte::afficherNbComptes();
    
    return 0;
}
    
   
