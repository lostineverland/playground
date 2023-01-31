(ns notes-01.start
  (:require
    [notes-01.term :refer [wrangle]]
    [cljs.pprint :refer [pprint]]))

(defn main []
  (pprint {:some 1 :me 2}))