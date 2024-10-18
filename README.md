# Scommesse Sportive

Sviluppato da **Andrea Serra**

## Installazione

Per eseguire questa applicazione localmente, assicurati di avere i seguenti prerequisiti installati:

- Java 17 o superiore
- Maven
- MySQL (o un altro database relazionale supportato)

Esegui il download del repository tramite questo link:

```
https://github.com/Andreaserra1997/scommesse_sportive
```

Configura il database e aggiorna **application.properties** con le tue credenziali MySQL:

```
#data source
spring.datasource.url=jdbc:mysql://localhost:3306/{nome del tuo database}
spring.datasource.username={username}
spring.datasource.password={password}
```

**Avvia l'applicazione**

<br>

## Panoramica

L'API Bet è un servizio web RESTful progettato per gestire eventi sportivi e le relative scommesse. L'applicazione
fornisce un set di endpoint per creare, visualizzare, aggiornare e cancellare eventi sportivi e scommesse, permettendo
una gestione completa del ciclo di vita delle scommesse.

## Funzionalità principali

### Eventi

L'applicazione consente di gestire eventi sportivi. Ogni evento è identificato da un ID univoco e include dettagli come:

<ul>
<li><strong>Nome dell'evento</strong>: il nome della partita o della competizione.</li>
<li><strong>Data e ora:</strong> quando si svolgerà l'evento.</li>
<li><strong>Quote:</strong> le probabilità iniziali associate all'evento, utili per calcolare il valore delle scommesse.</li>
</ul>

Gli eventi rappresentano il contesto principale delle scommesse, e una volta creato un evento, gli utenti possono
associare scommesse a esso. È possibile aggiornare le informazioni sugli eventi e cancellarli quando non sono più
necessari.

### Scommesse

Gli utenti possono creare scommesse sugli eventi sportivi esistenti. Ogni scommessa è associata a un evento specifico
tramite una relazione <strong>uno-a-molti</strong>:

<ul>
<li>Un <strong>evento</strong> può avere più <strong>scommesse</strong> (relazione uno-a-molti).</li>
<li>Ogni <strong>scommessa</strong> è legata a un singolo <strong>evento</strong> (chiave esterna).</li>
</ul>

Le scommesse contengono le seguenti informazioni:

<ul>
<li><strong>Tipo di scommessa:</strong> definisce il risultato su cui si sta scommettendo (es. vittoria di una squadra, pareggio).</li>
<li><strong>Importo:</strong> la somma di denaro scommessa.</li>
</ul>

<br>

## API Endpoints

### 1. Eventi Sportivi

### Descrizione: Recupera tutti gli eventi sportivi.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>GET</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/events</strong></li>
<li>Clicca su <strong>SEND</strong></li>
</ol>

**Risposta**

```
[
  {
	"id": 1,
	"name": "Juventus vs Milan",
	"date": "2024-10-15T20:30:00",
	"odds": {
  	"team1Win": 1.5,
  	"team2Win": 3.2,
  	"draw": 2.8
	}
  }
]
```

### Descrizione: Crea un nuovo evento sportivo.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>POST</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/events</strong></li>
<li>
<strong>Imposta l'header:</strong> Assicurarsi di specificare il tipo di contenuto della richiesta per fare in modo che Spring Boot interpreti correttamente il payload
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Vai alla sezione <strong>Body</strong>, seleziona <strong>raw</strong>, e imposta il tipo su <strong>JSON</strong></li>
<li>Inserisci il seguente <strong>JSON:</strong></li>

```
{
  "name": "Inter vs Napoli",
  "date": "2024-10-16T18:00:00",
  "odds": {
	"team1Win": 1.21,
	"team2Win": 4.65,
	"draw": 3.52
  }
}
```

<li>Clicca su <strong>SEND</strong></li>
</ol>

### Descrizione: Aggiorna i dettagli di un evento sportivo esistente identificato dall'ID.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>PUT</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/events/{id}</strong></li>
<li>
<strong>Imposta l'header:</strong> Assicurarsi di specificare il tipo di contenuto della richiesta per fare in modo che Spring Boot interpreti correttamente il payload
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Vai alla sezione <strong>Body</strong>, seleziona <strong>raw</strong>, e imposta il tipo su <strong>JSON</strong></li>
<li>Inserisci il seguente <strong>JSON:</strong></li>

```
{
  "name": "Inter vs Napoli",
  "date": "2024-10-17T20:45:00",
  "odds": {
	"team1Win": 1.32,
	"team2Win": 4.25,
	"draw": 3.16
  }
}
```

<li>Clicca su <strong>SEND</strong></li>
</ol>

### Descrizione: Cancella un evento specifico identificato dal suo ID.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>DELETE</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/events/2 (dove 2 è l'ID dell'evento da cancellare)</strong></li>
<li>Clicca su <strong>SEND</strong></li>
</ol>

### Descrizione: Visualizza un singolo evento sportivo tramite l'ID.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>GET</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/events/{id}</strong></li>
<li>Clicca su <strong>SEND</strong></li>
</ol>

### 2. Scommesse

### Descrizione: Recupera tutte le scommesse per uno specifico evento sportivo.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>GET</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/bets?eventId=1</strong></li>
<li>Clicca su <strong>SEND</strong></li>
</ol>

**Risposta**

```
[
  {
	"betId": 1,
	"eventId": 1,
	"betType": "team1Win",
	"amount": 100.0
  },
  {
	"betId": 2,
	"eventId": 1,
	"betType": "draw",
	"amount": 50.0
  }
]
```

### Descrizione: Crea una nuova scommessa per un evento.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>POST</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/bets</strong></li>
<li>
<strong>Imposta l'header:</strong> Assicurarsi di specificare il tipo di contenuto della richiesta per fare in modo che Spring Boot interpreti correttamente il payload
<ul>
<li>Key: <strong>Content-Type</strong></li>
<li>Value: <strong>application/json</strong></li>
</ul>
</li>
<li>Vai alla sezione <strong>Body</strong>, seleziona <strong>raw</strong>, e imposta il tipo su <strong>JSON</strong></li>
<li>Inserisci il seguente <strong>JSON:</strong></li>

```
{
  "eventId": 1,
  "betType": "draw",
  "amount": 25.0
}

```

<li>Clicca su <strong>SEND</strong></li>
</ol>

### Descrizione: Cancella una scommessa specifica identificata dal suo ID.

**Esempio di utilizzo in Postman:**

<ol>
<li>Crea una nuova richiesta</li>
<li>Seleziona il metodo <strong>DELETE</strong></li>
<li>Inserisci l'URL: <strong>http://localhost:8080/api/bets/2 (dove 2 è l'ID della scommessa da cancellare)</strong></li>
<li>Clicca su <strong>SEND</strong></li>
</ol>

<br>