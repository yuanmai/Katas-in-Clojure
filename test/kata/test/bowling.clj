(ns kata.test.bowling
  (:use [kata.bowling])
  (:use [clojure.test]))

(deftest test-frame-and-bonuses
  (are [description frame-and-bonuses rolls] (= frame-and-bonuses (first (frames rolls)))
       "strike"     '(10 x y) '(10 x y z)
       "spare"      '( 5 5 x) '( 5 5 x)
       "open frame" '( 5 4)   '( 5 4 x)))
