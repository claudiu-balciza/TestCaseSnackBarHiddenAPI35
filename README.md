Test Case for Snackbars not showing consistently in an app
- min SDK 34, max 35, compiled for 35
- I set the MarginLayoutParams only once in both the Activity and Fragment

in API34 with EdgeToEdge
- main activity:
1. tap the "show snackbar" button and it shows correctly the first time
2. tap the "show snackbar" button again and the snackbar moves to the edge ignoring the margins
3. when the IME kbd is invoked by tapping on the text edit, the snackbar doesn't "climb" on top of it
4. when the IME kbd is hidden, the snackbar is now positioned correctly
- fragment:
5. tap the "show snackbar" button and it shows correctly every time
6. when the IME kbd is invoked by tapping on the text edit, the snackbar "climbs" on top of it
7. when the IME kbd is hidden, the snackbar follows it correctly

in API35 with EdgeToEdge
- main activity is pretty much the same as in API34:
1. tap the "show snackbar" button and it shows correctly the first time
2. tap the "show snackbar" button again and the snackbar moves to the edge ignoring the margins
3. when the IME kbd is invoked by tapping on the text edit, the snackbar doesn't "climb" on top of it
4. when the IME kbd is hidden, the snackbar is now positioned correctly
- fragment:
5. tap the "show snackbar" button and the snackbar is hidden under the kbd (as opposed to API34 on top of the kbd)
6. hide the kbd and the snackbar is positioned correcly
7. tap the "show snackbar" button again and the snackbar moves to the edge
8. when the IME kbd is invoked by tapping on the text edit, the snackbar "climbs" on top of it
9. when the IME kbd is hidden, the snackbar follows it correctly

how to prevent the snackbar from moving to the bottom edge and "ride" on top of the keyboard when it is present on all APIs?
