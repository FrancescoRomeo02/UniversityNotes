%%%% -*- Mode: Prolog -*-

%%%% treemaps.pl
%%%%
%%%% Copyright (c) 2021 Marco Antoniotti, DISCo UNIMIB.
%%%% All rights reserved.
%%%%
%%%% A simple implementation of a Dictionary Abstract Data Type based
%%%% on Binary Search Trees.
%%%%
%%%% The notation for the predicates' signatures can be found at
%%%% https://www.swi-prolog.org/pldoc/man?section=preddesc


%%% is_node/1.
%%% is_node(+Something)
%%%
%%% True when the argument is a node in a tree.
%%% Note that the test is not recursive for efficiency reasons.

is_node(void).
is_node(node(_Key, _Value, _Left, _Right)).


%%% is_leaf/1.
%%% is_leaf(+Something)
%%%
%%% True when the argument is a leaf in a tree.

is_leaf(node(_Key, _Value, void, void)).


%%% treemap
%%%
%%% A treemap is a handle in the database.  A treemap has an id and a
%%% root that is a node.
%%% The 'dynamic' declaration is necessary in SWI-Prolog to let the
%%% system know that we will be adding and removing treemaps at will.

:- dynamic treemap/2.


%%% is_treemap/1
%%% is_treemap(+Something)
%%%
%%% This predicate is true when the argument Something is a treemap.

is_treemap(treemap(_Id, Root)) :- is_node(Root).


%%% new_treemap/1
%%% new_treemap(++Id)
%%%
%%% The predicate is always true and is asserts a new treemap term
%%% with identifier Id, if not already present.

new_treemap(Id) :- treemap(Id, _Root), !.
new_treemap(Id) :- assert(treemap(Id, void)), !.


%%% del_treemap/1
%%% del_treemap(++Id)
%%%
%%% The predicate is true when a treemap fact with identifier Id is
%%% removed from the database.

del_treemap(Id) :- retract(treemap(Id, _Root)).


%%% is_treemap_empty/2
%%% is_treemap(++Id, -Flag).
%%%
%%% The predicate is true with Flag unifies with one of the atoms
%%% 'true', 'nonempty', and 'nonexistant'.  The first case succeeds
%%% when the treemap exists and is empty.  The second case succeeds
%%% when the treema exists and is non-empty.  Finally the third case
%%% succeeds when a treemap with identifier Id does not exists in the
%%% database.

is_treemap_empty(Id, true) :- treemap(Id, void), !.
is_treemap_empty(Id, nonempty) :- treemap(Id, Root), Root \= void, !.
is_treemap_empty(_Id, nonexistant) :- !.


%%% is_treemap_bst/1
%%% is_treemap_bst(++Id)
%%%
%%% True when the treemap is a Binary Search Tree.
%%%
%%% Notes:
%%% Remember that not all binary trees are binary *search* trees.

is_treemap_bst(Id) :-
    treemap(Id, Root),
    is_bst(Root).


%%% treemap_search/3
%%% treemap(++Id, ++Key, -Value)
%%%
%%% The predicate is true when a Value associated to Key can be found
%%% in a treemap with identifier Id.

treemap_search(Id, Key, Value) :-
    treemap(Id, Root),
    node_search(Root, Key, Value).


%%% treemap_insert/3
%%% treemap_insert(++Id, ++Key, +Value)
%%%
%%% The predicate is true when a Value associated to Key is inserted
%%% in a treemap with identifier Id.  The predicate modifies the
%%% database.

treemap_insert(Id, Key, Value) :-
    treemap(Id, Root),
    node_insert(Root, Key, Value, NewRoot),
    retract(treemap(Id, Root)),
    assert(treemap(Id, NewRoot)).


%%% treemap_delete/2
%%% treemap_delete(++Id, ++Key)
%%%
%%% The predicate is true when the treemap identified by Id will
%%% eventually have any association with Key removed from it.
%%% This predicate modifies the database.


