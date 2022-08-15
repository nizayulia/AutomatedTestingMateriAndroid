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
    When Dosen tap bagikan quiz nanti di builder lama
    And Dosen tap tanggal bagikan quiz di builder lama
    And Dosen tap indikator penilaian quiz otomatis di builder lama
    And Dosen tap non aktif batas nilai quiz builder lama
    And Dosen input durasi quiz <durasi> di builder lama
    And Dosen non aktif batas waktu di builder lama
    And Dosen tap laporan kepada peserta quiz <laporan> di builder lama
    
    When Dosen tap tambah pertanyaan quiz di builder lama
    And Dosen input pertanyaan quiz <pertanyaan> di builder lama
    And Dosen input jawaban A quiz <jawaban1> di builder lama
    And Dosen input jawaban B quiz <jawaban2> di builder lama
    And Dosen input jawaban C quiz <jawaban3> di builder lama
    And Dosen tap Simpan pertanyaan quiz di builder lama
    Then Pertanyaan quiz <pertanyaan> berhasil disimpan di builder lama
    When Dosen input catatan quiz <catatan> di builder lama
    And Dosen menyimpan quiz di builder lama
    
    # Pengecekan isi quiz yang telah tersimpan 
    Then Judul quiz <judul> berhasil disimpan
    And Bagikan quiz Belum Dibagikan berhasil disimpan
    And Indikator Penilaian quiz bobot otomatis berhasil disimpan
    And Durasi pengerjaan quiz <durasi> Menit berhasil disimpan
    And Batas waktu quiz - berhasil disimpan
    And Laporan kepada peserta quiz <laporan> berhasil disimpan
    And Pertanyaan quiz <pertanyaan> berhasil disimpan di builder lama
    And Catatan quiz <catatan> berhasil disimpan
    
    # Pengecekan quiz yang telah tersimpan
    Given Dosen tap kembali ke detail sesi kelas
    Then Quiz <judul> berhasil disimpan di sesi kelas
    And Quiz <judul> Belum Dibagikan di sesi kelas
    Given Dosen tap menu Diskusi pada kelas
    Then Quiz <judul> tidak ditemukan di kelas
    Given Dosen tap menu Beranda pada header
    Then Quiz <judul> tidak ditemukan di sistem dashboard
    
############################## Mahasiswa ##############################
		Given Mahasiswa masuk ke website Edlink
    When Mahasiswa tap Siakad button
    When Mahasiswa input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Mahasiswa input username 1988203004 di login Siakad
    When Mahasiswa input password 123456 di login Siakad
    And Click login button
    Then Mahasiswa masuk ke beranda Edlink dengan nama RAHMAH DWI LESTARI dan role Mahasiswa
    And Mahasiswa tidak melihat quiz <judul> pada beranda Edlink
    
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
    Then Mahasiswa tidak melihat quiz <judul> pada detail sesi
   
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
    Then Quiz <judul> Belum Dibagikan di sesi kelas
    
    When Dosen tap judul quiz <judul> di detail sesi
    And Dosen tap Simpan pertanyaan quiz di builder lama
    Then Quiz <judul> dihapus
    
    Examples: of Judul Quiz
    | judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    | a			| 5			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |5			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |
    #
    #Examples: of Durasi Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    #| a			| 1439	 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1439 	 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |
    #
    #Examples: of Laporan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    #| a			| 5			 | Ditampilkan 			 | a					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |5			 | Ditampilkan			 | a					| b				 | s				| s				 | a			 |
    #| a			| 1439	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | a					| b				 | s				| s				 | a			 |
    #
    #Examples: of Pertanyaan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    #| a			| 5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 |
    #| a			| 1440	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| b				 | s				| s				 | a			 |
    #
    #Examples: of Jawaban Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    #| a			| 5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |5			 | Tidak Ditampilkan | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 |
    #| a			| 1440	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr					| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr				 | s				| s				 | a			 |
    #
    #Examples: of Catatan Quiz
    #| judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    #| a			| 5			 | Ditampilkan 			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |5			 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |
    #| a			| 1439	 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr			 |
    #| ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |1440 	 | Ditampilkan			 | a					| b				 | s				| s				 | ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakter ini 255 karakterr |