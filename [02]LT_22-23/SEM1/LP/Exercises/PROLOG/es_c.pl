% esercizio 1
% definire un predicaro countd/3 tale che 
% countd(L1, E, V) è vero se E compare in L1 V volte

countd([], _, 0).

countd([E | L1], E, V) :- 
    countd(L1, E, V1), 
    V is V1 + 1. 

countd([E1 | L1], E, V) :- 
    E1 \= E, 
    countd(L1, E, V). 



% esercizio 1.1
countd2([], _, 0).

countd2([L1 | L1S], E, V) :- 
    L1 = E,
    V1 is V - 1,
    countd2(L1S, E, V1). 

countd2([L1 | L1S], E, V) :- 
    L1 \= E,
    countd2(L1S, E, V). 


% esercizio 2
% definire un predicato countd/3 che considera anche le occorrenze di E in L1 come sotto-liste


% esercizio 3
% definire un predicato subarray/2 tale che subarray(L1, L2) è vero se L2 è una sottolista di L1

subarray(_, []).

subarray([L | Ls], [L2 | L2s]) :- 
    L = L2,
    subarray(Ls, L2s).

subarray([L | Ls], [L2 | L2s]) :- 
    L \= L2,
    subarray(Ls, [L2 | L2s]).


% esercizio 4
% definire un predicato subsequence/2 tale che subsequence(L1, L2) è vero se L2 è una sottolista di L1.
% non riesco a capire la differenza con quello sopra, scusate =( 
subsequence([], []).

subsequence(L, L).

subsequence([L | Ls], [L2 | L2s]) :- 
    L = L2,
    subsequence(Ls, L2s).

subsequence([L | Ls], [L2 | L2s]) :-
    L \= L2,
    subsequence(Ls, [L2 | L2s]).

% esercizio 5
% definire un predicato flatten/2 tale che flatten(L1, L2) è vero se L2 è lo spacchettamento di L1

% esercizio 6
% rimuovi n-esimo elemento da una lista e ritorna elemento e lista
rimuovi([L | Ls], Ls, 0).
rimuovi([L | Ls], [L | Ls1], N) :- 
    N1 is N - 1,
    rimuovi(Ls, Ls1, N1).

% esercizio 7
% definire un predicato double/2 tale che double(L1, L2) è vero se L2 è la lista ottenuta da L1 in cui ogni elemento è ripetuto due volte

double([], []).

double([X | XS], [X, X | YS]):-
    double(XS, YS). 
    

% esercizio 8
% predicato sostituisci/4 tale che sostituisci(L1, E1, E2, L2) è vero se L2 è la lista ottenuta da L1 sostituendo ogni occorrenza di E1 con E2
sostituisci(_,_,[],[]) :- !.

sostituisci(Old, New, [Old|T], [New|T1]) :- 
    !, 
    sostituisci(Old, New, T, T1).

sostituisci(Old, New, [H|T], [H|T1]) :- 
    H \= Old,
    sostituisci(Old, New, T, T1).


