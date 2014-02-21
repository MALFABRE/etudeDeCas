/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager;

import entites.Fonction;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Thibaut
 */
@Stateless
@LocalBean
public class fonctionManager {

    Fonction maFonction = new Fonction();
    public void ajouterFonction(String libelle){
        maFonction.setLibelle(libelle);
    }
}
