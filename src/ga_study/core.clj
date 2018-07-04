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

(defn gene-crossover [gene1 gene2 cross-point]
  (list (vec (concat (take cross-point gene1) (take-last (- (count gene2) cross-point) gene2)))
        (vec (concat (take cross-point gene2) (take-last (- (count gene1) cross-point) gene1)))))

(defn generate-initial-group [gene-length group-size]
  (for [_ (range 1 (+ group-size 1))] (gen-gene gene-length)))

(defn invert [x]
  (if (= x 0) 1 0))

(defn stochastically-apply [f x rate]
  (if (< (rand) rate) (f x) x))

(defn mutation [gene f]
  (vec (for [x gene] (stochastically-apply f x 0.03))))

(defn compare-gene [g1 g2]
  (compare (target_f (get_x g1)) (target_f (get_x g2))))

(defn sort-genes [genes f]
  (sort f genes))

;; generate initial group
;; (x <- (generate-initial-group 10 20))
;; cross-over
;; (cp <- (/ (count (gene)))) ; cross-over on half point

;; (gene-crossover gene1 gene2 cp)
