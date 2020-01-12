(ns ld-4.core)

(defn getAverageGrade
  [gradeMap]

  (def vectorsToCalc (reduce into []
                       (filter 
                         #(= "a" (subs (first %) (- (count (first %)) 1))) gradeMap) 
                       )
    )
  
  (def sumOfGrades (loop [sum 0 i 1]
                     (if (>= i (count vectorsToCalc))
                       sum
                       (recur (+ sum (nth vectorsToCalc i)) (+ i 2))
                       )
                     )
    )       
  
  (print "Average grade for the given map:")
  (float (/ sumOfGrades (/ (count vectorsToCalc) 2)))
)

; (getAverageGrade {"Inese" 10 "Vasja" 8 "Petja" 4 "Natasha" 7 "Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9})           = 8
; (getAverageGrade {"Jana" 10 "Vasja" 8 "Petja" 4 "Natasha" 7 "Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9 "Mareks" 5 "Zigfrīda" 3})         = 7.14
; (getAverageGrade {"Janis" 7 "Vasja" 8 "Petja" 4 "Natasha" 7 "Anja" 5 "Laura" 6 "Sandra" 8 "Krišjanis" 4 "Marta" 8 "Zigfrīds" 5})         = 6.57