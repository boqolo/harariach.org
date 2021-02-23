(ns harariach.core
  (:require
   [helix.core :refer [defnc $]] ; func component macro and create macro
   [helix.hooks :as hooks]
   [helix.dom :as d]
   ["react-dom" :as rdom]))


;; -------------------------
;; util


;; -------------------------
;; Views

(defnc App []
  (d/div
   (d/nav
    (d/a {:href "#"} "Archives") " | "
    (d/a {:href "#"} "Contribute") " | "
    (d/a {:href "#"} "News"))
   (d/div (d/h1 "An archive of Harari history"))
   (d/div {:class "row"}
          (d/div {:class "col-3"})
          (d/div {:class "col-3"} (d/h3 (d/a {:href "#"} "Browse")))
          (d/div {:class "col-3"}))
   (d/aside "This project is in beta!")))


;; -------------------------
;; Initialize app

(defn mount-root []
  ; (d/render [home-page] (.getElementById js/document "app")))
  (rdom/render ($ App) (js/document.getElementById "app")))

(defn ^:export init! []
  (mount-root))
