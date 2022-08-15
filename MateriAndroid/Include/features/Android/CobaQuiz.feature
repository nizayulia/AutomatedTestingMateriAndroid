Feature: Testing feature login pada Android Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke android Edlink ANDROID
    #When Dosen tap terms condition ANDROID
    When Dosen tap Siakad button ANDROID
    When Dosen input universitas, username, dan password ANDROID
    And Click login button ANDROID
    Then Dosen masuk ke beranda Edlink ANDROID
    
    Given Dosen tap menu Class ANDROID
    When Dosen tap Menu Academic di menu Class ANDROID
    And Dosen tap periode di menu Class ANDROID
    And Dosen tap periode 2020/2021 Genap di menu Class ANDROID
    And Dosen tap List Class Bahasa A di menu Class ANDROID
    Then Dosen masuk halaman Class ANDROID
    
    Given Dosen tap button Create di Class ANDROID
    When Dosen tap button Create Quiz di list Create di Class ANDROID
    Then Dosen masuk pop up Create Quiz di Class ANDROID
    
    When Dosen tap list Session di pop up Create Quiz di Class ANDROID
    And Dosen tap Session 1 di list Session Quiz di Class ANDROID
    And Dosen tap button next di pop up Create Quiz di Class ANDROID
    Then Dosen masuk halaman form Quiz ANDROID
    
    Given Dosen input judul quiz <judul> di ANDROID
    When Dosen tap indikator penilaian quiz otomatis di ANDROID
    And Dosen input durasi quiz <durasi> di ANDROID
    And Dosen tap non aktif batas nilai quiz di ANDROID
    And Dosen tap non aktif Deadline quiz di ANDROID
    And Dosen tap non aktif Laporan ke Peserta quiz di ANDROID
    And Dosen tap button Simpan settings quiz di ANDROID
    Then Dosen masuk halaman form pertanyaan quiz <judul> di ANDROID
    
    When Dosen tap tambah pertanyaan quiz di ANDROID
    And Dosen input pertanyaan quiz <pertanyaan> di ANDROID
    And Dosen input jawaban A quiz <jawaban1> di ANDROID
    And Dosen input jawaban B quiz <jawaban2> di ANDROID
    And Dosen input jawaban C quiz <jawaban3> di ANDROID
    And Dosen tap Selesai pertanyaan quiz di ANDROID
    
    And Dosen tap soal nomor 2 di Android
    And Dosen input pertanyaan quiz <pertanyaan> di ANDROID
    And Dosen tap Selesai pertanyaan quiz di ANDROID
    
    Then Pertanyaan quiz <pertanyaan> berhasil disimpan di ANDROID
    When Dosen tap button bagikan quiz di ANDROID
    And Dosen input catatan quiz <catatan> di ANDROID
    And Dosen tap button bagikan quiz Sekarang di ANDROID
    And Dosen tap button submit bagikan di ANDROID
    Then Quiz <judul> berhasil disimpan
    
    
    
    Examples: of judul
    | judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    | a			| 1			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |