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

(deftest test-frames-for-competed-games
  (are [description each-frame game] (= (repeat 10 each-frame)  (take 10 (frames game)))
       "gutter game" [0 0] (repeat 0)
       "perfect game" [10 10 10] (repeat 12 10)
       "all spares" [5 5 5] (repeat 21 5)
       "all ones" [1 1] (repeat 21 1)))
