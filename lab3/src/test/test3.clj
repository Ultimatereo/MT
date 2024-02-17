(ns test3)

(defn factorial [n]
  (if (= n 0)
    1
    (* n (factorial (- n 1)))))

(print (factorial 10) " " (factorial 20))