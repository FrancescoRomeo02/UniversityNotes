;; somma lista di numeri 

(defun somma-numeri (lista) 
    (if (null lista)
        0
        (+ (car lista) (somma-numeri (cdr lista)))))

(print (somma-numeri '(1 2 3)))


;; sostituisci valore
( defun sostituisci ( lista valore nuovo-valore)
    (if (null lista)
        '()
        (cons 
         (if (eql (car lista) valore) 
            nuovo-valore 
            (car lista))
         (sostituisci-valore (cdr lista) valore nuovo-valore)
         )
        )
    )

(sostituisci '(1 2 3 4 5) 3 10)


;; elimina duplicati
(defun elimina-duplicati (lista)
  (if (null lista)
      '()
      (let ((lista-unica '()))
        (if (not (member (car lista) lista-unica))
            (setf lista-unica (cons (car lista) lista-unica)))
        (append lista-unica (elimina-duplicati (cdr lista))))))

;;;; funzione aggiungi che data una lista fa +1 degli elementi dispari ( ricorsiva )

(defun aggiungi (lst)
  (cond 
      ((null lst) nil)
      ((evenp (car lst)) (cons (car lst) (aggiungi (cdr lst))))
      (t (cons (1+ (car lst)) (aggiungi (cdr lst))))))

;;;; aggiungi 2.0

(defun foo (lst)
    (cond
        ((null lst) nil)
        ((listp (car lst)) (cons
                            (foo (car lst))
                            (foo (cdr lst))))
        ((and (numberp (car lst)) (oddp (car lst))) (cons
                                                    (+ 1 (car lst))
                                                    (foo (cdr lst))))
        (t (cons (car lst) (foo (cdr lst))))))

(print (foo '(1 2 3 (4 (5 ((6)) 7)) 5 f (h 5))))



;;;; funzione nopred che rimuove i termini da una lista che verificano il predicato
(defun nopred (prd lst)
    (cond
        ((null lst) nil)
        ((listp (car lst)) (cons
                            (nopred prd (car lst))
                            (nopred prd (cdr lst))))
        ((ignore-errors(funcall prd (car lst))) 
         (nopred prd (cdr lst)))
        (t (cons 
            (car lst)
            (nopred prd (cdr lst))))))

;;;; da let a lambda e inverso
(defun f (x y)
    (let ((a (+ x y))
          (b (- x y)))
        (+ (* x a)
           (* y b)
           (* a b))))

(defun f2 (x y)
    ((lambda (a b)
       (+ (* x a)
          (* y b)
          (* a b)))
     (+ x y)
     (- x y)))

(defun f22 (x y)
    (let ((a (+ x y))
         (b (- x y)))
    (+ (* x a)
       (* y b)
       (* a b))))

(defun f222 (x y)
    ((lambda (a b)
             (+ (* x a)
                (* y b)
                (* a b)))
             (+ x y)
             (- x y)))

(defun f3 (x y)
    (let ((a (+ x y))
          (b (- x y)))
        (+ (* x a)
        (* y b)
        (* a b))))       
            

(defun f4 (x y)
    ((lambda (a b)
            (+ (* x a)
                (* y b)
                (* a b)))
        (+ x y)
        (- x y)))



;;;; lista per-due: funzione che invoca per-due a tutti i num dispari di una lista
(defun per-due (n)
    (* n 2))

(defun lista-per-due (lst)
    (cond 
        ((null lst) nil)
        ((listp (car lst)) (cons
                            (lista-per-due (car lst))
                            (lista-per-due (cdr lst))))
        ((oddp (car lst)) (cons
                           (per-due (car lst))
                           (lista-per-due (cdr lst))))
        (t (cons
            (car lst)
            (lista-per-due (cdr lst))))))



    
;; funzione che calcola la media di una lista
(defun media (lst)
    (cond
        ((null lst) nil)
        ((listp (car lst)) (cons
                            (media (car lst))
                            (media (cdr lst))))
        (t (cons
            (/ (car lst) (length lst))
            (media (cdr lst))))))

;;;; conta occorrenze di l1 in l2
(defun foo (l1 l2)
    (cond
        ((null l1) nil)
        ((null l2) nil)
        ((member (car l1) l2) (cons (car l1) (foo (cdr l1) l2)))
        (T (foo (cdr l1) l2))))


;;;; somma 42 ai pari
(defun foo (l1)
    (cond
        ((null l1) nil)
        ((listp (car l1)) (cons
                           (foo (car l1))
                           (foo (cdr l1))))
        ((and (numberp (car l1)) (evenp (car l1))) (cons
                                                   (+ 42 (car l1))
                                                   (foo (cdr l1))))
        (T (cons (car l1) (foo (cdr l1))))))


;;;; funzione che prese due funzioni ritorna una funzione composta (f o g)
(defun comp (f g)
    (lambda (x) (funcall f (funcall g x))))

;;;; test comp
(defun f (x) (+ x 1))
(defun g (x) (* x 2))
(defun h (x) (- x 3))

(funcall (comp 'f 'g) 5)

;;;; funzione che ritrona true se la fbf ha tutti gli or che sono clausole di horn
(defun horn (fbf)
    (cond
        ((null fbf) t)
        ((and (listp (car fbf)) (not (member 'or (car fbf)))) nil)
        (T (horn (cdr fbf)))))

;;;; Costruite la funzione reduce 
;;;; che prende una funzione binaria e una lista e produce come risultato la combinazione associativa a SINSTRA degli elementi della list.  
;;;; Potete assumere che la lista abbia almeno due elementi.

(defun reduce (f lst)
    (cond
        ((null lst) nil)
        ((null (cdr lst)) (car lst))
        (T (funcall f (car lst) (reduce f (cdr lst))))))