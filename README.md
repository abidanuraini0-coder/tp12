Character Manager Sprint #5
Layout, UI Responsif & Analisis MVC

<img width="528" height="370" alt="image" src="https://github.com/user-attachments/assets/1080ec67-9d35-4fbc-b808-6515ff83fe08" />


<img width="725" height="826" alt="Screenshot 2026-11-03 211129" src="https://github.com/user-attachments/assets/adb4f1d1-74de-443f-990a-9059a7905058" />
<img width="1117" height="602" alt="Screenshot 2026-11-03 212138" src="https://github.com/user-attachments/assets/9279e1ab-3cd6-4b3d-87d7-02d8eb431225" />
<img width="1878" height="802" alt="Screenshot 2026-11-03 211936" src="https://github.com/user-attachments/assets/cd6e1116-8163-40db-9a61-521d0912de90" />

Struktur Panel Bersarang
 Aplikasi CharacterManager menggunakan beberapa JPanel yang disusun secara bertingkat agar tampilan lebih terorganisir. Panel utama menggunakan BorderLayout untuk membagi tampilan menjadi empat bagian, 
yaitu header di NORTH, daftar karakter di CENTER, legenda role di EAST, dan status bar di SOUTH. Pada bagian header terdapat panel tambahan untuk menampilkan judul aplikasi, jumlah karakter, serta statistik rata-rata level, 
sedangkan daftar karakter ditempatkan dalam JPanel yang dibungkus oleh JScrollPane agar dapat di-scroll. Struktur panel bersarang ini membuat setiap bagian memiliki fungsi masing-masing sehingga tampilan lebih rapi dan mudah disesuaikan ketika ukuran jendela berubah.

Alasan Pemilihan Panel Tambahan dan Layout yang Ditolak
  Panel tambahan yang saya pilih adalah panel statistik yang menampilkan jumlah karakter dan rata-rata level karakter. Panel ini dibuat agar pengguna dapat melihat informasi penting mengenai seluruh karakter tanpa harus menghitungnya secara manual.
Saya menggunakan `GridLayout(1, 2, 12, 0)` karena layout ini dapat menyusun dua informasi secara berdampingan dengan ukuran yang rapi dan konsisten. 
Layout alternatif yang tidak saya pilih adalah `FlowLayout`, karena posisi komponen dapat menyesuaikan ruang yang tersedia sehingga susunan informasi kurang konsisten ketika ukuran jendela berubah. 
Oleh karena itu, GridLayout lebih sesuai untuk panel statistik yang memiliki dua informasi utama.

https://docs.google.com/document/d/1yAu_Nk9J4WQQY0r91mKeXa9SgXq3VR4turJsMSH1nkA/edit?usp=sharing
