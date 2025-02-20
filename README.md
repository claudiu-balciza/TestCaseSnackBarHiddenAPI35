Test Case for Snackbars not showing consistently in an app
- min SDK 34, max 35, compiled for 35
- I set the MarginLayoutParams only once in both the Activity and Fragment

- in API34 with EdgeToEdge
1. main activity:
- tap the "show snackbar" button and it shows correctly the first time
- tap the "show snackbar" button again and the snackbar moves to the edge ignoring the margins
- when the IME kbd is invoked by tapping on the text edit, the snackbar doesn't "climb" on top of it
- when the IME kbd is hidden, the snackbar is now positioned correctly
2. fragment:
- tap the "show snackbar" button and it shows correctly every time
- when the IME kbd is invoked by tapping on the text edit, the snackbar "climbs" on top of it
- when the IME kbd is hidden, the snackbar follows it correctly

- in API35 with EdgeToEdge
3. main activity is pretty much the same as in API34:
- tap the "show snackbar" button and it shows correctly the first time
- tap the "show snackbar" button again and the snackbar moves to the edge ignoring the margins
- when the IME kbd is invoked by tapping on the text edit, the snackbar doesn't "climb" on top of it
- when the IME kbd is hidden, the snackbar is now positioned correctly
4. fragment:
- tap the "show snackbar" button and the snackbar is hidden under the kbd (as opposed to API34 on top of the kbd)
- hide the kbd and the snackbar is positioned correcly
- tap the "show snackbar" button again and the snackbar moves to the edge
- when the IME kbd is invoked by tapping on the text edit, the snackbar "climbs" on top of it
- when the IME kbd is hidden, the snackbar follows it correctly

how to prevent the snackbar from moving to the bottom edge and "ride" on top of the keyboard when it is present on all APIs?


