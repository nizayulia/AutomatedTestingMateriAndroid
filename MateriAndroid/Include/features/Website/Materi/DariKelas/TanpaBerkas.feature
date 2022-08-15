Feature: Testing feature tambah Materi tanpa berkas dari kelas di Website Edlink

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
    
    # Pembuatan materi
    Given Dosen tap menu Diskusi pada kelas
    When Dosen tap icon materi di diskusi kelas
    Then Dosen melihat pop up pilih sesi
    
    Given Dosen tap sesi dari kelas
    And Dosen tap langkah berikutnya di pop up pilih sesi
    
    Given Dosen input judul materi <judul> di pop up atur materi
    
    Given Dosen tap langkah berikutnya di pop up atur materi
    Then Dosen melihat pop up bagikan materi
    
    Given Dosen input catatan <catatan> di pop up bagikan materi
    And Dosen tap bagikan materi sekarang di pop up bagikan materi 
    And Dosen tap bagikan di pop up bagikan materi
    
    # Pengecekan materi yang telah tersimpan
    Given Dosen tap menu Beranda pada header
    Then Materi <judul> berhasil tersimpan di sistem dashboard
    
    Given Dosen tap materi di dashboard
    Then Judul materi <judul> berhasil disimpan
    And Bagikan materi Dibagikan berhasil disimpan
    
    Given Dosen tap kembali ke detail sesi kelas
    Then Materi <judul> berhasil tersimpan di sesi kelas
    Given Dosen tap menu Diskusi pada kelas
    Then Materi <judul> berhasil tersimpan di kelas
    
############################# Mahasiswa ##############################
		Given Mahasiswa masuk ke website Edlink
    When Mahasiswa tap Siakad button
    When Mahasiswa input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Mahasiswa input username 1988203004 di login Siakad
    When Mahasiswa input password 123456 di login Siakad
    And Click login button
    Then Mahasiswa masuk ke beranda Edlink dengan nama RAHMAH DWI LESTARI dan role Mahasiswa
    
    And Mahasiswa dapat melihat materi <judul> di beranda Edlink
    
    Given Mahasiswa tap menu Ruang Kelas pada header
    When Mahasiswa tap Akademik di Ruang Kelas
    And Mahasiswa tap periode pada Akademik
    And Mahasiswa tap periode 2020/2021 Ganjil pada periode
    And Mahasiswa tap Terapkan pada Akademik
    Then Mahasiswa melihat kelas pada Ruang Kelas
    
    When Mahasiswa tap kelas di Ruang Kelas
    Then Mahasiswa masuk ke kelas Edlink
    
    Given Mahasiswa tap menu Diskusi pada kelas
    When Mahasiswa dapat melihat materi <judul> di diskusi kelas
    
    When Mahasiswa tap materi di diskusi kelas
    Then Mahasiswa dapat melihat judul materi <judul> di detail materi
    And Mahasiswa dapat melihat catatan <catatan> di detail materi
    
############################## Dosen ##############################

		Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Admin
    
    Given Dosen tap materi di dashboard
    When Materi <judul> dihapus
    
    Examples:
    | judul | catatan |
    | a			| c				|