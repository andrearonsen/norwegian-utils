(ns norwegian_utils.business)

(defn gyldig-orgnr? [orgnr]
  (cond 
    (nil? orgnr) false
    (not (re-matches #"\d{9}" orgnr)) false
    :else
      (let [
        vekttall [3 2 7 6 5 4 3 2]
        kontrollsiffer (read-string (subs orgnr 8))
        siffer (vec (map read-string (map str (subs orgnr 0 8))))
        siffer-vekttall (map vector siffer vekttall)
        mod11 (- 11 (mod (reduce + (map (fn [[s v]] (* s v)) siffer-vekttall)) 11))
        ] (and (not= mod11 10) (= kontrollsiffer mod11)))))