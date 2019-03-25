(ns chapter-8.core
  (:gen-class))

(defn -main
  [& args]
  (println "Welcome to Chapter 8 Assignment"))
 
 ;Exercise-1:  Write the macro when-valid so that it behaves similarly to when.
(defmacro when-valid
	"Check Validation through when"
	[to-validate validations-details]
		`(let [~errors-value (validate ~to-validate ~validations-details)]
		(if (empty? ~errors-value)
		(println "It's a success!"))))
		
		
; Exercise-2 : Implement or as a macro.
(defmacro or
	"Or implementation as Macro"
	([] true)
		([x] x)
		([x & next]
		`(let [or# ~x]
		(if or# or# (or ~@next)))))

; Exercise-3 : Defining Nested attribute.
(defmacro nested-attr
   "defining nested attributes"
   ([attr-name attr]
    `(def ~attr-name (comp ~attr :attributes)))