(ns norwegian_utils.t-business
  (:use midje.sweet)
  (:use [norwegian_utils.business]))

(facts "about `gyldig-orgnr?`"
  (fact "it should return false for nil"
    (gyldig-orgnr? nil) => false)

  (fact "it should return false for invalid number"
    (gyldig-orgnr? "abc") => false)

  (fact "it should return false for numbers that has less than 9 digits"
    (gyldig-orgnr? "12345678") => false)

  (fact "it should return false for numbers that has more than 9 digits"
    (gyldig-orgnr? "12345678") => false)

  (fact "it should return false for numbers that has more than 9 digits"
    (gyldig-orgnr? "1234567890") => false)

  (fact "it should return false for numbers that has 9 digits but wrong control digit"
    (gyldig-orgnr? "111111112") => false)

  (fact "it should return true for an actual organization number"
    (gyldig-orgnr? "888884122") => true))