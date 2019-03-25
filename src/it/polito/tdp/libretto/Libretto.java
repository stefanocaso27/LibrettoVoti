package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.*;

public class Libretto {
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}

	public void add(int voto, String corso, LocalDate data) {
		
	}
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 * @return [@code true}nel caso normale, {@code false} se non e' riuscito ad aggiungere il voto
	 */
	
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricerca
	 * @return lista di {@link Voto} aventi quel punteggio
	 */
	
	public List<Voto> cercaVoti(int voto) {
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() == voto)
				result.add(v);
		}
		return result;
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da cercare
	 * @return il {@link Voto} corrispondente oppure null
	 */
	
	public Voto cercaEsame(String nomeEsame) {
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);  //cerco un oggetto uguale a questo
		if(pos == -1)
			return null;
		else
			return this.voti.get(pos);
	}
	
	/**
	 * Dato un {@link Voto} determina se esiste gia' un voto con uguale
	 * corso ed uguale punteggio.
	 * 
	 * @param v
	 * @return {@code true} se ha trovato un corso e punteggio uguali
	 *         {@code false} se non ha trovato il corso,oppure l'ha trovato con voto diverso
	 *         
	 */
	
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos == -1)
			return false;
		else
			return (v.getPunti() == this.voti.get(pos).getPunti());	
	}
	
	/**
	 * Mi dice se il {@link Voto} {@code v} e' in conflitto con uno dei voti esistenti
	 * Se il voto non esiste, non c'e' conflitto. Se esiste ed ha un puntegio diverso, c'e' conflitto
	 * 
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso, opposto per {@code false}
	 */
	
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos == -1)
			return false;
		else
			return (v.getPunti() != this.voti.get(pos).getPunti());
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			nuovo.add(v.clone());
		}
		for(Voto v : nuovo.voti) {
			int punti = v.getPunti();
			if(punti < 24)
				punti ++;
			else if(punti <= 28)
				punti = punti + 2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		List <Voto> cancellare = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti() < 24)
				cancellare.add(v);  //modificare collezione solo se non la sto iterando
		}
		this.voti.removeAll(cancellare);
	}
}
