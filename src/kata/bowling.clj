(ns kata.bowling)

(defn frames
  ([rolls] (frames rolls frames))
  ([rolls f]
     (cons (take
            (condp #(= 10 (apply + (take %1 %2))) rolls
              1 3
              2 3
              2)
            rolls)
           (lazy-seq
             (f
              (drop
               (condp #(= 10 (apply + (take %1 %2))) rolls
                 1 1
                 2 2
                 2)
               rolls))))))
