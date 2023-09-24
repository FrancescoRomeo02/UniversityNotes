works(piton, hogwarts,insegnante).
works(jeck, perla_nera, pirata).
works(clark, ufficio, supereroe).
works(jordan, oakmont, broker).
works(gazza, hogwarts, bidello).
works(matteo, pizzeria_sorriso, chef).
works(lorenzo, pizzeria_sorriso, lava_piatti).
works(paolo, chiesa_di_maresso, don).
works(leao, milan, attaccante).
works(tonali, milan, centrocampista).
works(theo, milan, terzino).
colleghi(X, Y) :-
    works(X, A, _),
    works(Y, A, _),
    X \= Y.
/*
 * con _ indico una variabile che non mi interessa,
 * con \= indico il diverso
 */

/* Lista dei predicati:
   * atom(42).  controlla se ho un atomo 
   * compound(foo(42)).  controlla che stia passando qualcosa di composto
   * var(Variabile).  controlla che Var sia una variabile 
   * number(42).  controlla che sia un numero 
   * string("stringa"). controlla che sia una lista
   * member(x, list). controlla se x sta in list
   * append(l1,l2,l3). Controlla che l3 sia l1+l2
   */

/* Liste, matrici e simili */
List = [1, 2, 3, 4].
List_of_List = [[1,2],[2,3], 3].
Matrix = [[1,0,0],[0,1,0],[0,0,1]].
		       
