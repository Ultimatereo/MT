(ns test2)
(defn argcount
  ([] 0)
  ([x] 1)
  ([x y] 2)
  ([x y & more] (+ (argcount x y) (count more))))

(print (argcount) "\n")
(print (argcount 1) "\n")
(print (argcount 1 2 3) "\n")
(print (argcount 1 2 3 4 5) "\n")