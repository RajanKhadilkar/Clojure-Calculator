(ns calculator.core
  (:gen-class))

(defn -main
  "Runs all the methods"
  [& args]
  (println "Hello, World!"))

(defn calculator [s1 s2 op]
  (def n1 (int (s1)))
  (def n2 (int (s2)))
  (case op
    "+" (+ n1 n2)
    "-" (- n1 n2)
    "/" (/ n1 n2)
    "*" (* n1 n2)
    )
  )

(defn getInput [] 
  (loop []
    (println "Enter First Number")
    (let [n1 (read-line)]
      (cond (not (re-matches #"^[0-9]*$" n1))
            (do (println "Please enter a Number")
                (recur))
            :else
            (loop []
              (println "Enter Operation")
              (let [op  (read-line)]
                (cond (not (re-matches #"^[+\-*\/]*$" op))
                      (do (println "Please enter an operation (+,-,/,*)")
                          (recur))
                      :else
                      (loop []
                        (println "Enter Second Number")
                        (let [n2 (read-line)]
                          (cond (not (re-matches #"^[0-9]*$" n2))
                                (do (println "Please enter a Number")
                                    (recur))
                                (and (= op "/") (= n2 0))
                                (do (println "Please enter a number other than 0")
                                    (recur))
                                :else
                                (calculator n1 n2 op))))))))
            )
          ) 
  )




(getInput)