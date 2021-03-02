# Lecture 8

* Retrofit
* Moshi
* Glide

## Exercises:
* Add more views to show all the information from the Comic.
* Hide or disable next/previous buttons if there are no more comics in that direction.
* Handle the case where we try to load a comic when num goes below zero.
* Make a prettier UI / Better UX.
* Add functionality to swipe to the next comic instead of clicking buttons.
* Cache comics to avoid calling the API too often. For example add the comics to a mutableMap and try to fetch from the map before you fetch from the API.
* Preload the next few comics so they show up instantly instead of loading on click.

More difficult:
* Create an adapter and show the comics in a ViewPager2 view. Keep preloading more comics as the user swipes in the ViewPager.
