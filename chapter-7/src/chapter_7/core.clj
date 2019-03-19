(ns chapter-7.core
  (:gen-class))

(defn -main
  [& args]
  (println "Hello, Welcome to Chapter 7 Assignment"))

;Exercise -1 :  Use the list function, quoting, and read-string to create a list.
; using quoting
(eval (read-string "'(:Rahul DejaWo)"))

; using list
(eval (list read-string "(:Rahul DejaWo)"))

;Exercise -2 : Create an infix function that takes a list like (1 + 3 * 4 - 5) and transforms into expression using operator precedence rules.
 ;  (Soon will give optimized and Generic Solution)
 
(def number-list '(1 + 3 * 4 - 5))

(defn my-infix [x]
	  "Infix operation"
	(list (nth x 1) (nth x 3) (nth x 5) (nth x 0) (nth x 2) (nth x 4) (nth x 6)))
	
 ; Example - calling
;(my-infix number-list)  