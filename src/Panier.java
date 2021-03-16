
import java.sql.*;
public class Panier {

	
	public Panier(int idclient, int idproduit,Date date, int prix, int quantite, String image) {
		super();
		this.idclient = idclient;
		this.idproduit = idproduit;
		this.prix = prix;
		this.quantite = quantite;
		this.image = image;
		this.date_demand = date;
	}
	
	int idclient,idproduit,prix,quantite;
   String image;
   Date date_demand;

public int getIdclient() {
	return idclient;
}
public void setIdclient(int idclient) {
	this.idclient = idclient;
}
public int getIdproduit() {
	return idproduit;
}
public void setIdproduit(int idproduit) {
	this.idproduit = idproduit;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getDate_demand() {
	return date_demand;
}
public void setDate_demand(Date date_demand) {
	this.date_demand = date_demand;
}
	
	
	
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
}
