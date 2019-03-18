(ns chapter-3.core
  (:gen-class))

(defn -main[]
	(println "Welcome to Chapter 3 Assignment"))

; Exercise-3 :Write a function that takes a number and adds 100 to it.
(defn exercise_2 [num]
	;Taking single numeric value 
	(print (str "Number after increment" ":" (+ num 100))))

; Exercise-1 :Use the str, vector, list, hash-map, and hash-set functions.
(defn exercise_1 []
	(println "Delineation  and Concatenation of String")
	
	(def test_string "We are learning Clojure")
	(println (str "Welcome" "! "test_string))
	
	(println "--- map practice ---")

	(def Candidate {:Name "Jhon" :Address {:City "NewYork" :Country "USA"} :Exp 5 :Profile "SDET"})

	(println "----Looking up values in maps with the get function---")
	(println "Candidate Name:"(get Candidate :Name ))
	(println "Total Number of Experience:"(get Candidate :Exp ))

	(println "---Looking up nested values in maps using get-in---")
	(println "Candidate City:"(get-in Candidate [:Address :City] ))
	(println "Candidate Country:"(get-in Candidate [:Address :Country]))

	(println "---Treating the map like a function with the key as its argument--")
	(println "Candidate Profile:"(Candidate :Profile ))

	(println "--- Vector practice ---")
	(def basket [1 "Mango" 12.45])
	(println "Get Mango out of basket:"(get basket 1 ))
	(println "Add orange into basket:"(conj basket "Orange" ))

	(println "--- List practice ---")
	(println "Second element of list:" (nth '(:a :b :c) 1))
	(println "Adding new element in List:" (conj '(1.2 7 3) 15))

	(println "--- Set practice ---")
	(println "Hash set values:" #{"Apple" 21 :CLJ})
	(println "Converting Vector into Hash:" (set [1 2 1 3 4 3]))
	(println "Asserting value Apple contains in Hash:" (contains? #{:Apple :Orange} :Apple)))

;Exercise-3 : Write a function, dec-maker, that works exactly like the function inc-maker
(defn dec-maker  
	"Create a custom decrementor" 
	(println "--- Customize Decrementor  Exercise 3---")
	[dec-by]
	
	#(- % dec-by))