%%% treemap_minimum/3
%%% treemap_minimum(++Id, -Key, -Value)
%%%
%%% The predicate is true when Key is the minimum one present in the
%%% treemap with identifier Id and Value is its associate value.


%%% treemap_maximum/3
%%% treemap_maximum(++Id, -Key, -Value)
%%%
%%% The predicate is true when Key is the maximum one present in the
%%% treemap with identifier Id and Value is its associate value.


%%% treemap_successor/4
%%% treemap_successor(++Id, ++Key, -SuccKey, -SuccValue)
%%%
%%% The predicate is true when, given a Key, SuccKey is the 'next' one
%%% in the treemap with identifier Id; SuccValue is the value
%%% associated to SuccKey.
%%% The predicate fails if there is no 'next' key in the treemap.


%%% treemap_predecessor/4
%%% treemap_predecessor(++Id, ++Key, -PredKey, -PredValue)
%%%
%%% The predicate is true when, given a Key, PredKey is the 'previous'
%%% one in the treemap with identifier Id; PredValue is the value
%%% associated to PredKey.
%%% The predicate fails if there is no 'previous' key in the treemap.


%%% treemap_print/1
%%% treemap_print(++Id)
%%%
%%% The predicate succeeds while printing a text-based representation
%%% of the treemap with identifier Id to the Prolog REPL.

treemap_print(Id) :-
    treemap(Id, Root),
    node_print(Root, '', 0).


%%% is_bst/1
%%% is_bst(+Node)
%%%
%%% True when Node is the (sub)root of a Binary Search Tree.
%%%
%%% Notes:
%%% Remember that not all binary trees are binary *search* trees.


%%% node_search/3
%%% node_search(+Node, ++Key, -Value)
%%%
%%% The predicate is true when the pais (Key, NV) can be found in the
%%% (sub)tree rooted at Node.  Key must be fully instantiated.

node_search(node(NK, NV, _, _), Key, NV) :-
    NK = Key,
    !.
node_search(node(NK, _, _, NRight), Key, Value) :-
    NK < Key,
    !,
    node_search(NRight, Key, Value).
node_search(node(NK, _, NLeft, _), Key, Value) :-
    NK > Key,
    !,
    node_search(NLeft, Key, Value).


%%% node_insert/4 
%%% node_insert(+Node, ++Key, -Value)
%%%
%%% Inserts a pair (K, V) into the subtree rooted at Node.
%%% The predicate is true when the fourth argument is the new
%%% (sub)tree resultng from the insertion of the (K, V) pair.

node_insert(void, K, V, node(K, V, void, void)) :-
    !.
node_insert(node(NK, _, NLeft, NRight),
            Key,
            Value,
            node(NK, Value, NLeft, NRight)) :-
    NK = Key,
    !.
node_insert(node(NK, NV, NLeft, NRight),
            Key,
            Value,
            node(NK, NV, NLeft, NewNRight)) :-
    NK < Key,
    !,
    node_insert(NRight, Key, Value, NewNRight).
node_insert(node(NK, NV, NLeft, NRight),
            Key,
            Value,
            node(NK, NV, NewNLeft, NRight)) :-
    NK > Key,
    !,
    node_insert(NLeft, Key, Value, NewNLeft).


%%% node_print/3 
%%% node_print(+Node, ++Pos, +Level)
%%%
%%% Prints a subtree rooted at Node, indenting Level spaces.
%%% The Pos argument tells the printing procedure to mark a node as a
%%% "left" or "right" subtree root (or possibly as a root tout court).

node_print(void, _, _).
node_print(node(K, V, L, R), Pos, Level) :-
    tab(Level),
    write(Pos),
    write(': '),
    write(K),
    write(' ==> '),
    write(V),
    nl,
    L1 is Level + 4,
    node_print(L, '<', L1),
    node_print(R, '>', L1).

%%%% end of file -- treemaps.pl %%%%