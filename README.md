# Vehicle Management REST API

Un'API RESTful pronta per la produzione sviluppata con **Spring Boot** e **PostgreSQL** per la gestione e il monitoraggio di una flotta di veicoli urbani. Il progetto implementa pattern architetturali di livello enterprise, garantendo la gestione della concorrenza, il disaccoppiamento dei dati, la paginazione e il pieno rispetto della maturità REST.

## 🚀 Funzionalità Chiave

* **Architettura a Livelli:** Chiara separazione delle responsabilità tra i livelli Web (Controllers), Business Logic (Services) e Data Access (Repositories).
* **Pattern DTO & MapStruct:** Disaccoppiamento completo tra i modelli di persistenza del database e il contratto pubblico dell'API tramite l'uso di Java `record` e mappatura automatica con MapStruct.
* **Gestione della Concorrenza (Optimistic Locking):** Prevenzione delle race condition durante gli aggiornamenti simultanei dello stato dei veicoli mediante l'uso dell'annotazione `@Version` di JPA, restituendo un codice `409 Conflict` in caso di collisione.
* **Validazione dei Dati Strutturata:** Convalida rigorosa dei payload in ingresso tramite vincoli `jakarta.validation` (`@NotBlank`, `@Min`, `@Max`) per intercettare dati malformati a livello di Controller.
* **Paginazione e Ordinamento:** Endpoint di lettura ottimizzati per supportare grandi volumi di dati tramite l'integrazione di `Pageable` e `Page` di Spring Data.
* **Livello 3 di Maturità REST (HATEOAS):** Inclusione di link ipertestuali dinamici nelle risposte JSON per guidare il client sulle azioni disponibili (es. noleggio, manutenzione) in base allo stato attuale del veicolo.
* **Gestione Centralizzata delle Eccezioni:** Intercettazione globale degli errori tramite `@RestControllerAdvice` per garantire risposte HTTP semantiche, pulite e conformi agli standard RFC.

---

## 🛠️ Tech Stack & Dipendenze

* **Java 17 / 21**
* **Spring Boot 3.x**
    * Spring Web
    * Spring Data JPA (Hibernate)
    * Spring HATEOAS
    * Validation
* **PostgreSQL** (Database Relazionale)
* **MapStruct** (Mappatura dei DTO)
* **Maven** (Gestione del ciclo di vita del progetto)

---

## 🚦 Configurazione e Avvio

### Prerequisiti
Assicurati di avere installato:
* **JDK 17** o superiore
* **Maven 3.x**
* **PostgreSQL** (locale o tramite Docker)
* **Git**

### 👥 Clonazione e Esecuzione Locale

1. **Clona il repository:**
   ```bash
   git clone https://github.com/YourUsername/Vehicle-Management-REST-API.git
