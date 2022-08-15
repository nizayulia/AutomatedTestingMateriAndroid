Feature: Testing feature login pada Android Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke android Edlink ANDROID
    When Mahasiswa tap terms condition ANDROID
    When Mahasiswa tap Siakad button ANDROID
    When Mahasiswa input universitas, username, dan password ANDROID
    And Click login button ANDROID
    Then Mahasiswa masuk ke beranda Edlink ANDROID
    
    Given Mahasiswa melihat quiz pada beranda Edlink ANDROID
    Then Mahasiswa dapat melihat catatan quiz <catatan> di beranda Edlink ANDROID
    And Mahasiswa dapat melihat judul quiz <judul> di beranda Edlink ANDROID
    And Mahasiswa dapat melihat total pertanyaan quiz 2 di beranda Edlink ANDROID
    
    Given Mahasiswa tap See Detail Quiz pada beranda Edlink ANDROID
    Then Mahasiswa dapat melihat catatan quiz <catatan> di detail quiz ANDROID
    And Mahasiswa dapat melihat judul quiz <judul> di detail quiz ANDROID
    And Mahasiswa dapat melihat total pertanyaan quiz 2 di detail quiz ANDROID
    
    ##########################################################################
    
    When Mahasiswa tap kembali di ANDROID
    Then Mahasiswa melihat quiz pada beranda Edlink ANDROID
    
    Given Mahasiswa tap menu Class ANDROID
    When Mahasiswa tap Menu Academic di menu Class ANDROID
    And Mahasiswa tap periode di menu Class ANDROID
    And Mahasiswa tap periode 2020/2021 Genap di menu Class ANDROID
    And Mahasiswa tap List Class Bahasa A di menu Class ANDROID
    Then Mahasiswa masuk halaman Class ANDROID
    
    Given Mahasiswa melihat quiz pada discussion Class ANDROID
    Then Mahasiswa dapat melihat catatan quiz <catatan> di discussion Class ANDROID
    And Mahasiswa dapat melihat judul quiz <judul> di discussion Class ANDROID
    And Mahasiswa dapat melihat total pertanyaan quiz 2 di discussion Class ANDROID
    
    Given Mahasiswa tap See Detail Quiz di discussion Class ANDROID
    Then Mahasiswa dapat melihat catatan quiz <catatan> di detail quiz ANDROID
    And Mahasiswa dapat melihat judul quiz <judul> di detail quiz ANDROID
    And Mahasiswa dapat melihat total pertanyaan quiz 2 di detail quiz ANDROID
    
    #Given Mahasiswa tap Start Quiz di detail quiz ANDROID 
    
    
    Examples: of judul
    | judul | durasi | laporan 					 | pertanyaan | jawaban1 | jawaban2 | jawaban3 | catatan |
    | a			| 1			 | Tidak Ditampilkan | a					| b				 | s				| s				 | a			 |