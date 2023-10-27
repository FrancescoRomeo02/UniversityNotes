**TCP**

Il protocollo TCP scelto per provvedere alla comunicazione fra database e server è personalizzato per la ricerca di indici all’interno del database, che si compone di una chiave in formato String ed un value in formato ArrayList<String>, che permette il salvataggio di più parametri.\\

Il protocollo si basa su stringhe per ragioni di efficienza e per evitare la serializzazione/deserializzazione continua degli oggetti per comunicare fra database e server. \\

La comunicazione si basa su stringhe del tipo "Httpmethod:Parameter1;Parameter2;…;ParameterN".\\

Esempio: una chiamata GET contenente l’indice P1 di una proiezione viene comunicata al database tramite\\

- "get:P1"

Esempio 2: la chiamata POST che invia i dati di una prenotazione è\\

- "post:P2;P2;E2;1A;2A;3A" dove P2 è l’identificativo della prenotazione (la chiave che sarà utilizzata dal database per recuperare il valore associato), E2 è l’identificativo della proiezione e 1A, 2A e 3A sono i posti da riservare.\\

Il database risponde serializzando in forma Element1;Element2;…;ElementN l’ArrayList<String> che ne rappresenta il valore associato alla chiave.\\

Per ritornare tutte le occorrenze di un certo tipo di dato (Prenotazione, Proiezione…) si utilizza semplicemente la lettera comune a tutti gli id di quel tipo.\\

Esempio3: la chiamata GET che richiede tutte le proiezioni è "get:E".\\

- L’identificativo E (E1…En) rappresenta le proiezioni;

- L’identificativo P (P1…Pn) rappresenta le prenotazioni.
