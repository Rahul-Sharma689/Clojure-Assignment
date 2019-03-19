(ns chapter-5.core
  (:gen-class))

(defn -main
  [& args]
  (println "Welcome to Chapter 5"))

; Exercise -1 
(def character
	{:name "Smooches McCutes"
	:attributes {:intelligence 10
	:strength 4
	:dexterity 5}})

(defn attr
    "give nested attribute value"
	[att-value]
	(comp ((get-in character [:attributes])att-value)))
	
	;Example
	;  (attr :intelligence)
 
 
 ; Exercise 3 - Implement the assoc-in function. Hint: use the assoc function and
(defn my-assoc-in
  [m [k & kws] v]
  (if kws
    (assoc m k (my-assoc-in (get m k) kws v))
    (assoc m k v)))
	
	;Example
    ;(my-assoc-in {} [:Profile :Automation :Skill] "Clojure")
	;(my-assoc-in {} [:Profile] "Automation")

; Exercise 2- comp implementation
(defn my-comp
	"my comp function"
	[fn1 fn2]
	(fn [& args]
	(fn1 (reduce fn2 args))))

 ;((my-comp + *) 8 7)
 
 ; Exercise 4- use the update-in function.
;update-in function.
(def car {:name "Tata-Nexon" :avg 15 :Model 2018})
	(update-in car[:avg] + 10)

; Results
;#'user/car
;{:name "Tata-Nexon", :avg 25, :Model 2018}

;Exercise - 5 
(defn my-update-in
  "My Update-in"
  [m [k & kws] func & args]
  (assoc m k (apply my-update-in (get m k) kws func args)))
  
  (def users {:kyle {
	:date-joined "2009-01-01"
	:summary {
	:average {
	:monthly 1000
	:yearly 12000}}}})
	
 ; Example- 
 ;(update-in users [:kyle :summary :average :monthly] + 700)

