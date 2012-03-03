(ns kata.test.bowling
  (:use [kata.bowling])
  (:use [clojure.test]))

(deftest test-frame-and-bonuses
  (are [description frame-and-bonuses rolls] (= frame-and-bonuses (first (frames rolls)))
       "strike"     '(10 x y) '(10 x y z)
       "spare"      '( 5 5 x) '( 5 5 x y)
       "open frame" '( 5 4)   '( 5 4 x)))

(deftest test-frame-advance
  (are [desciption advance rolls] (= advance (second (frames rolls list)))
       "strike"     '(x y z) '(10 x y z)
       "spare"      '(x y)   '( 5 5 x y)
       "open frame" '(x)     '( 5 4 x)))
