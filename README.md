# TA-PPB-SMT3-CheckInAja13294
Memiliki 4 Activity :
1. Halaman Utama
  - Menampilkan Deskripsi Aplikasi
  - Data Tamu yang telah memesan kamar (diambil dari realtime database firebase)
    - Data Tamu dapat di ubah, hapus, maupun ditambah (CRUD)
  - Dapat melihat lokasi hotel
  - Dapat melihat list kamar hotel yang tersedia (diarahkan ke activity pilihan kamar)
  - Dapat menghubungi customer service (dengan button email dan telepon)
2. Pilihan Kamar
  - Menampilkan list kamar yang tersedia menggunakan Recycler View
  - Tiap list kamar yang di klik diarahkan ke deskripsi kamar hotel (diarahkan ke activity tampilan kamar)
3. Tampilan Kamar
  - Menampilkan deskripsi kamar hotel yang di klik dari activity pilihan kamar
  - Tiap tampilan kamar yang di klik ada button pesan kamar (diarahkan ke activity pesan kamar)
4. Pesan Kamar
  - Menampilkan form pemesanan kamar
  - Tamu harus menginputkan data tamu seperti tipe kamar yang dipesan, tanggal check-in check-out dll.
  - Setelah klik button pesan kamar, data tamu akan dikirimkan ke realtime database firebase
    dan data tamu ditampilkan di halaman utama
