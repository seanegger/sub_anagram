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
   ;; get text file
   (with-open [reader (clojure.java.io/reader file-name)]
   ;; add each line to the vector
   (def wordsVector (reduce conj [] (line-seq reader))))
   ;; change the vector to a list
   (into () wordsVector)
  ))
  

(defn find-sub-anagrams 
  "Find all the words in word-list that are sub-anagrams of word.

  A sub-anagram means it is an anagram of a substring of word."
  [word, word-list]
  ;; Code goes here
  ;; get length of word - 
  (def word-length (count word))
  ;; letter-counts
  ;; is-sub-anagram
  ;; return is-sub-anagram
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
  (def all-anagrams (find-sub-anagrams words dictionary)
  ;; return anagrams -
  (join "\n" (join " " all-anagrams))
  )
  

(defn -main 
  "Main function, generates the output and prints it to the console."
  [& args]
  (if (= 0 (count args))
    ;; then
    (println "Usage:\n\tlein run -- word [word ...]")
    ;; else
    (println (generate-output args))))    
