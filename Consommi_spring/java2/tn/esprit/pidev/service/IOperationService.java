package tn.esprit.pidev.service;

public interface IOperationService {
	 // Operation verssement
    public boolean verser( int idcpt, double montant );

    // retirer
    public boolean retirer( int idcpt, double montant );

    // virement on a bsoin de deux comptes Emetter, Recepteur

    public boolean virement(int cpte1, int cpte2, double montant,int idc);

   
}
