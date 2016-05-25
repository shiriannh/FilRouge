package chateaudecartes.security;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;

import net.entetrs.commons.jsf.JsfUtils;
import net.entetrs.commons.jsf.security.SpringSecurityHelper;
/**
 * ManagedBean JSF gérant la session de l'utilisateur (connexion/deconnexion).
 * 
 * @author etrs
 *
 */
@SuppressWarnings("serial")
@Named
@SessionScoped
public class LoginBean implements Serializable {

	
	// Services applicatifs

	/**
	 * lance la fonction de "login".
	 * 
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public void connexion() throws IOException, ServletException {
		JsfUtils.sendGrowlMessage("Bienvenue %s", getUserLogin());
        SpringSecurityHelper.login();   
        
	}

	/**
	 * lance la fonction de "logout".
	 * 
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deconnexion() throws ServletException, IOException {
        SpringSecurityHelper.logout();
        JsfUtils.sendMessage("Vous vous êtes déconnecté");
	}
	
	/**
	 * vérifie si un utilisateur est connecté.
	 * 
	 * @return true si connecté / false sinon
	 * @throws ServletException
	 * @throws IOException
	 */
	public boolean isConnected() {
		String login = SpringSecurityHelper.getUserLogin();
		return (login != null && !login.equals("anonymousUser"));
	}
	
	/**
	 * retourne le login de l'utilisateur.
	 * 
	 * @return le login (l'identifiant) de l'utilisateur
	 */
    public String getUserLogin() {
        
    	String login = SpringSecurityHelper.getUserLogin();
    	
    	
    	return login;
    }

    /**
     * permet de savoir si l'utilisateur est dans un rôle passé en paramètre.
     *
     * @param role
     * @return true si l'utilisateur possède le rôle, false sinon.
     */
    public boolean isInRole(String role) {
    	return SpringSecurityHelper.isInRole(role);
    }
    
    /**
     * retourne la liste complète des rôles.
     * @return la liste des rôles de l'application
     */
    public List<String> getRoles() {
    	return SpringSecurityHelper.getRoles();
    }


}
