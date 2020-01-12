(ns ld-5.core
   (:require [clojure.string :as str])
  )

(defn encrypt [string height]
  (def l (count string))
  (def step (- (* height 2) 2))
  (def strVec (str/split (str/replace string " " "_") #""))

  (println "Original string:  " string)
  (print "Encrypted string:  ")	
  (loop [i 0]
    (loop [j 0]
      (when (< j l)
        (when (or (= 0 (mod (+ j i) step)) (= 0 (mod (- j i) step)))
						    (print (nth strVec j))
          )
        (recur (inc j))
        )
      )  
    (when (< i (- height 1))
	     (recur (inc i))
		    )
    )
  )

(defn getStepVector [height it extraSteps]
 
  (loop [i 1 acc []]
    (if (> i height)
      acc
      (recur (inc i) (conj acc (+ (if (or (= 1 i) (= height i)) it (* 2 it)) (if (> extraSteps height)
                                                                               (if (and (>= extraSteps (- (* 2 height) i))(not= i height)) 2 1) ; true
                                                                               (if (>= extraSteps i) 1 0) 
                                                                               ))))))
  )

(defn decrypt 
  [string height]
  (def l (count string)) 
  (def step (- (* height 2) 2))
  (def strVec (str/split (str/replace string " " "_") #""))
  (def iterations (int (Math/floor (/ l step)))) ; Number of complete iterations
  (def extraSteps (mod l step)) ; Number of steps in the last incomplete interation
  
  (def stepVector (getStepVector height iterations extraSteps))

  (println "Original string:  " string)
  (print "Decrypted string:  ")

  
  
  (loop [i 0] ; Current iteration
    (loop [j 1 x i] ; j = counter to know when a new step begins; x = for printing positions in vector
      
      (when (< x l) (print (nth strVec x)))

      (when (or 
              (and (< i iterations)(< j step))
              (and (= i iterations)(< j extraSteps)))
        (recur
          (inc j)
          (+ 
            (cond (= j height) (+ 1 (- x (nth stepVector (- (if (>= j height) (- (* 2 height) j) j) 2))))
                  (< j height) (+ x (nth stepVector (- (if (>= j height) (- (* 2 height) j) j) 1)))
                  (> j height) (- x (nth stepVector (- (if (>= j height) (- (* 2 height) j) j) 2)))
                  ) (cond
                      (and (not= i 0)(= j (- height 1))) (- i)
                      (and (not= i 0)(or (= j height)(= j 1))) i
                      :else 0
                      )
            )
          )
        )
      )
    (when (if (< 0 extraSteps) (< i iterations) (< i (- iterations 1)))
      (recur (inc i))
      )
    )
  )