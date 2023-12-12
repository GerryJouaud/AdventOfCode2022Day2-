package adventOfCode2022;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Day3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String ligne = ""; // initialisations valeurs
		int total = 0;
		int compteurLigne = 0;
		Set<Character> sac1 = new HashSet<>(); // création de trois ensembles qui permettront de comparer leurs
						      // caractères ( hashet car on ne veut pas de doublons, et on ne souhaite pas d'ordre particulier)
		
		Set<Character> sac2 = new HashSet<>();

		Set<Character> sac3 = new HashSet<>();

		BufferedReader br = new BufferedReader( // création buffered Reader pour lire le fichier
				new FileReader("D:\\Programmes Pro\\ECLIPSE\\Travaux\\Ressources AdventOfCode\\InputDay3-2022.txt")); // chemin

		while ((ligne = br.readLine()) != null) {

			compteurLigne++; // On incrémente le compteur de ligne pour pouvoir regrouper les lignes par
								// ensemble de 3
			if (compteurLigne == 4) { // si il est à 4, on recommence un nouvel ensemble de 3
				compteurLigne = 1;

			}

			switch (compteurLigne) { // Si c'est la ligne numéro 1
			case 1:
				String ligne1 = ligne;
				for (char c : ligne1.toCharArray()) { // ajoute chaque caractère au sac 1
					sac1.add(c);
				}
				break;
			case 2:
				String ligne2 = ligne; // Si c'est la ligne numéro 2
				for (char c : ligne2.toCharArray()) { // ajoute chaque caractère au sac 2
					sac2.add(c);
				}
				break;
			case 3:
				String ligne3 = ligne; // Si c'est la ligne numéro 3
				for (char c : ligne3.toCharArray()) { // ajoute chaque caractère au sac 3
					sac3.add(c);
				}
				break;
			}

			if (compteurLigne == 3) { // ça signifie que nous avons notre ensemble, et qu'il faut le comparer pour
										// avoir le caractère en commun

				sac1.retainAll(sac2); // exclut tous les caractères pas en commun avec le sac 2
				sac1.retainAll(sac3); // exclut tous les caractères pas en commun avec le sac 3

				char lettreCommune = sac1.iterator().next(); // nouvelle variable a qui on assigne la seule valeur
																// présente dans sac1
				int priorite = (int) lettreCommune; // permet d'obtenir la valeur ASCII de chaque caractère (voir table)
				// Ainsi pour la faire correspondre aux valeurs voulues:
				// Si on veut que A soit = 27; on doit soustraire 38
				// Si on veut que a soit = 1; on doit soustraire -96

				if (Character.isUpperCase(lettreCommune)) {
					total += priorite - 38;
				} else {
					total += priorite - 96;
				}

				sac1.clear(); // on vide les sacs pour pouvoir comparer un nouvel ensemble
				sac2.clear();
				sac3.clear();

			}

		}

		System.out.println(total); // on imprime le total des valeurs de chaque insigne

	}
}
