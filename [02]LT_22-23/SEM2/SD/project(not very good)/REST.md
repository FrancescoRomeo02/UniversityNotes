**REST**

L’API ReST fornita dal web server alla porta 8080 si trova all’interno della classe ServerResource.java (directory web-server).\\

L’API si occupa di recuperare od inviare informazioni al database tramite socket, per poi rielaborarle e ritornarle al client.\\

- Tramite l’endpoint /home, attraverso il Query Parameter "events", l’API fornisce la lista degli eventi o gli eventi singoli (le proiezioni) che recupera dal database utilizzando le socket.\\

- Tramite l’endpoint /home, attraverso il Query Parameter "id", l’API permette di eliminare una prenotazione dato l’id della stessa, oppure di eliminare la prenotazione di alcuni posti, che verranno resi nuovamente disponibili. Anche in questo caso si utilizzano le funzioni elementari del database, che vengono interpellate dall’API tramite l’apposito protocollo progettato.\\

- Tramite l’endpoint /home è anche possibile effettuare la registrazione di una nuova prenotazione, grazie all’utilizzo delle socket e del succitato protocollo fra server e database.\\
