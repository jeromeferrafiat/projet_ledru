// Based on a B specification from Marie-Laure Potet.

public class Explosives{
    public int nb_inc = 0;
    public String [][] incomp = new String[50][2];
    public int nb_assign = 0;
    public String [][] assign = new String[30][2];
    

    //Il ne peut pas y avoir moins de 0 incompatibilités, et il ne peut y en avoir plus de 49.
    /*@ public invariant // Prop 1
      @ (0 <= nb_inc && nb_inc < 50);
      @*/
    
    //Il ne peut pas y avoir moins de 0 assignations de produits, et il ne peut y en avoir plus de 29.
    /*@ public invariant // Prop 2
      @ (0 <= nb_assign && nb_assign < 30);
      @*/
    
    //Pour toute ligne l du tableau des incompatibilité, l[0] et l[1] sont des produits.
    /*@ public invariant // Prop 3
      @ (\forall int i; 0 <= i && i < nb_inc; 
      @         incomp[i][0].startsWith("Prod") && incomp[i][1].startsWith("Prod"));
      @*/
    
    //Pour toute ligne l du tableau d'assignations, l[0] est un bâtiment et l[1] est un produit.
    /*@ public invariant // Prop 4
      @ (\forall int i; 0 <= i && i < nb_assign; 
      @         assign[i][0].startsWith("Bat") && assign[i][1].startsWith("Prod"));
      @*/
    
    //Un produit ne peut pas être incompaptible avec lui-même.
    /*@ public invariant // Prop 5
      @ (\forall int i; 0 <= i && i < nb_inc; !(incomp[i][0]).equals(incomp[i][1]));
      @*/
    
    //Cette propriété sert à vérifier le caractère symétrique de la relation d'incompatibilité. Si a est incompatible avec b, alors b est incompatible avec a.
    /*@ public invariant // Prop 6
      @ (\forall int i; 0 <= i && i < nb_inc; 
      @        (\exists int j; 0 <= j && j < nb_inc; 
      @           (incomp[i][0]).equals(incomp[j][1]) 
      @              && (incomp[j][0]).equals(incomp[i][1]))); 
      @*/
    
    //Cette propriété vérifie qu'aucun bâtiment ne contiennent de produits incompatibles entre eux.
    /*@ public invariant // Prop 7
      @ (\forall int i; 0 <= i &&  i < nb_assign; 
      @     (\forall int j; 0 <= j && j < nb_assign; 
      @        (i != j && (assign[i][0]).equals(assign [j][0])) ==>
      @        (\forall int k; 0 <= k && k < nb_inc;
      @           (!(assign[i][1]).equals(incomp[k][0])) 
      @              || (!(assign[j][1]).equals(incomp[k][1])))));
      @*/

    //INVARIANTS AJOUTE PAR LE GROUPE
    //toutes les lignes du tableau des affectations (assign) sont différentes deux à deux.
    /*@ public invariant // Prop 8
      @ (\forall int i; 0 <= i &&  i < nb_assign; 
      @     (\forall int j; 0 <= j && j < nb_assign; 
      @           (i != j && (( assign[i][0] != assign[j][0] ) 
      @             || ( assign[i][1] != assign[j][1] )));
      @*/




  //@ requires nb_inc < 48;  
  public void add_incomp(String prod1, String prod2)
  {
	 incomp[nb_inc][0] = prod1;
	 incomp[nb_inc][1] = prod2;
	 incomp[nb_inc+1][1] = prod1;
	 incomp[nb_inc+1][0] = prod2;
	 nb_inc = nb_inc+2;
  }
  
  //@ requires nb_assign < 29;
  public void add_assign(String bat, String prod)
  {
	 assign[nb_assign][0] = bat;
	 assign[nb_assign][1] = prod;
	 nb_assign = nb_assign+1;
  }
    public void skip(){
    }
}
