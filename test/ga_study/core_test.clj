(ns ga-study.core-test
  (:require [clojure.test :refer :all]
            [ga-study.core :refer :all]))

(deftest bin->dec-test
  (testing "binary to decimal convert check."
    (is (= (bin->dec '[1 0 0]) 4))
    (is (= (bin->dec '[0]) 0))
    (is (= (bin->dec '[1]) 1))
    (is (= (bin->dec '[1 1]) 3))))
