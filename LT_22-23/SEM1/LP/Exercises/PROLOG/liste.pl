
appendi([], L2, L2).
appendi([L | L1], L2, [L | L3]) :-
    appendi(L1, L2, L3).    



listref([L | _], 0, L) :- !. 
listref([_ | L], N, E) :-
    N > 0,
    !,
    N1 is N - 1,
    listref(L, N1, E). 


part(E, [E |_]):- !.
part(E, [_ | L]) :-
    part(E, L).

subsetITA([], _).
subsetITA([X | Xs], [X | Ys]) :- 
    subset(Xs, Ys), 
    !.
subsetITA(Xs, [_ | Ys]) :- 
    subset(Xs, Ys).