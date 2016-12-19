(defproject org.clojars.kulesa/organum-cljs "0.1.0"
  :description "Org-mode parser in ClojureScript"
  :url "https://github.com/kulesa/organum-cljs"
  :dependencies [[org.clojure/clojure                 "1.8.0"]
                 [org.clojure/clojurescript           "1.9.293"]
                 [com.lucasbradstreet/instaparse-cljs "1.4.1.2"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-doo       "0.1.7-SNAPSHOT"]
            [lein-npm       "0.6.1"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :clean-targets ["out" "release"]
  :target-path "target"
  :cljsbuild
  {:builds
   {:main {
           :source-paths ["src"]
           :compiler {:output-to     "release/organum.js"
                      :output-dir    "release"
                      :source-map    "release/organum.js.map"
                      :target        :nodejs
                      :language-in   :ecmascript5
                      :optimizations :advanced}}
    :test {
           :source-paths ["src" "test"]
           :compiler {:output-to     "out/organum_test.js"
                      :output-dir    "out"
                      :target        :nodejs
                      :language-in   :ecmascript5
                      :optimizations :none
                      :main          organum.test-runner}}}})
