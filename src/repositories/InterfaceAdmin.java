package repositories;
import models.Livre;
import models.Utilisateur;
import java.util.List;

public interface InterfaceAdmin {

    void ajouterUtils(Utilisateur u);
    List<Utilisateur> afficherUtilisateurs();
    Utilisateur rechercherUtils(int id);

    void ajouterLivre(Livre l);
    List<Livre> listerLivre();

}
