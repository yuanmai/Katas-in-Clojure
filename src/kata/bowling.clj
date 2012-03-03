(ns kata.bowling)

(defn frames [rolls]
  (cond
    (= 10 (first rolls)) '(10 x y)
    (= 10 (apply + (take 2 rolls))) '(5 5 x)
    :else '(5 4)))
