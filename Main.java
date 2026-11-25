import java.util.LinkedList;
import java.util.List;

import robdd.ROBDD;
import expression.*;

public class Main {

	public static void main(String[] args) {
		/*
		//EXEMPLE 
		Expression exp = new Et(new Atome("x"),new Atome("y")); // représente (x ^ y)
		System.out.println(exp.atomes()); // affiche la liste des atomes (=variables booléennes) présents dans exp
		exp = exp.remplace("x",true); // exp vaut maintenant (true ^ y)
		System.out.println(exp.evalue()); // <- erreur car (true ^ y) ne peut pas être évalué
		exp = exp.remplace("y",false); // exp vaut maintenant (true ^ false)
		System.out.println(exp.evalue());
		
		//Affichage de l'arbre associé à l'expression exp pour l'ordre x > y 
		List<String> ordre_atomes = new LinkedList<String>();
		ordre_atomes.add("x");
		ordre_atomes.add("y");
		System.out.println("\n Arbre de exp : \n" + exp.arbre(ordre_atomes)); // <- que se passe-t-il ? 
		Expression exp2 = new Et(new Atome("x"),new Atome("y")); // représente (x ^ y)
		System.out.println("\n Arbre de exp2 : \n" + exp2.arbre(ordre_atomes));	
		*//

		//EXEMPLE 2
		// Création de la formule f = (x1 <=> y1) ^ (x2 <=> y2)
		Expression f = new Et(
			new Equiv(new Atome("x1"), new Atome("y1")),
			new Equiv(new Atome("x2"), new Atome("y2"))
		);

		// Afficher les atomes (l'ordre d'affichage d'un Set est quelconque)
		System.out.println("Atomes de f : " + f.atomes());

		Expression f_test = f.remplace("x1", true)
							.remplace("y1", true)
							.remplace("x2", false)
							.remplace("y2", false);
		System.out.println("Evaluation avec (T, T, F, F) : " + f_test.evalue()); // Doit afficher true

		Expression f_test2 = f.remplace("x1", true)
							.remplace("y1", false)
							.remplace("x2", false)
							.remplace("y2", false);
		System.out.println("Evaluation avec (T, F, F, F) : " + f_test2.evalue()); // Doit afficher false

		// Ordre 1 : x1, y1, x2, y2
		List<String> ordre1 = new LinkedList<String>();
		ordre1.add("x1");
		ordre1.add("y1");
		ordre1.add("x2");
		ordre1.add("y2");
		System.out.println("\n--- Arbre de Shannon (ordre x1, y1, x2, y2) ---\n" + f.arbre(ordre1));

		// Ordre 2 : x1, x2, y1, y2
		List<String> ordre2 = new LinkedList<String>();
		ordre2.add("x1");
		ordre2.add("x2");
		ordre2.add("y1");
		ordre2.add("y2");
		System.out.println("\n--- Arbre de Shannon (ordre x1, x2, y1, y2) ---\n" + f.arbre(ordre2));	
			}
}
