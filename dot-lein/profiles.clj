;; TODO: Change this to do deep merging.
;;       Hmmm, what about vectors in `:injections`?

#=(eval
   (merge
    '{:user
      {:test-paths   ["_nomis-non-vcs-stuff/test"]
       :dependencies [[org.clojure/tools.namespace "0.3.0-alpha4"]
                      [walmartlabs/system-viz "0.1.1"]
                      ;; ;; [slamhound "1.3.3"]
                      [spyscope "0.1.5"]
                      ;; [criterium "0.4.2"]
                      [org.clojure/java.classpath "0.2.0"]

                      [pjstadig/humane-test-output "0.7.0"]
                      
                      ;; #### Look at these again
                      [com.cemerick/pomegranate "0.3.1"]
                      ;; [com.nomistech/emacs-hacks-in-clojure "0.1.0-SNAPSHOT"]
                      ;; [com.nomistech/clojure-dev-utils "0.1.0-SNAPSHOT"]
                      ]
       :plugins [[lein-ns-dep-graph "0.2.0-SNAPSHOT"]
                 [lein-nomis-ns-graph "0.2.0-SNAPSHOT"]
                 [com.jakemccrary/lein-test-refresh "0.9.0"]
                 [lein-auto "0.1.2"]
                 
                 ;; ;; TODO: Remind yourself of these...
                 ;; [lein-pprint "1.1.1"]
                 [lein-kibit "0.1.2"]
                 [jonase/eastwood "0.2.3"]
                 
                 [lein-ancient "0.6.10"]
                 [lein-try "0.4.3"]]
       :aliases {
                 ;; "slamhound" ["run" "-m" "slam.hound"]
                 }
       :test-refresh {:quiet true}
       :global-vars {
                     ;; *warn-on-reflection* true
                     *print-level*        30
                     *print-length*       1000}
       :injections
       [(try
          ;; try/catch because "lein repl" outside a project dir
          ;; throws when seeing reader literals
          (require 'spyscope.core)
          (catch RuntimeException e))

        (require 'pjstadig.humane-test-output)
        (pjstadig.humane-test-output/activate!)

        (require 'com.walmartlabs.system-viz)
        (defn viz
          ([sys]
           (viz sys {}))
          ([sys opts]
           (com.walmartlabs.system-viz/visualize-system sys opts)))]}}
    
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
