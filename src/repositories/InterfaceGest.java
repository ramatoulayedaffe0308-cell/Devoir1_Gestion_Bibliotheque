package repositories;

import models.Emprunt;
import models.Livre;
import java.util.List;

public interface InterfaceGest {

    void enregisterEmp(Emprunt emp);
    List<Emprunt> afficherEmprunts();
    void retournerLivre(Livre l);

}
