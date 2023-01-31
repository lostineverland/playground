## Meander

## Objective

Just trying to wrap my head around the way the macros work in meander

### Methodology

- I made a simple macro to run on the cljs side.
- I used a very simple input:

```clj
{:some 1 :me [{:on 2} {:on 3}]}       ;; data input
{:some ?some :me (m/scan {:on ?me})}  ;; pattern matching
[?some ?me]                           ;; desired output
```

This works:

```clj
(m/search
  {:some 1 :me [{:on 2} {:on 3}]}
  {:some ?some :me (m/scan {:on ?me})}
  [?some ?me]
  )
```

And I wanted to get this to work:

```clj
(let [data {:some 1 :me [{:on 2} {:on 3}]}
      pattern '{:some ?some :me (m/scan {:on ?me})}
      expr '[?some ?me]]
 (m/search data pattern expr))
```

## Conclusion

Because `m/search` is a macro, which is resolved at compile time, it doesn't get the resolved values of the variables which are passed in. So if I want it in a function, then the function has to be a macro as well (not 100% sure)

### Resources

- https://code.thheller.com/blog/shadow-cljs/2019/10/12/clojurescript-macros.html
- https://hackernoon.com/clojurescript-macros-a-not-so-long-journey-part-ii-u3183uqa

The macro expansion function was very useful in understanding the mechanics here. See `play.cljs`.