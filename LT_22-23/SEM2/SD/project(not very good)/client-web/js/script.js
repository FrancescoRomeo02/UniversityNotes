// parte relativa ai listener degli eventi.
function allEvents() {
  get('E');
}

window.onload = allEvents;


// Parte relativa alla comunicazione con il server.
const API_URI = "http://localhost:3030/home";

// getFilm api per ottenere i film.
// Questa funzione è generica per le richieste GET a un qualsiasi endpoint.
async function get(KEY) {

  const endpoint = `${API_URI}?events=${KEY}`;

  const response = await fetch(endpoint);

  if (!response.ok)
    throw new Error(`Response from "${endpoint}" was not successful: ${response.status} ${response.statusText}`);

  if(KEY == 'E')
    await response.json().then((items) => items.forEach(addFilmDOM), (error) => onError("Failed", error));
  else if(KEY.includes('E'))
    await response.json().then((items) => items.forEach(Serialize), (error) => onError("Failed", error));
    else if(KEY == 'P')
      return (await response.json());
      else if(KEY.includes('P'))
        await response.json().then((items) => items.forEach(temp), (error) => onError("Failed", error));

  }

  function temp(item){
    let values = item.split(";");
    for (let i = 0; i < values.length; i++) {
      values[i] = values[i].trim();
    }
    if(values[0] != 'null')
      alert("modifica prenotazione: "+ values);
    else
      alert("prenotazione non trovata!");
  }
  
  
  async function post(KEY, data) {
    const endpoint = `${API_URI}`;
    const response = await fetch(endpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });

    alert(JSON.stringify(data));
    if (!response.ok)
      throw new Error(`Response from "${endpoint}" was not successful: ${response.status} ${response.statusText}`);

    alert(JSON.stringify(data));

  }

// Serialize funzione per serializzare i film.
function Serialize(item) {
  // SALVO SOLO I PRIMI 4 
  var array = [];
  var seats = [];
  let tmp = item.split(";");
  for (let i = 0; i < 4; i++) {
    array[i] = tmp[i];
  }
  for (let i = 0; i < 40; i++) {
    seats.push(Math.floor(Math.random() * 3));
  }
  array.push(seats);
  array.push("E1");
  createReservationElement(array);
  alert("Scorri in fonod alla pagina per effettuare la prenotazione!");

}

// addFilmDOM aggiunge un contatto alla tabella.
async function addFilmDOM(film) {
  // divido la stringa in un array di stringhe
  let values = film.split(";");
  for (let i = 0; i < values.length; i++) {
    values[i] = values[i].trim();
  }
  // Creo l'elemento DOM e lo aggiungo alla sezione.
  const section = document.getElementById("movies");
  section.appendChild(createMovieElement(values));
}


 // Funziona di utilità che mostra l'errore nella console e in un alert
 // del browser.
 function onError(msg, error) {
   const out = `${msg}: ${error}`;
   console.error(out);
   alert(out);
 }

// CREAZIONE ELEMENTI DOM
  // Funzione per creare sezioni di film dento movies.

function createMovieElement(array) {
  // Creazione dell'elemento <figure> con la classe "movie"
  var figure = document.createElement("figure");
  figure.className = "movie";
  figure.id = array[0];
  
  // Creazione dell'elemento <div> con la classe "movie__hero"
  var heroDiv = document.createElement("div");
  heroDiv.className = "movie__hero";
  figure.appendChild(heroDiv);
  
  // Creazione dell'elemento <img> con la classe "movie__img"
  var image = document.createElement("img");
  image.src = array[9];
  image.className = "movie__img";
  heroDiv.appendChild(image);
  
  // Creazione dell'elemento <div> con la classe "movie__content"
  var contentDiv = document.createElement("div");
  contentDiv.className = "movie__content";
  figure.appendChild(contentDiv);
  
  // Creazione dell'elemento <div> con la classe "movie__title"
  var titleDiv = document.createElement("div");
  titleDiv.className = "movie__title";
  contentDiv.appendChild(titleDiv);
  
  // Creazione dell'elemento <h1> con la classe "heading__primary" per il titolo
  var heading = document.createElement("h1");
  heading.className = "heading__primary";
  heading.textContent = array[4];
  titleDiv.appendChild(heading);
  
  // Creazione degli elementi <div> con la classe "movie__tag" per i generi
  var genreTag1 = document.createElement("div");
  genreTag1.className = "movie__tag movie__tag--1";
  genreTag1.textContent = "#" + array[5];
  titleDiv.appendChild(genreTag1);
  
  var genreTag2 = document.createElement("div");
  genreTag2.className = "movie__tag movie__tag--2";
  genreTag2.textContent = "#" + array[6];
  titleDiv.appendChild(genreTag2);
  
  // Creazione dell'elemento <p> con la classe "movie__description" per la descrizione del film
  var descriptionPara = document.createElement("p");
  descriptionPara.className = "movie__description";
  descriptionPara.textContent = array[7];
  contentDiv.appendChild(descriptionPara);
  
  // Creazione dell'elemento <div> con la classe "movie__details"
  var detailsDiv = document.createElement("div");
  detailsDiv.className = "movie__details";
  contentDiv.appendChild(detailsDiv);
  
  // Creazione degli elementi <p> con la classe "movie__detail" per i dettagli
  var producerPara = document.createElement("p");
  producerPara.className = "movie__detail";
  producerPara.textContent = "Italia Cinema";
  detailsDiv.appendChild(producerPara);
  
  var durationPara = document.createElement("p");
  durationPara.className = "movie__detail";
  durationPara.textContent = array[8];
  detailsDiv.appendChild(durationPara);
  
  var datePara = document.createElement("p");
  datePara.className = "movie__detail";
  datePara.textContent =  array[3];
  detailsDiv.appendChild(datePara);
  
  var theaterPara = document.createElement("p");
  theaterPara.className = "movie__detail";
  theaterPara.textContent = "Sala: " + array[1];
  detailsDiv.appendChild(theaterPara);
  
  // Creazione dell'elemento <button> con la classe "movie__detail__button" per la prenotazione al click del bottone allert con i dettagli del film
  var reservationButton = document.createElement("button");
  reservationButton.className = "movie__detail__button";
  reservationButton.textContent = "Prenota";
  reservationButton.id = array[0];
  detailsDiv.appendChild(reservationButton);

  return figure;
}

