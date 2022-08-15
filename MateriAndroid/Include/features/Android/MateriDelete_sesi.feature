Feature: Delete Materi

  Scenario Outline: Dosen memberikan aksi menghapus pada materi kelas
    Given User masuk ke android Edlink ANDROID
    When User tap Siakad button ANDROID
    When User input universitas, <username>, dan <password> login ANDROID
    And Click login button ANDROID
    Then Dosen masuk ke beranda Edlink ANDROID
    
    Given Dosen tap menu Class ANDROID
    When Dosen tap Menu Academic di menu Class ANDROID
    And Dosen tap periode di menu Class ANDROID
    And Dosen tap periode 2020/2021 Ganjil di menu Class ANDROID
    And Dosen tap List Class Bahasa A di menu Class ANDROID
    Then Dosen masuk halaman Class ANDROID
    
    Given Dosen tap submenu Session di Class ANDROID
    When Dosen tap session 1 di menu Session di Class ANDROID	 
	 	
	 	Given Dosen tap materi <judul> yang akan dilakukan aksi di menu sesi ANDROID
	 	When Dosen tap icon aksi di detail materi di ANDROID
  	And Dosen tap opsi delete di detail materi di ANDROID  


    Examples:
    #minor : hanya bisa menghapus materi dengan judul pada halaman pertama, gabisa scroll kebawah
    | username   | password | judul | 
    | 1008078602 | 123456  | Materi1 |
    
 # NOTES!!!
    # - Saat mengganti judul, jangan lupa untuk mengganti text objectnya sesuai test case judul yg digunakan
    # - Saat ini masih belum bisa scroll to text mencari judul yang diinputkan, 
    # 	sehingga pastikan judul materi ada di halaman pertama pada aplikasi