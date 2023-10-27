def ric_sq(a, k):
    p=0                             #istruzione n° 1                                            -> c1
    while(k!=a[p] and p<len(a)):    #istruzione n° 2 eseguita ogni volta che il while è vero    -> c2 * true_while
        p+=1                        #istruzione n° 3 eseguita ogni volta che il while è vero    -> c3 * true_while
    if(p<len(a)):                   #istruzione n° 4                                            -> c4
        return p                    #istruzione n° 5 eseguita se l'if è vero                    -> c5 * true_if
    else: 
        return -1                   #istruzione n° 6 eseguita se l'if è vero                    -> c6 * false_if