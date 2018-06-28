(ns ga-study.core
  (:require [clojure.math.numeric-tower :as Math]))

(defn bin->dec [b]
  (if (= (count b) 0) 0
      (+ (if (= 1 (first b)) (Math/expt 2 (- (count b) 1))
             0) (bin->dec (rest b)))))
(defn get_x [b]
  (/ (bin->dec b) (- (Math/expt 2 (count b)) 1)))
  
(defn target_f [x]
  (+ (java.lang.Math/sin (* 3 x)) (* 0.5 (java.lang.Math/sin (* 9 x))) (java.lang.Math/sin (+ (* 15 x) 50))))
  
(defn gen-gene [dimension]
  (vec (for [_ (range 1 (+ dimension 1))] (rand-int 2))))

(defn gene-crossover [gene1 gene2 p]
  (vec (concat (take p gene1) (take-last (- (count gene2) p) gene2))))
