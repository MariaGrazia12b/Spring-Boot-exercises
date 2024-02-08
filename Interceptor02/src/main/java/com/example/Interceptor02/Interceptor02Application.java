package com.example.Interceptor02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*Scrivi un'applicazione Spring Boot con le dipendenze necessarie che:

		Lavora con un'entità Month che ha i seguenti attributi:
		un numero intero monthNumber
		un englishName
		un italianName
		un germanName
		Ha due controller:
		BasicController che:
		accoglie l'utente sulla mappatura radice
		MonthController che:
		è mappato su /months
		restituisce un Mese utilizzando un attributo di richiesta specifico
		Ha un interceptor/middleware chiamato MonthInterceptor che:
		ha una lista di 6 Mesi
		prende l'intestazione monthNumber dalla richiesta
		se monthNumber è nullo/vuoto, restituisce un errore HTTP Bad Request
		altrimenti:
		controlla se il monthNumber passato è presente nella lista
		se presente, lo restituisce utilizzando un attributo di richiesta specifico
		altrimenti, restituisce un Mese vuoto con tutti i valori di stringa impostati su "nope"
		restituisce uno stato HTTP OK
		Testa la chiamata dell'endpoint utilizzando Postman e considerando almeno 4 casi:
		l'intestazione monthNumber è assente
		l'intestazione monthNumber è vuota
		l'intestazione monthNumber ha un valore che è nella lista
		l'intestazione monthNumber ha un valore che non è nella lista*/

@SpringBootApplication
public class Interceptor02Application {

	public static void main(String[] args) {
		SpringApplication.run(Interceptor02Application.class, args);
	}

}
