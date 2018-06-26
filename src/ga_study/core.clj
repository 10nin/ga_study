(ns ga-study.core
  (:require [clojure.math.numeric-tower :as Math]))

(defn bin->dec [b]
  (if (= (count b) 0) 0
      (+ (if (= 1 (first b)) (Math/expt 2 (- (count b) 1))
             0) (bin->dec (rest b)))))
