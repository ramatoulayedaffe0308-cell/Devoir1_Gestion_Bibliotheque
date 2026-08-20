import DAO.BD.AdminDAO;
import DAO.BD.AuthentifierDAO;
import DAO.BD.GestionnaireDAO;
import DAO.BD.Session;
import models.Emprunt;
import models.Livre;
import models.Utilisateur;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdminDAO dao = new AdminDAO();
        GestionnaireDAO daoE = new GestionnaireDAO();
        AuthentifierDAO daoA = new AuthentifierDAO();
        Session ses = new Session();
        Scanner sc = new Scanner(System.in);

        int choix;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Se connecter");
            System.out.println("2. Se deconnecter");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                // =====================================================
                // CONNEXION
                // =====================================================
                case 1:
                    if (ses.estConnecte()) {
                        System.out.println(
                           "Utilisateur déjà connecté avec le rôle : " + ses.getRole()
                        );
                        break;
                    }
                    System.out.print("Role (admin ou gestionnaire) : ");
                    String roleU = sc.nextLine();

                    System.out.print("Email : ");
                    String emailD = sc.nextLine();

                    System.out.print("Mot de passe : ");
                    String mdpD = sc.nextLine();

                    // Authentification dans la base de données
                    Utilisateur utilis = daoA.authentifier(emailD, mdpD);

                    // Vérification de l'utilisateur
                    if (utilis == null) {
                        System.out.println("Email ou mot de passe incorrect.");
                        break;
                    }
                    // Vérification du rôle
                    if (!roleU.equalsIgnoreCase(utilis.getRole())) {
                        System.out.println("Le rôle ne correspond pas à cet utilisateur.");
                        break;
                    }
                    // Connexion de l'utilisateur
                    ses.connecter(utilis);

                    System.out.println(
                            "\nBienvenue " + utilis.getPrenom() + " " + utilis.getNom()
                    );

                    // MENU ADMIN
                    if ("admin".equalsIgnoreCase(utilis.getRole())) {
                        int choixAdmin;
                        do {
                            System.out.println("\n===== MENU ADMIN =====");
                            System.out.println("1. Ajouter un utilisateur");
                            System.out.println("2. Afficher tous les utilisateurs");
                            System.out.println("3. Rechercher un utilisateur");
                            System.out.println("4. Ajouter un livre");
                            System.out.println("5. Lister tous les livres");
                            System.out.println("6. Se deconnecter");
                            System.out.print("Votre choix : ");
                            choixAdmin = sc.nextInt();
                            sc.nextLine();

                            switch (choixAdmin) {

                                case 1:
                                    System.out.print("Id utilisateur : ");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Nom : ");
                                    String nom = sc.nextLine();

                                    System.out.print("Prenom : ");
                                    String prenom = sc.nextLine();

                                    System.out.print("Email : ");
                                    String email = sc.nextLine();

                                    System.out.print("Mot de passe : ");
                                    String mdp = sc.nextLine();

                                    System.out.print(
                                            "Role (admin ou gestionnaire) : "
                                    );
                                    String role = sc.nextLine();

                                    Utilisateur nouvelUtilisateur =
                                            new Utilisateur(
                                                    id,
                                                    nom,
                                                    prenom,
                                                    email,
                                                    mdp,
                                                    role
                                            );
                                    dao.ajouterUtils(nouvelUtilisateur);
                                    break;

                                case 2:
                                    System.out.println("\n===== LISTE DES UTILISATEURS =====");
                                    dao.afficherUtilisateurs()
                                            .forEach(System.out::println);
                                    break;

                                case 3:
                                    System.out.print("Id de l'utilisateur à rechercher : ");
                                    int idRecherche = sc.nextInt();
                                    sc.nextLine();
                                    Utilisateur u = dao.rechercherUtils(idRecherche);

                                    if (u != null) {
                                        System.out.println("\nUtilisateur trouvé :");
                                        System.out.println(u);
                                    } else {
                                        System.out.println("Utilisateur introuvable.");
                                    }
                                    break;

                                case 4:
                                    System.out.print("Id livre : ");
                                    int idl = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Titre : ");
                                    String titre = sc.nextLine();

                                    System.out.print("Auteur : ");
                                    String auteur = sc.nextLine();

                                    System.out.print("Année de publication : ");
                                    int an = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Disponible : ");
                                    String dispo = sc.nextLine();

                                    Livre livre =
                                            new Livre(
                                                    idl,
                                                    titre,
                                                    auteur,
                                                    an,
                                                    dispo
                                            );
                                    dao.ajouterLivre(livre);
                                    break;

                                case 5:
                                    System.out.println("\n===== LISTE DES LIVRES =====");
                                    dao.listerLivre()
                                            .forEach(System.out::println);
                                    break;

                                case 6:
                                    ses.deconnecter();
                                    System.out.println("Admin déconnecté.");
                                    break;

                                default:
                                    System.out.println("Choix invalide.");
                            }
                        } while (choixAdmin != 6);
                    }
                    // MENU GESTIONNAIRE

                    else if ("gestionnaire".equalsIgnoreCase(utilis.getRole()))
                    {
                        int choixGest;
                        do {
                            System.out.println("\n===== MENU GESTIONNAIRE =====");
                            System.out.println("1. Enregistrer un emprunt");
                            System.out.println("2. Afficher tous les emprunts");
                            System.out.println("3. Retourner un livre");
                            System.out.println("4. Se deconnecter");
                            System.out.print("Votre choix : ");
                            choixGest = sc.nextInt();
                            sc.nextLine();

                            switch (choixGest) {
                                case 1:
                                    System.out.print("Id emprunt : ");
                                    int idE = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Id livre : ");
                                    int idL = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Date emprunt : ");
                                    String dateE = sc.nextLine();

                                    System.out.print("Date retour prévue : ");
                                    String dateP = sc.nextLine();

                                    System.out.print("Nom complet : ");
                                    String nomC = sc.nextLine();

                                    Emprunt emp = new Emprunt(
                                            idE,
                                            idL,
                                            "en cours",
                                            dateE,
                                            dateP,
                                            null,
                                            nomC
                                    );
                                    daoE.enregisterEmp(emp);
                                    break;

                                case 2:
                                    System.out.println("\n===== LISTE DES EMPRUNTS =====");
                                    daoE.afficherEmprunts()
                                            .forEach(System.out::println);
                                    break;

                                case 3:
                                    System.out.print("Id du livre à retourner : ");
                                    int idLivre = sc.nextInt();
                                    sc.nextLine();

                                    Livre livre = new Livre(
                                            idLivre,
                                            "",
                                            "",
                                            0,
                                            ""
                                    );
                                    livre.setIdL(idLivre);
                                    daoE.retournerLivre(livre);

                                    break;

                                case 4:
                                    ses.deconnecter();
                                    System.out.println(
                                            "Gestionnaire déconnecté."
                                    );
                                    break;

                                default:
                                    System.out.println("Choix invalide.");
                            }
                        } while (choixGest != 4);
                    }
                    break;

                case 2:
                    if (ses.estConnecte()) {
                        ses.deconnecter();
                        System.out.println("Déconnexion réussie.");
                    } else {
                        System.out.println("Aucun utilisateur n'est connecté.");
                    }
                    break;

                case 3:
                    if (ses.estConnecte()) {
                        ses.deconnecter();
                    }
                    System.out.println("Fin du programme. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 3);
        sc.close();
    }
}