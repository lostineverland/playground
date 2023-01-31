(ns notes-01.start
  (:require
    [cljs.pprint :refer [pprint]]))

(defn main []
  (pprint {:some 1 :me 2}))