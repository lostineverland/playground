(ns notes-01.term)

(defmacro wrangle [f data pattern expr]
  (list f
    data 
    (nth pattern 1)
    (nth expr 1))
)