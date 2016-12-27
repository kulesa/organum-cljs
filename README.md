[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.kulesa/organum-cljs.svg)](https://clojars.org/org.clojars.kulesa/organum-cljs)
# Organum-cljs

Simple [org-mode](http://orgmode.org) parser in ClojureScript. Port of [Organum](https://github.com/seylerius/organum).

## Usage

[Leiningen](http://leiningen.org) dependency information:

``` clojure
[org.clojars.kulesa/organum-cljs "0.1.0"]
```

``` clojure
(use 'organum-cljs.core)
(parse "* Heading")
(parse-file "test.org")
;...
```

Distributed under the Eclipse Public License, the same as Clojure.
