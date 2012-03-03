(ns kata.bowling)

(defn frames
  ([rolls] (frames rolls frames))
  ([rolls f]
     (let [frame-and-bonuses
           (condp #(= 10 (apply + (take %1 %2))) rolls
             1 3
             2 3
             2)
           frame
           (condp #(= 10 (apply + (take %1 %2))) rolls
              1 1
              2 2
              2)]
       (cons (take
              frame-and-bonuses
              rolls)
             (lazy-seq
               (f (drop frame rolls)))))))
