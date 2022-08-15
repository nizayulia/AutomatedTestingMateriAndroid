Feature: Testing feature tambah Tugas dari dashboard Website Edlink

  Scenario Outline: User login dengan akun siakad
  
    Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Admin
    
    Given Dosen tap menu Ruang Kelas pada header
    When Dosen tap Akademik di Ruang Kelas
    And Dosen tap periode pada Akademik
    And Dosen tap periode 2020/2021 Ganjil pada periode
    And Dosen tap Terapkan pada Akademik
    Then Dosen melihat kelas pada Ruang Kelas
    
    When Dosen tap kelas di Ruang Kelas
    Then Dosen masuk ke kelas Edlink 
    
    Given Dosen tap menu Sesi Pembelajaran pada kelas
    When Dosen tap Sesi ke 1 pada kelas
    And Dosen tap button buat bahan di detail session
    Then Dosen melihat pop up pilihan buat bahan 
    
    # Pembuatan tugas
    Given Dosen tap buat bahan tugas di pop up buat bahan
    And Dosen tap button Tambahkan di pop up buat bahan
    Then Dosen masuk halaman form buat tugas
    
    Given Dosen input judul tugas <judul> di form buat tugas
    When Dosen tap bagikan tugas sekarang di form buat tugas
    When Dosen tap aktifkan batas waktu penyerahan di form buat tugas
    And Dosen input catatan <catatan> di form buat tugas
    And Dosen tap simpan di form buat tugas
    
    # Pengecekan materi yang telah tersimpan
    Given Dosen tap menu Beranda pada header
    Then Tugas <judul> berhasil tersimpan di sistem dashboard    
    And Dosen dapat melihat batas & waktu pengumpulan di beranda Edlink
    And Dosen dapat melihat countdown pengumpulan di beranda Edlink
    
    Given Dosen tap tugas di dashboard
    Then Judul tugas <judul> berhasil disimpan
    And Bagikan tugas Dibagikan berhasil disimpan
    And Tanggal & Waktu Selesai tugas berhasil disimpan
    And Tidak ada gambar tugas berhasil disimpan
    And Tidak ada video tugas berhasil disimpan
    And Tidak ada dokumen berhasil disimpan
    
    Given Dosen tap kembali ke detail sesi kelas
    Then Tugas <judul> berhasil tersimpan di sesi kelas
    Given Dosen tap menu Diskusi pada kelas
    Then Tugas <judul> berhasil tersimpan di kelas
    
############################# Mahasiswa ##############################
		Given Mahasiswa masuk ke website Edlink
    When Mahasiswa tap Siakad button
    When Mahasiswa input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Mahasiswa input username 1988203004 di login Siakad
    When Mahasiswa input password 123456 di login Siakad
    And Click login button
    Then Mahasiswa masuk ke beranda Edlink dengan nama RAHMAH DWI LESTARI dan role Mahasiswa
    
    Given Mahasiswa dapat melihat tugas <judul> di beranda Edlink    
    Then Mahasiswa dapat melihat batas & waktu pengumpulan di beranda Edlink
    And Mahasiswa dapat melihat countdown pengumpulan di beranda Edlink
    
    Given Mahasiswa tap tugas di beranda Edlink
    Then Mahasiswa dapat melihat judul tugas <judul> di detail tugas
    And Mahasiswa dapat melihat catatan <catatan> di detail tugas
    And Mahasiswa dapat melihat sisa waktu pengumpulan di detail tugas
    
    Given Mahasiswa mengisi jawaban tugas <jawaban> di detail tugas
    When Mahasiswa tap simpan jawaban di detail tugas
    And Mahasiswa tap Ya di pop up detail tugas
    Then Mahasiswa dapat melihat jawaban <jawaban> tersimpan di detail tugas
    And Mahasiswa dapat melihat daftar anggota yang telah mengumpulkan dengan nama RAHMAH DWI LESTARI di detail tugas
    
############################## Dosen ##############################


#### MENILAI TUGAS
		Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Admin
    
    Given Dosen tap tugas di dashboard
    When Dosen melihat mahasiswa telah mengumpulkan tugas di detail tugas
    When Dosen tap lihat tugas mahasiswa di detail tugas
    Then Dosen melihat jawaban tugas mahasiswa <jawaban> di detail jawaban mahasiswa
    
    Given Dosen input nilai tugas mahasiswa <nilai> di detail jawaban mahasiswa
    And Dosen input feedback tugas mahasiswa <feedback> di detail jawaban mahasiswa
    When Dosen tap Simpan & Lanjut di detail jawaban mahasiswa
    And Dosen close detail jawaban mahasiswa
    Then Dosen melihat tugas mahasiswa telah dinilai <nilai> di detail tugas 
    
############################# Mahasiswa ##############################
		Given Mahasiswa masuk ke website Edlink
    When Mahasiswa tap Siakad button
    When Mahasiswa input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Mahasiswa input username 1988203004 di login Siakad
    When Mahasiswa input password 123456 di login Siakad
    And Click login button
    Then Mahasiswa masuk ke beranda Edlink dengan nama RAHMAH DWI LESTARI dan role Mahasiswa
    
    Given Mahasiswa dapat melihat tugas <judul> di beranda Edlink
    Then Mahasiswa dapat melihat nilai tugas <nilai> di beranda Edlink
    When Mahasiswa tap tugas di beranda Edlink
    Then Mahasiswa dapat melihat judul tugas <judul> di detail tugas
    And Mahasiswa dapat melihat catatan <catatan> di detail tugas
    Then Mahasiswa dapat melihat jawaban <jawaban> tersimpan di detail tugas
    And Mahasiswa dapat melihat daftar anggota yang telah mengumpulkan dengan nama RAHMAH DWI LESTARI di detail tugas
    And Mahasiswa dapat melihat nilai tugas <nilai> di detail tugas
    
############################## Dosen ##############################


#### MENGHAPUS TUGAS
		Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Admin
    
    Given Dosen tap tugas di dashboard
    When Tugas <judul> dihapus
    
    Examples:
    | judul | catatan | jawaban | nilai | feedback |
    | a			| c				| j				| 1			| f				 |