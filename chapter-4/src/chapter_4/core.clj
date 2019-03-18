(ns chapter-4.core
  (:gen-class))
(def filename "suspects.csv")
 
(defn -main
  [& args]
  (println "Welcome to Chapter 4"))
  
def vamp-keys [:name :glitter-index])
(defn str->int
	[str]
	(Integer. str))

(def conversions {:name identity
	:glitter-index str->int})

(defn convert
	[vamp-key value]
	((get conversions vamp-key) value))

(defn parse
	"Convert a CSV into rows of columns"
	[string]
	(map #(clojure.string/split % #",")
	(clojure.string/split string #"\n")))

(defn mapify
	"Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
	[rows]
	(map (fn [unmapped-row]
	(reduce (fn [row-map [vamp-key value]]
	(assoc row-map vamp-key (convert vamp-key value)))
	{}
	(map vector vamp-keys unmapped-row)))
	rows))

(defn glitter-filter
	[minimum-glitter records]
	(filter #(>= (:glitter-index %) minimum-glitter) records))

;Exercise -1 (Turn the result of your glitter filter into a list oxf names.)
(defn turning-glitter-into-name [minimum-glitter records]
	(map :name (filter #(>= (:glitter-index %) minimum-glitter) records)))
		 
;Exercise -2 Write a function, append, which will append a new suspect to your list of suspect
(defn append-suspect
	[name glitter-value]
		(conj (mapify (parse (slurp filename))) {:name name :glitter-index glitter-value}))

; Exercise -3 (validated :name and :glitter-index.)	(will refactorize)
(defn validate-values
	[name glitter-index]
		(if (and (empty? name) (not(empty? value)))
		(println "validated :name and :glitter-index")))	 

;exercise - 4 Write a function that will take your list of maps and convert it back to a
(clojure.string/join "," (vals glitter-filter))

