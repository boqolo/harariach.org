;; The route handler
(ns harariach.server
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]))

; (defn display-page [fileUri]
;   "A convenience function for wrapping and serving URI pages"
;   (content-type
;    (resource-response fileUri {:root
;                                (if (= fileUri "index.html")
;                                  "public")})
;    "text/html"))

; Define routes.
; IMPORTANT: The way Compojure works, this macro
; (when hit with a req) will try every route until
; one returns a non-nil response (nil occurs when
; route doesnt match uri), then 404s.
(defroutes app-routes
  "Macro for defining Routes which return Ring
   handlers for specified requests at the URI"
  (GET "/" request (files))
  ; returns nil if req URI doesnt match defined URI
  (route/not-found "<h1>Page Not Found</h1"))

; Provide middleware
(def app
  (wrap-defaults app-routes site-defaults))
