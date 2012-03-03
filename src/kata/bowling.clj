(ns kata.bowling)

(defn frames [rolls]
  (take
   (cond
     (= 10 (apply + (take 1 rolls))) 3
     (= 10 (apply + (take 2 rolls))) 3
     :else 2)
   rolls))
