;; TODO: Change this to do deep merging.
;;       Hmmm, what about vectors in `:injections`?

#=(eval
   (merge
    '{:user
      {:dependencies [[org.clojure/tools.namespace "0.3.0-alpha4"]
                      [spyscope "0.1.6"]
                      [org.clojure/java.classpath "0.2.3"]]
       :plugins [[lein-nomis-ns-graph "0.12.0"]]}}
    
    (let [local-extras-file (str (System/getProperty "user.home")
                                 "/.lein/profiles-local-extras.clj")]
      ;; (println "Doing if")
      ;; (println "Looking for" (java.io.File. local-extras-file))
      (if (.exists (java.io.File. local-extras-file))
        (do
          ;; (println "in then part")
          (let [local-extras (read-string (slurp local-extras-file))]
            ;; (println "local-extras =" local-extras)
            local-extras))
        (do
          ;; (println "in else part")
          {})))))
