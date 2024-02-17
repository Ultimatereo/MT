(ns test4)

(defn prime? [n]
  (if (<= n 1)
    false
    (not-any? #(zero? (rem n %)) (range 2 (Math/sqrt (inc n))))))

(print (prime? 3) (prime? 10) (prime? 101) (prime? -101) (prime? 2.3))