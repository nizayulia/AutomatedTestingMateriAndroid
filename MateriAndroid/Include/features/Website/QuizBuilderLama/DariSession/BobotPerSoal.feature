Feature: Testing feature login pada Website Edlink

  Scenario Outline: User login dengan akun siakad
  
    Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Dosen
    
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
    
    Given Dosen tap buat bahan quiz di pop up buat bahan
    And Dosen tap button Tambahkan di pop up buat bahan
    Then Dosen masuk halaman form quiz

    Given Dosen input judul quiz <judul> di builder lama
    When Dosen tap bagikan quiz sekarang di builder lama
    And Dosen tap indikator penilaian quiz per soal di builder lama
    And Dosen tap non aktif batas nilai quiz builder lama
    And Dosen input durasi quiz <durasi> di builder lama
    And Dosen non aktif batas waktu di builder lama
    And Dosen tap laporan kepada peserta quiz <laporan> di builder lama
    
    When Dosen tap edit pertanyaan pertama di builder lama
    And Dosen mengisi bobot pertanyaan <bobot> di builder lama
    And Dosen tap Simpan pertanyaan quiz di builder lama
    Then Dosen melihat bobot pertanyaan ke 1 <bobot> di builder lama
    
    When Dosen tap tambah pertanyaan quiz di builder lama
    And Dosen input pertanyaan quiz <pertanyaan> di builder lama
    And Dosen input jawaban A quiz <jawaban1> di builder lama
    And Dosen input jawaban B quiz <jawaban2> di builder lama
    And Dosen input jawaban C quiz <jawaban3> di builder lama
    And Dosen mengisi bobot pertanyaan <bobot> di builder lama
    And Dosen tap Simpan pertanyaan quiz di builder lama
    Then Pertanyaan quiz <pertanyaan> berhasil disimpan di builder lama
    And Dosen melihat bobot pertanyaan ke 2 <bobot> di builder lama
    When Dosen input catatan quiz <catatan> di builder lama
    And Dosen menyimpan quiz di builder lama
    
    # Pengecekan isi quiz yang telah tersimpan 
    Then Judul quiz <judul> berhasil disimpan
    And Bagikan quiz Dibagikan berhasil disimpan
    And Indikator Penilaian quiz bobot per soal berhasil disimpan
    And Durasi pengerjaan quiz <durasi> Menit berhasil disimpan
    And Batas waktu quiz - berhasil disimpan
    And Laporan kepada peserta quiz <laporan> berhasil disimpan
    And Pertanyaan quiz <pertanyaan> berhasil disimpan di builder lama
    And Catatan quiz <catatan> berhasil disimpan
    
    # Pengecekan quiz yang telah tersimpan
    Given Dosen tap kembali ke detail sesi kelas
    Then Quiz <judul> berhasil disimpan di sesi kelas
    Given Dosen tap menu Diskusi pada kelas
    Then Quiz <judul> berhasil disimpan di kelas
    Given Dosen tap menu Beranda pada header
    Then Quiz <judul> berhasil tersimpan di sistem dashboard
    