// add event listener to reservation button
document.addEventListener('click', function (event) {
  // If the clicked element doesn't have the right selector, bail
  if (!event.target.matches('.movie__detail__button')) return;
  event.preventDefault();
  var movieId = event.target.id;
  get(movieId);
}, false);
// Funzione per creare la sezione con le prenotazioni.

function createReservationElement(array) {
  // elimina la sezione con le prenotazioni
  var reservationsDivDell = document.getElementById("reservations");
  reservationsDivDell.innerHTML = "";

  title = array[0];
  theater = array[1];
  date = array[2];
  time = array[3];
  seats = array[4];
  idP = "P"+Math.floor(Math.random() * 99) + 6;
  // Creazione dell'elemento <div> con l'ID "reservations"
  var reservationsDiv = document.getElementById("reservations");
  
  // Creazione dell'elemento <figure> con la classe "reservation"
  var figure = document.createElement("figure");
  figure.className = "reservation";
  reservationsDiv.appendChild(figure);
  
  // Creazione dell'elemento <div> con la classe "reservation__content"
  var contentDiv = document.createElement("div");
  contentDiv.className = "reservation__content";
  figure.appendChild(contentDiv);
  
  // Creazione dell'elemento <div> con la classe "preservation__title"
  var titleDiv = document.createElement("div");
  titleDiv.className = "preservation__title";
  contentDiv.appendChild(titleDiv);
  
  // Creazione dell'elemento <h1> con la classe "preservation__heading__primary" per il titolo
  var heading = document.createElement("h1");
  heading.className = "preservation__heading__primary";
  heading.textContent = "Codice prenotazione: " + idP;
  titleDiv.appendChild(heading);
  
  // Creazione degli elementi <div> con la classe "reservation__tag" per sala, data e orario
  var theaterTag = document.createElement("div");
  theaterTag.className = "reservation__tag reservation__tag--1";
  theaterTag.textContent = "Sala: "+ theater;
  titleDiv.appendChild(theaterTag);
  
  var dateTag = document.createElement("div");
  dateTag.className = "reservation__tag reservation__tag--2";
  dateTag.textContent = date;
  titleDiv.appendChild(dateTag);
  
  var timeTag = document.createElement("div");
  timeTag.className = "reservation__tag reservation__tag--3";
  timeTag.textContent = time;
  titleDiv.appendChild(timeTag);
  
  // Creazione dell'elemento <table> con la classe "reservation__seats" per i posti
  var seatsTable = document.createElement("table");
  seatsTable.className = "reservation__seats";
  seatsTable.id = title;
  contentDiv.appendChild(seatsTable);

  // Creazione delle righe della tabella
  var rows = Math.floor(seats.length/10);
  var seats_for_row = Math.floor(seats.length/rows);

  var start = 0;
  var end = seats_for_row;

  for (var j = 0; j < rows; j++){
    // Creazione della riga della tabella
    var row = document.createElement("tr");
    
    // Creazione dei posti nella tabella
    for (var i = start; i < end; i++) {
      var seat = document.createElement("td");
      seat.className = "reservation__seat";
      
      // Aggiunta della classe corrispondente allo stato del posto
      if (seats[i] === 1) {
        seat.classList.add("reservation__seat--available");
      } else if (seats[i] === 2) {
        seat.classList.add("reservation__seat--occupied");
      } else if (seats[i] === 3) {
        seat.classList.add("reservation__seat--reserved");
      }
      seat.textContent = (i + 1)-(10*j) + String.fromCharCode(65 + j);
      seat.id = (i + 1)-(10*j) + String.fromCharCode(65 + j);
      seat.addEventListener('click', function (event) {
        let id = event.target.id;
        document.getElementById(id).classList.toggle("reservation__seat--selected");
      }, false);
      row.appendChild(seat);
    }
    start = end;
    end += seats_for_row;
    seatsTable.appendChild(row);
  }

      // bottone per confermare la prenotazione
      var confirmButton = document.createElement("button");
      confirmButton.className = "reservation__confirm";
      confirmButton.textContent = "Conferma";
      confirmButton.id = title;
      contentDiv.appendChild(confirmButton);
      confirmButton.addEventListener('click', function (event) {
        let id = event.target.id;
        let posti = document.getElementsByClassName("reservation__seat--selected");
        let posti_selezionati = [];
        for (let i = 0; i < posti.length; i++) {
          posti_selezionati.push(posti[i].id);
        }
        // modifica posti_selezionati dividendoli con ;
        posti_selezionati = posti_selezionati.join(';');
        alert("Posti prenotati: " + posti_selezionati);
        posti_selezionati= idP+";"+idP +";"+ posti_selezionati;
        post(idP, posti_selezionati);
      });

}

async function gestisci() {
  // prompt per inserire il codice prenotazione
  var code = prompt("Inserisci il codice prenotazione da gestire:");
  // chiamata al server per ottenere i dati della prenotazione
  var response = await get(code)
}