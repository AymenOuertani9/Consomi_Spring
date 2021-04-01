package tn.esprit.pidev.service;

public interface IOperationService {
	 // Operation verssement
    public boolean verser( int idcpt, double montant );

    // retirer
    public boolean retirer( int idcpt, double montant );

    // virement on a bsoin de deux comptes Emetter, Recepteur

    public String virement(int cpte1, int cpte2,int idc);
    public String payamounttoselleraccount(int idcpt,int idbill ) ;
    public String paymentbytransfer(int idc,int cpte1, int cpte2);
}
