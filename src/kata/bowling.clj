(ns kata.bowling)

(defn- sumn
  [n coll]
  (reduce + (flatten (take n coll))))

(defn frames
  ([rolls] (frames rolls frames))
  ([rolls f]
     (let [[frame bonus]
           (condp #(= 10 (sumn %1 %2)) rolls
             1 [1 2]
             2 [2 1]
               [2 0])]
       (cons (take (+ frame bonus) rolls)
             (lazy-seq
               (f (drop frame rolls)))))))

(defn score
  [game]
  (sumn 10 (frames game)))
