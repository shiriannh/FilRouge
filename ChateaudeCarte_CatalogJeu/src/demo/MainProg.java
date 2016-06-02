package demo;

import java.rmi.RemoteException;

import chateaudecartes.ws.GameCatalog;
import chateaudecartes.ws.GameCatalogProxy;
import chateaudecartes.ws.Jeu;

public class MainProg {

	public static void main(String[] args) throws RemoteException {
		
		GameCatalog catalogue = new GameCatalogProxy();
	
		for (Jeu j : catalogue.gameList()) {
			System.out.println("-------------------------");
			System.out.printf("Nom Jeu : %s%n", j.getNom());
			System.out.printf("Nom Editeur : %s%n", j.getEditeur());
			System.out.printf("Date de Sortie : %s%n", j.getDateSortie());
			System.out.println("-------------------------");
		}

	}

}
