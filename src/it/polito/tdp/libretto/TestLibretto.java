package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto();
		
		libr.add(new Voto(18, "Analisi I", LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(25, "Analisi II", LocalDate.of(2018, 1, 15)));
		libr.add(new Voto(19, "Geometria", LocalDate.of(2017, 7, 15)));
		libr.add(new Voto(25, "Informatica", LocalDate.of(2017, 1, 25)));
		libr.add(new Voto(21, "Programmazione a Oggetti", LocalDate.of(2019, 2, 5)));
		libr.add(new Voto(22, "Ricerca Operativa", LocalDate.of(2018, 7, 25)));
		libr.add(new Voto(18, "Chimica", LocalDate.of(2017, 1, 25)));
		libr.add(new Voto(21, "Logistica", LocalDate.of(2018, 9, 15)));
		libr.add(new Voto(22, "Economia", LocalDate.of(2018, 7, 20)));
		libr.add(new Voto(18, "Fisica II", LocalDate.of(2019, 1, 18)));
		
		List <Voto> venticinque = libr.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = libr.cercaEsame("Analisi I");
		Voto a2 = libr.cercaEsame("Analisi III");
		System.out.println(a1);
		System.out.println(a2);
		
		Voto giusto = new Voto(19, "Geometria", LocalDate.now());
		Voto sbagliato = new Voto(28, "Geometria", LocalDate.now());
		Voto mancante = new Voto(30, "Merendine", LocalDate.now());
		
		System.out.format("Il voto %s e' %s\n", giusto.toString(), libr.esisteGiaVoto(giusto));
		System.out.format("Il voto %s e' %s\n", sbagliato.toString(), libr.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s e' %s\n", mancante.toString(), libr.esisteGiaVoto(mancante));

		System.out.format("Il voto %s e' inconflitto %s\n", giusto.toString(), libr.votoConflitto(giusto));
		System.out.format("Il voto %s e' inconflitto %s\n", sbagliato.toString(), libr.votoConflitto(sbagliato));
		System.out.format("Il voto %s e' inconflitto %s\n", mancante.toString(), libr.votoConflitto(mancante));
		
		System.out.println(libr.add(giusto));
		System.out.println(libr.add(sbagliato));
		System.out.println(libr.add(mancante));
		
		System.out.println(libr.toString());
	}

}
