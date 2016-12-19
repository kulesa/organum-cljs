(ns organum.core-test
  (:require [organum.core :refer [parse parse-file]]
            [cljs.test :refer-macros [deftest is]]))

(deftest parse-headers
  (is (=
       (parse "* header")
       '([:section [:h1 "header"]])))
  (is (=
       (parse "* header 1\n** header 2\nsome text")
       '([:section [:h1 "header 1"]] [:section [:h2 "header 2"] "some text"])))
  )

(deftest parse-todos
  (is (=
       (parse "* TODO do the dishes")
       '([:section [:h1 [:keyword "TODO"] "do the dishes"]])))
  (is (=
       (parse "* DONE do the dishes")
       '([:section [:h1 [:keyword "DONE"] "do the dishes"]])))
  )

(deftest parse-priority
  (is (=
       (parse "* [#A] do the dishes")
       '([:section [:h1 [:priority "A"] "do the dishes"]]))))

(deftest parse-list
  (is (=
       (parse "* heading\n- [ ] item 1\n- [ ] item 2\n")
       '([:section [:h1 "heading"] "- [ ] item 1\n- [ ] item 2\n"]))))

(deftest parse-tag
  (is (=
       (parse "* heading :tag:")
       '([:section [:h1 "heading" [:tags "tag"]]])
       )))

(deftest parse-files
  (is (=
       (parse-file "test/todo.org")
       '([:section [:h1 "Heading 1"]] [:section [:h2 "Heading 2"] "   - [ ] checklist item 1"] [:section [:h3 "Heading 3"]] [:section [:h1 "TODOS"]][:section [:h2 [:keyword "DONE"] "create dummy orgmode file"]] [:section [:h2 [:keyword "TODO"] "Test orgmode parsin"]] [:section [:h3 [:keyword "TODO"] "Nested todo!"] ""])
       )))
