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

		BufferedReader br = new BufferedReader( // création buffered Reader pour lire le fichier
				new FileReader("D:\\Programmes Pro\\ECLIPSE\\Travaux\\Ressources AdventOfCode\\InputDay3-2022.txt")); // chemin
		while ((ligne = br.readLine()) != null) {

			int diviseur = ligne.length() / 2; // règles qui détermine ou diviser la ligne
			String partie1 = ligne.substring(0, diviseur); // divise en partant de l'index 0 puis au diviseur
			String partie2 = ligne.substring(diviseur);

			Set<Character> compartiment1 = new HashSet<>(); // création de deux ensembles qui permettront de comparer
									// les lettres, on cherche l'intersection ( hashet car on ne veut pas de doublons, et on ne souhaite pas d'ordre particulier)
			Set<Character> compartiment2 = new HashSet<>();

			for (char c : partie1.toCharArray()) { // ajoute chaque caractère au compartiment 1
				compartiment1.add(c);
			}
			for (char c : partie2.toCharArray()) { // ajoute chaque caractère au compartiment 2
				compartiment2.add(c);
			}
			compartiment1.retainAll(compartiment2); // retainAll permet de supprimer tous les caractères qui ne se
													// correspondent pas
			char lettreCommune = compartiment1.iterator().next(); // le premier caractère trouvé dans compartiment 1 (
																	// le seul )
																	// (permet de convertir)
			int priorite = (int) lettreCommune; // permet d'obtenir la valeur ASCII de chaque caractère (voir table)
			// Ainsi pour la faire correspondre aux valeurs voulues:
			// Si on veut que A soit = 27; on doit soustraire 38
			// Si on veut que a soit = 1; on doit soustraire -96
			if (Character.isUpperCase(lettreCommune)) {
				total += priorite - 38;
			} else {
				total += priorite - 96;
			}

			System.out.println(total); // compartiment 1 représente maintenant chaque lettre en commun
		}
	}

}
