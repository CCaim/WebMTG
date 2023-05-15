package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ncards")
public class Carta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "Nname")
	private String nname;
	@Column(name = "Nset")
	private String Nset;
	@Column(name = "Ntype")
	private String Ntype;
	@Column(name = "Nrarity")
	private String Nrarity;
	@Column(name = "Nmanacost")
	private String Nmanacost;
	@Column(name = "Nconverted_manacost")
	private String Nconverted_manacost;
	@Column(name = "Npower")
	private String Npower;
	@Column(name = "Ntoughness")
	private String Ntoughness;
	@Column(name = "Nloyalty")
	private String Nloyalty;
	@Column(name = "Nability")
	private String Nability;
	@Column(name = "Nflavor")
	private String Nflavor;
	@Column(name = "Nvariation")
	private String Nvariation;
	@Column(name = "Nartist")
	private String Nartist;
	@Column(name = "Nnumber")
	private String Nnumber;
	@Column(name = "Nrating")
	private String Nrating;
	@Column(name = "Nruling")
	private String Nruling;
	@Column(name = "Ncolor")
	private String Ncolor;
	@Column(name = "Ngenerated_mana")
	private String Ngenerated_mana;
	@Column(name= "Npricing_EUR")
	private String Npricing_EUR;
	@Column(name= "Npricing_USD")
	private String Npricing_USD;
	@Column(name= "Npricing_TIX")
	private String Npricing_;
	@Column(name= "Nback_id")
	private String Nback_id;
	@Column(name= "Nwatermark")
	private String Nwatermark;
	@Column(name= "Nprint_number")
	private String Nprint_number;
	@Column(name= "Nis_original")
	private String Nis_original;
	@Column(name= "Ncolor_identity")
	private String Ncolor_identity;
	@Column(name= "Nname_CN")
	private String Nname_CN;
	@Column(name= "Nname_TW")
	private String Nname_TW;
	@Column(name= "Nname_FR")
	private String Nname_FR;
	@Column(name= "Nname_DE")
	private String Nname_DE;
	@Column(name= "Nname_IT")
	private String Nname_IT;
	@Column(name= "Nname_JP")
	private String Nname_JP;
	@Column(name= "Nname_PT")
	private String Nname_PT;
	@Column(name= "Nname_RU")
	private String Nname_RU;
	@Column(name= "Nname_ES")
	private String Nname_ES;
	@Column(name= "Nname_KO")
	private String Nname_KO;
	@Column(name= "Ntype_CN")
	private String Ntype_CN;
	@Column(name= "Ntype_TW")
	private String Ntype_TW;
	@Column(name= "Ntype_FR")
	private String Ntype_FR;
	@Column(name= "Ntype_DE")
	private String Ntype_DE;
	@Column(name= "Ntype_IT")
	private String Ntype_IT;
	@Column(name= "Ntype_JP")
	private String Ntype_JP;
	@Column(name= "Ntype_PT")
	private String Ntype_PT;
	@Column(name= "Ntype_RU")
	private String Ntype_RU;
	@Column(name= "Ntype_ES")
	private String Ntype_ES;
	@Column(name= "Ntype_KO")
	private String Ntype_KO;
	@Column(name= "Nability_CN")
	private String Nability_CN;
	@Column(name= "Nability_TW")
	private String Nability_TW;
	@Column(name= "Nability_DE")
	private String Nability_DE;
	@Column(name= "Nability_IT")
	private String Nability_IT;
	@Column(name= "Nability_JP")
	private String Nability_JP;
	@Column(name= "Nability_PT")
	private String Nability_PT;
	@Column(name= "Nability_RU")
	private String Nability_RU;
	@Column(name= "Nability_ES")
	private String Nability_ES;
	@Column(name= "Nability_KO")
	private String Nability_KO;
	@Column(name= "Nflavor_CN")
	private String Nflavor_CN;
	@Column(name= "Nflavor_TW")
	private String Nflavor_TW;
	@Column(name= "Nflavor_FR")
	private String Nflavor_FR;
	@Column(name= "Nflavor_DE")
	private String Nflavor_DE;
	@Column(name= "Nflavor_IT")
	private String Nflavor_IT;
	@Column(name= "Nflavor_JP")
	private String Nflavor_JP;
	@Column(name= "Nflavor_PT")
	private String Nflavor_PT;
	@Column(name= "Nflavor_RU")
	private String Nflavor_RU;
	@Column(name= "Nflavor_ES")
	private String Nflavor_ES;
	@Column(name= "Nflavor_KO")
	private String Nflavor_KO;
	@Column(name= "Nlegality_Standard")
	private String Nlegality_standard;
	@Column(name= "Nlegality_Pioneer")
	private String Nlegality_Pioneer;
	@Column(name= "Nlegality_Modern")
	private String Nlegality_modern;
	@Column(name= "Nlegality_Legacy")
	private String Nlegality_legacy;
	@Column(name= "Nlegality_Vintage")
	private String Nlegality_vintage;
	@Column(name= "Nlegality_Highlander")
	private String Nlegality_highlander;
	@Column(name= "Nlegality_Duel_Commander")
	private String Nlegality_Duel_Commander;
	@Column(name= "Nlegality_Tiny_Leaders_Commander")
	private String Nlegality_Tiny_Leaders_Commander;
	@Column(name= "Nlegality_Commmander")
	private String Nlegality_Commander;
	@Column(name= "Nlegality_Peasant")
	private String Nlegality_Peasant;
	@Column(name= "Nlegality_Pauper")
	private String Nlegality_Pauper;
	@Column(name= "nabilityy_tw")
	private String nabilityy_tw;
	
	@ManyToMany(mappedBy = "cartas")
    private Set<Deck> decks;
	
	public Carta() {
		
	}
	
	public Carta(int id, String nname, String nset, Set<Deck> decks) {
		super();
		this.id = id;
		nname = nname;
		Nset = nset;
		this.decks = new HashSet<>();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		nname = nname;
	}

	public String getNset() {
		return Nset;
	}

	public void setNset(String nset) {
		Nset = nset;
	}

	public Set<Deck> getDecks() {
		return decks;
	}

	public void setDecks(Set<Deck> decks) {
		this.decks = decks;
	}

	public String getNtype() {
		return Ntype;
	}

	public void setNtype(String ntype) {
		Ntype = ntype;
	}

	public String getNrarity() {
		return Nrarity;
	}

	public void setNrarity(String nrarity) {
		Nrarity = nrarity;
	}

	public String getNmanacost() {
		return Nmanacost;
	}

	public void setNmanacost(String nmanacost) {
		Nmanacost = nmanacost;
	}

	public String getNconverted_manacost() {
		return Nconverted_manacost;
	}

	public void setNconverted_manacost(String nconverted_manacost) {
		Nconverted_manacost = nconverted_manacost;
	}

	public String getNpower() {
		return Npower;
	}

	public void setNpower(String npower) {
		Npower = npower;
	}

	public String getNtoughness() {
		return Ntoughness;
	}

	public void setNtoughness(String ntoughness) {
		Ntoughness = ntoughness;
	}

	public String getNloyalty() {
		return Nloyalty;
	}

	public void setNloyalty(String nloyalty) {
		Nloyalty = nloyalty;
	}

	public String getNability() {
		return Nability;
	}

	public void setNability(String nability) {
		Nability = nability;
	}

	public String getNflavor() {
		return Nflavor;
	}

	public void setNflavor(String nflavor) {
		Nflavor = nflavor;
	}

	public String getNvariation() {
		return Nvariation;
	}

	public void setNvariation(String nvariation) {
		Nvariation = nvariation;
	}

	public String getNartist() {
		return Nartist;
	}

	public void setNartist(String nartist) {
		Nartist = nartist;
	}

	public String getNnumber() {
		return Nnumber;
	}

	public void setNnumber(String nnumber) {
		Nnumber = nnumber;
	}

	public String getNrating() {
		return Nrating;
	}

	public void setNrating(String nrating) {
		Nrating = nrating;
	}

	public String getNruling() {
		return Nruling;
	}

	public void setNruling(String nruling) {
		Nruling = nruling;
	}

	public String getNcolor() {
		return Ncolor;
	}

	public void setNcolor(String ncolor) {
		Ncolor = ncolor;
	}

	public String getNgenerated_mana() {
		return Ngenerated_mana;
	}

	public void setNgenerated_mana(String ngenerated_mana) {
		Ngenerated_mana = ngenerated_mana;
	}

	public String getNpricing_EUR() {
		return Npricing_EUR;
	}

	public void setNpricing_EUR(String npricing_EUR) {
		Npricing_EUR = npricing_EUR;
	}

	public String getNpricing_USD() {
		return Npricing_USD;
	}

	public void setNpricing_USD(String npricing_USD) {
		Npricing_USD = npricing_USD;
	}

	public String getNpricing_() {
		return Npricing_;
	}

	public void setNpricing_(String npricing_) {
		Npricing_ = npricing_;
	}

	public String getNback_id() {
		return Nback_id;
	}

	public void setNback_id(String nback_id) {
		Nback_id = nback_id;
	}

	public String getNwatermark() {
		return Nwatermark;
	}

	public void setNwatermark(String nwatermark) {
		Nwatermark = nwatermark;
	}

	public String getNprint_number() {
		return Nprint_number;
	}

	public void setNprint_number(String nprint_number) {
		Nprint_number = nprint_number;
	}

	public String getNis_original() {
		return Nis_original;
	}

	public void setNis_original(String nis_original) {
		Nis_original = nis_original;
	}

	public String getNcolor_identity() {
		return Ncolor_identity;
	}

	public void setNcolor_identity(String ncolor_identity) {
		Ncolor_identity = ncolor_identity;
	}

	public String getNname_CN() {
		return Nname_CN;
	}

	public void setNname_CN(String nname_CN) {
		Nname_CN = nname_CN;
	}

	public String getNname_TW() {
		return Nname_TW;
	}

	public void setNname_TW(String nname_TW) {
		Nname_TW = nname_TW;
	}

	public String getNname_FR() {
		return Nname_FR;
	}

	public void setNname_FR(String nname_FR) {
		Nname_FR = nname_FR;
	}

	public String getNname_DE() {
		return Nname_DE;
	}

	public void setNname_DE(String nname_DE) {
		Nname_DE = nname_DE;
	}

	public String getNname_IT() {
		return Nname_IT;
	}

	public void setNname_IT(String nname_IT) {
		Nname_IT = nname_IT;
	}

	public String getNname_JP() {
		return Nname_JP;
	}

	public void setNname_JP(String nname_JP) {
		Nname_JP = nname_JP;
	}

	public String getNname_PT() {
		return Nname_PT;
	}

	public void setNname_PT(String nname_PT) {
		Nname_PT = nname_PT;
	}

	public String getNname_RU() {
		return Nname_RU;
	}

	public void setNname_RU(String nname_RU) {
		Nname_RU = nname_RU;
	}

	public String getNname_ES() {
		return Nname_ES;
	}

	public void setNname_ES(String nname_ES) {
		Nname_ES = nname_ES;
	}

	public String getNname_KO() {
		return Nname_KO;
	}

	public void setNname_KO(String nname_KO) {
		Nname_KO = nname_KO;
	}

	public String getNtype_CN() {
		return Ntype_CN;
	}

	public void setNtype_CN(String ntype_CN) {
		Ntype_CN = ntype_CN;
	}

	public String getNtype_TW() {
		return Ntype_TW;
	}

	public void setNtype_TW(String ntype_TW) {
		Ntype_TW = ntype_TW;
	}

	public String getNtype_FR() {
		return Ntype_FR;
	}

	public void setNtype_FR(String ntype_FR) {
		Ntype_FR = ntype_FR;
	}

	public String getNtype_DE() {
		return Ntype_DE;
	}

	public void setNtype_DE(String ntype_DE) {
		Ntype_DE = ntype_DE;
	}

	public String getNtype_IT() {
		return Ntype_IT;
	}

	public void setNtype_IT(String ntype_IT) {
		Ntype_IT = ntype_IT;
	}

	public String getNtype_JP() {
		return Ntype_JP;
	}

	public void setNtype_JP(String ntype_JP) {
		Ntype_JP = ntype_JP;
	}

	public String getNtype_PT() {
		return Ntype_PT;
	}

	public void setNtype_PT(String ntype_PT) {
		Ntype_PT = ntype_PT;
	}

	public String getNtype_RU() {
		return Ntype_RU;
	}

	public void setNtype_RU(String ntype_RU) {
		Ntype_RU = ntype_RU;
	}

	public String getNtype_ES() {
		return Ntype_ES;
	}

	public void setNtype_ES(String ntype_ES) {
		Ntype_ES = ntype_ES;
	}

	public String getNtype_KO() {
		return Ntype_KO;
	}

	public void setNtype_KO(String ntype_KO) {
		Ntype_KO = ntype_KO;
	}

	public String getNability_CN() {
		return Nability_CN;
	}

	public void setNability_CN(String nability_CN) {
		Nability_CN = nability_CN;
	}

	public String getNability_TW() {
		return Nability_TW;
	}

	public void setNability_TW(String nability_TW) {
		Nability_TW = nability_TW;
	}

	public String getNability_DE() {
		return Nability_DE;
	}

	public void setNability_DE(String nability_DE) {
		Nability_DE = nability_DE;
	}

	public String getNability_IT() {
		return Nability_IT;
	}

	public void setNability_IT(String nability_IT) {
		Nability_IT = nability_IT;
	}

	public String getNability_JP() {
		return Nability_JP;
	}

	public void setNability_JP(String nability_JP) {
		Nability_JP = nability_JP;
	}

	public String getNability_PT() {
		return Nability_PT;
	}

	public void setNability_PT(String nability_PT) {
		Nability_PT = nability_PT;
	}

	public String getNability_RU() {
		return Nability_RU;
	}

	public void setNability_RU(String nability_RU) {
		Nability_RU = nability_RU;
	}

	public String getNability_ES() {
		return Nability_ES;
	}

	public void setNability_ES(String nability_ES) {
		Nability_ES = nability_ES;
	}

	public String getNability_KO() {
		return Nability_KO;
	}

	public void setNability_KO(String nability_KO) {
		Nability_KO = nability_KO;
	}

	public String getNflavor_CN() {
		return Nflavor_CN;
	}

	public void setNflavor_CN(String nflavor_CN) {
		Nflavor_CN = nflavor_CN;
	}

	public String getNflavor_TW() {
		return Nflavor_TW;
	}

	public void setNflavor_TW(String nflavor_TW) {
		Nflavor_TW = nflavor_TW;
	}

	public String getNflavor_FR() {
		return Nflavor_FR;
	}

	public void setNflavor_FR(String nflavor_FR) {
		Nflavor_FR = nflavor_FR;
	}

	public String getNflavor_DE() {
		return Nflavor_DE;
	}

	public void setNflavor_DE(String nflavor_DE) {
		Nflavor_DE = nflavor_DE;
	}

	public String getNflavor_IT() {
		return Nflavor_IT;
	}

	public void setNflavor_IT(String nflavor_IT) {
		Nflavor_IT = nflavor_IT;
	}

	public String getNflavor_JP() {
		return Nflavor_JP;
	}

	public void setNflavor_JP(String nflavor_JP) {
		Nflavor_JP = nflavor_JP;
	}

	public String getNflavor_PT() {
		return Nflavor_PT;
	}

	public void setNflavor_PT(String nflavor_PT) {
		Nflavor_PT = nflavor_PT;
	}

	public String getNflavor_RU() {
		return Nflavor_RU;
	}

	public void setNflavor_RU(String nflavor_RU) {
		Nflavor_RU = nflavor_RU;
	}

	public String getNflavor_ES() {
		return Nflavor_ES;
	}

	public void setNflavor_ES(String nflavor_ES) {
		Nflavor_ES = nflavor_ES;
	}

	public String getNflavor_KO() {
		return Nflavor_KO;
	}

	public void setNflavor_KO(String nflavor_KO) {
		Nflavor_KO = nflavor_KO;
	}

	public String getNlegality_standard() {
		return Nlegality_standard;
	}

	public void setNlegality_standard(String nlegality_standard) {
		Nlegality_standard = nlegality_standard;
	}

	public String getNlegality_Pioneer() {
		return Nlegality_Pioneer;
	}

	public void setNlegality_Pioneer(String nlegality_Pioneer) {
		Nlegality_Pioneer = nlegality_Pioneer;
	}

	public String getNlegality_modern() {
		return Nlegality_modern;
	}

	public void setNlegality_modern(String nlegality_modern) {
		Nlegality_modern = nlegality_modern;
	}

	public String getNlegality_legacy() {
		return Nlegality_legacy;
	}

	public void setNlegality_legacy(String nlegality_legacy) {
		Nlegality_legacy = nlegality_legacy;
	}

	public String getNlegality_vintage() {
		return Nlegality_vintage;
	}

	public void setNlegality_vintage(String nlegality_vintage) {
		Nlegality_vintage = nlegality_vintage;
	}

	public String getNlegality_highlander() {
		return Nlegality_highlander;
	}

	public void setNlegality_highlander(String nlegality_highlander) {
		Nlegality_highlander = nlegality_highlander;
	}

	public String getNlegality_Duel_Commander() {
		return Nlegality_Duel_Commander;
	}

	public void setNlegality_Duel_Commander(String nlegality_Duel_Commander) {
		Nlegality_Duel_Commander = nlegality_Duel_Commander;
	}

	public String getNlegality_Tiny_Leaders_Commander() {
		return Nlegality_Tiny_Leaders_Commander;
	}

	public void setNlegality_Tiny_Leaders_Commander(String nlegality_Tiny_Leaders_Commander) {
		Nlegality_Tiny_Leaders_Commander = nlegality_Tiny_Leaders_Commander;
	}

	public String getNlegality_Commander() {
		return Nlegality_Commander;
	}

	public void setNlegality_Commander(String nlegality_Commander) {
		Nlegality_Commander = nlegality_Commander;
	}

	public String getNlegality_Peasant() {
		return Nlegality_Peasant;
	}

	public void setNlegality_Peasant(String nlegality_Peasant) {
		Nlegality_Peasant = nlegality_Peasant;
	}

	public String getNlegality_Pauper() {
		return Nlegality_Pauper;
	}

	public void setNlegality_Pauper(String nlegality_Pauper) {
		Nlegality_Pauper = nlegality_Pauper;
	}

	public String getNabilityy_tw() {
		return nabilityy_tw;
	}

	public void setNabilityy_tw(String nabilityy_tw) {
		this.nabilityy_tw = nabilityy_tw;
	}

	@Override
	public String toString() {
		return "Nombre: " + nname + "\n";
	}

}
