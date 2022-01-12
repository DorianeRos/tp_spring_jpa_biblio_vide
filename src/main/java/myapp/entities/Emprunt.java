package myapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	private Date datedebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	private Date datefin;
	
	private int delai;
	
	/**
	 * clientE est un nom unique
	 * dans toutes mes entities
	 * car je vais utiliser
	 * "mappedBy"
	 * 
	 * REGLE @ManytoOne :  de relation
	 */
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client clientE; //Un lient FK : clé étrangére vers l'entite Client
	
	/**
	 * par mappedBy="empruntLivres"
	 * je récupère automatiquement
	 * les livres empruntés
	 */
	@ManyToMany(mappedBy="empruntLivres")
	private Set<Livre> livresE;


	public Emprunt() {
		super();
		// TODO Auto-generated constructor stub
		livresE = new HashSet<Livre>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Client getClientE() {
		return clientE;
	}

	public void setClientE(Client clientE) {
		this.clientE = clientE;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", datedebut=" + datedebut + ", datefin=" + datefin + ", delai=" + delai
				+ ", clientE=" + clientE + "]";
	}

	public Set<Livre> getLivresE() {
		return livresE;
	}

	public void setLivresE(Set<Livre> livresE) {
		this.livresE = livresE;
	}
	
	

}
