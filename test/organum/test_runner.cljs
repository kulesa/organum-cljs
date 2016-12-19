(ns organum.test-runner
 (:require [doo.runner :refer-macros [doo-tests]]
           [organum.core-test]
           [cljs.nodejs :as nodejs]))

(try
  (.install (nodejs/require "source-map-support"))
  (catch :default _))

(doo-tests
 'organum.core-test)
