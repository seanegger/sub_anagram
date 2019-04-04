(ns subanagram-finder.core
  "Clojure Sub-anagram Finder. Usage:
    lein run -- word [word ...]

   Champlain College
   CSI-380 Spring 2019"
  (:gen-class))

(require '[clojure.string :as str])


(defn load-dictionary 
  "Load list of words from disk."
  ([] (load-dictionary "resources/words"))
  ([file-name]
   ;; Code goes here
   (with-open [r (clojure.java.io/reader file-name)]
     (doall (line-seq r)))
   ;; count is lazy - doall is non-lazy - (doall (line-seq r)))
  ))
  

(defn find-sub-anagrams 
  "Find all the words in word-list that are sub-anagrams of word.

  A sub-anagram means it is an anagram of a substring of word."
  [word, word-list]
  (def len (count word))
  (def freq (frequencies (clojure.string/lower-case word)))
  (println freq)

  (defn is-sub-anagram [other]
   (cond
    (< len (count other))
        false
    (>= len (count other))
        (
        (def other_ct (frequencies (clojure.string/lower-case other)))
        other_ct
        )
   )
  )

  (println (is-sub-anagram "animal", ))
  "bear"
  ;; Code goes here
  )  



  (defn generate-output 
    "Generate the output.
     For each word the output contains a line with all the sub-anagrams of that 
     word (in sorted order) separated by spaces.
     Example: (generate-output [\"tea\", \"ok\"]) -> 
              \"A At E T Ta a at ate e eat eta t tea\nK O OK k o\"
    "
    [words]
    ;; Code goes here
    ;; load dictionary - 
    (def dictionary (load-dictionary))
    ;; get anagrams - 
    (println (get dictionary 0))
    (def all-anagrams (find-sub-anagrams words dictionary))
    ;; return anagrams -
    (println (clojure.string/join "\n" (clojure.string/join " " all-anagrams)))
    )



(defn -main 
  "Main function, generates the output and prints it to the console."
  [& args]
  (if (= 0 (count args))
    ;; then
    (println "Usage:\n\tlein run -- word [word ...]")
    ;; else
    (println (generate-output args))))    