############################## Mahasiswa ##############################
		Given Mahasiswa masuk ke website Edlink
    When Mahasiswa tap Siakad button
    When Mahasiswa input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Mahasiswa input username 1988203004 di login Siakad
    When Mahasiswa input password 123456 di login Siakad
    And Click login button
    Then Mahasiswa masuk ke beranda Edlink dengan nama RAHMAH DWI LESTARI dan role Mahasiswa
    
    Given Mahasiswa melihat quiz <judul> pada beranda Edlink
    When Mahasiswa tap menu Ruang Kelas pada header
    When Mahasiswa tap Akademik di Ruang Kelas
    And Mahasiswa tap periode pada Akademik
    And Mahasiswa tap periode 2020/2021 Ganjil pada periode
    And Mahasiswa tap Terapkan pada Akademik
    Then Mahasiswa melihat kelas pada Ruang Kelas
    
    When Mahasiswa tap kelas di Ruang Kelas
    Then Mahasiswa masuk ke kelas Edlink
    
    Given Mahasiswa tap menu Sesi Pembelajaran pada kelas
    When Mahasiswa tap Sesi ke 1 pada kelas
    Then Mahasiswa melihat quiz <judul> pada detail sesi
    
    Given Mahasiswa tap judul quiz <judul> di detail sesi
    Then Mahasiswa dapat melihat catatan quiz <catatan> di detail quiz
    And Mahasiswa dapat melihat judul quiz <judul> di detail quiz
    And Mahasiswa dapat melihat total pertanyaan quiz 2 dan durasi quiz <durasi> Menit di detail quiz
    
    # Mengerjakan soal di quiz
    Given Mahasiswa tap mulai quiz
    Then Mahasiswa dapat melihat durasi berjalan di quiz
    And Mahasiswa dapat melihat judul <judul> di quiz
    And Mahasiswa dapat melihat total pertanyaan 2 di quiz
    And Mahasiswa dapat melihat bobot <bobot> soal di quiz
    And Mahasiswa tap jawaban A di quiz
    
    When Mahasiswa tap pertanyaan Berikutnya di quiz
    Then Mahasiswa dapat melihat pertanyaan <pertanyaan> di quiz
    And Mahasiswa dapat melihat jawaban A <jawaban1> di quiz
    And Mahasiswa dapat melihat jawaban B <jawaban2> di quiz
    And Mahasiswa dapat melihat jawaban C <jawaban3> di quiz
    And Mahasiswa dapat melihat bobot <bobot> soal di quiz
    
    When Mahasiswa tap jawaban A di quiz
    And Mahasiswa tap pertanyaan Sebelumnya di quiz
    And Mahasiswa tap pertanyaan Berikutnya di quiz
    And Mahasiswa tap Selesaikan quiz
    And Mahasiswa tap konfirmasi Selesaikan quiz
    
    # Menyelesaikan quiz
    Then Mahasiswa dapat melihat nilai di hasil quiz
    And Mahasiswa dapat melihat judul <judul> di hasil quiz
    And Mahasiswa tap Lihat detail hasil
    Then Laporan <laporan> di detail hasil quiz
    When Mahasiswa tap tutup detail hasil
    Then Mahasiswa dapat melihat nilai di hasil quiz
    And Mahasiswa dapat melihat judul <judul> di hasil quiz
    
    When Mahasiswa tap kembali dari hasil quiz
    Then Mahasiswa dapat melihat catatan quiz <catatan> di detail quiz
    And Mahasiswa dapat melihat judul quiz <judul> di detail quiz    
    And Mahasiswa dapat melihat total pertanyaan quiz 2 dan durasi quiz <durasi> Menit di detail quiz
    And Mahasiswa dapat melihat nilai quiz di detail quiz
    And Mahasiswa dapat melihat jawaban benar 2 di detail quiz
    And Mahasiswa dapat melihat jawaban salah 0 di detail quiz
    And Mahasiswa dapat melihat Durasi Pengerjaan
    
    # Keluar dari halaman quiz
    When Mahasiswa tap kembali dari detail quiz
    And Mahasiswa tap menu Beranda pada header
    Then Mahasiswa dapat melihat judul quiz <judul> di beranda
    And Mahasiswa melihat nilai quiz tersimpan di sistem dashboard
    
############################## Dosen ##############################
    Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Dosen
    #And Dosen melihat Papan Peringkat Quiz
    
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
    Then Dosen melihat quiz <judul> pada detail sesi
    
    Given Dosen tap judul quiz <judul> di detail sesi
    Then Dosen dapat melihat laporan quiz mahasiswa di detail quiz
    And Dosen dapat melihat nilai peserta quiz <bobot> di detail quiz
    And Dosen tap detail hasil pengerjaan quiz di detail quiz
    And Dosen dapat melihat soal benar mahasiswa dari 2 soal di detail quiz
    And Dosen dapat melihat soal salah mahasiswa dari 0 soal di detail quiz
    And Dosen dapat melihat jawaban mahasiswa
    
    When Dosen tap kembali dari detail hasil pengerjaan quiz
    Then Dosen dapat melihat laporan quiz mahasiswa di detail quiz
    Then Quiz <judul> dihapus
    
    #Examples: of Judul Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 5			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 | 1		 |	
    
    #Examples: of Durasi Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 1439	 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1439 	 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 | 1		 |	
    
    #Examples: of Laporan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 5			 | Ditampilkan 			 | a					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1		 |	
    #| a			| 1439	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1		 |	
    
    #Examples: of Pertanyaan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 | 1		 |	
    #| a			| 1440	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 | 1		 |	
    #
    #Examples: of Jawaban Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 | 1		 |	
    #| a			| 1440	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 | 1		 |	
    #
    #Examples: of Catatan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    #| a			| 5			 | Ditampilkan 			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr | 1		 |	
    #| a			| 1439	 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr			 | 1		 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr | 1		 |	
    #
    Examples: of Bobot Quiz
    | judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan | bobot |
    | a			| 5			 | Ditampilkan 			 | a					| b				 | s				| s				 | a			 | 1000	 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1			 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1000	 |
    #| a			| 1439	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1000	 |	
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 | 1000	 |	
    	
    