Feature: Testing feature tambah Materi dari dashboard Website Edlink

  Scenario Outline: User login dengan akun siakad
  
    Given Dosen masuk ke website Edlink
    When Dosen tap Siakad button
    When Dosen input perguruan tinggi Universitas Lancang Kuning di login Siakad
    When Dosen input username 1008078602 di login Siakad
    When Dosen input password 123456 di login Siakad
    And Click login button
    Then Dosen masuk ke beranda Edlink dengan nama IDEL WALDELMI, M.Si dan role Admin
    
    # Pembuatan materi
    Given Dosen tap icon materi di beranda Edlink
    Then Dosen melihat pop up pilih kelas & sesi
    
    Given Dosen tap kelas yang akan dibagikan
    When Dosen tap sesi dari kelas
    And Dosen tap langkah berikutnya di pop up pilih kelas & sesi
    Then Dosen melihat form atur materi
    
    Given Dosen input judul materi <judul> di pop up atur materi
    When Dosen tap tambah berkas di pop up atur materi
    Then Dosen melihat pop up media library
    
    Given Dosen memilih berkas mp4 di media library
    When Dosen tap pilih di pop up media library
    Then Dosen melihat media mp4 telah terpilih di pop up atur materi
    
    Given Dosen tap langkah berikutnya di pop up atur materi
    Then Dosen melihat pop up bagikan materi
    
    Given Dosen input catatan <catatan> di pop up bagikan materi
    And Dosen tap bagikan materi sekarang di pop up bagikan materi 
    And Dosen tap bagikan di pop up bagikan materi
    
    # Pengecekan materi yang telah tersimpan
    Given Dosen tap menu Beranda pada header
    Then Materi <judul> berhasil tersimpan di sistem dashboard
    And Dokumen materi format video berhasil tersimpan di sistem dashboard
    
    Given Dosen tap materi di dashboard
    Then Judul materi <judul> berhasil disimpan
    And Bagikan materi Dibagikan berhasil disimpan
    And Dokumen materi format mp4 berhasil disimpan
    
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
    
    Given Mahasiswa dapat melihat materi <judul> di beranda Edlink
    When Mahasiswa tap materi di beranda Edlink
    Then Mahasiswa dapat melihat judul materi <judul> di detail materi
    And Mahasiswa dapat melihat dokumen mp4 di detail materi
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