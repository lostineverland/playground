(ns dev.play
  (:require
    [notes-01.term :refer [wrangle]]
    [meander.epsilon :as m]))

(def status "stateful")

(m/search
  {:some 1 :me [{:on 2} {:on 3}]}
  {:some ?some :me (m/scan {:on ?me})}
  [?some ?me]
  )

  (m/search
  {:some 1 :me [{:on 2} {:on 3}]}
  {:some ?some :me (m/scan {:on ?me})}
  [?some ?me]
  )

(macroexpand
  '(m/search
    {:some 1 :me [{:on 2} {:on 3}]}
    {:some ?some :me (m/scan {:on ?me})}
    [?some ?me]
    ))

(wrangle
     m/search
     {:some 1 :me [{:on 2} {:on 3}]}
     '{:some ?some :me (m/scan {:on ?me})}
     '[?some ?me]
    )

(let [data {:some 1 :me [{:on 2} {:on 3}]}
      pattern '{:some ?some :me (m/scan {:on ?me})}
      expr '[?some ?me]]
 (macroexpand
   '(wrangle m/search data pattern expr)))

status