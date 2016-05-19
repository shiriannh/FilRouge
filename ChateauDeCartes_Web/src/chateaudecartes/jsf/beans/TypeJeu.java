package chateaudecartes.jsf.beans;

import lombok.Getter;
import lombok.Setter;

public enum TypeJeu {
	JEU_SOCIETE("Jeu de Société"),
	JEU_DE_ROLE("Jeu de Rôle");
	
	 @Getter
	    @Setter
	    private String libelle;
	    
	    private TypeJeu(String nom)
	    {
	        this.libelle = nom;
	    }
}
