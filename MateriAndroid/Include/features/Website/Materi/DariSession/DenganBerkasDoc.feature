Feature: Testing feature tambah Materi dari session di Website Edlink

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
    
    # Pembuatan materi
    Given Dosen tap buat bahan materi di pop up buat bahan
    And Dosen tap button Tambahkan di pop up buat bahan
    Then Dosen masuk halaman form buat materi
    
    Given Dosen input judul materi <judul> di form buat materi
    When Dosen tap bagikan materi sekarang di form buat materi 
    When Dosen tap tambah dokumen di form buat materi
    Then Dosen melihat pop up media library
    
    Given Dosen memilih berkas doc di media library
    When Dosen tap pilih di pop up media library
    Then Dosen melihat media doc telah terpilih di form buat materi
    
    Given Dosen input catatan <catatan> di form buat materi
    And Dosen tap simpan di form buat materi
    
    # Pengecekan materi yang telah tersimpan    
    Given Dosen tap menu Beranda pada header
    Then Materi <judul> berhasil tersimpan di sistem dashboard
    
    Given Dosen tap materi di dashboard
    Then Judul materi <judul> berhasil disimpan
    And Bagikan materi Dibagikan berhasil disimpan
    And Dokumen materi format doc berhasil disimpan
    
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
    And Mahasiswa dapat melihat dokumen doc di detail materi
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