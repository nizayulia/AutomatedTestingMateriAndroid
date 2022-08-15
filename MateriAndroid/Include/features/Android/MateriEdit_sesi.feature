Feature: Edit materi

  Scenario Outline: Dosen memberikan aksi mengedit pada materi kelas
    Given User masuk ke android Edlink ANDROID
    When User tap Siakad button ANDROID
    When User input universitas, <username>, dan <password> login ANDROID
    And Click login button ANDROID
    Then Dosen masuk ke beranda Edlink ANDROID
    
 #	Scenario Outline: Dosen masuk ke dalam menu kelas
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
  	And Dosen tap opsi edit di detail materi di ANDROID  
  	
  	Given Dosen edit <opsiEdit> material <detailEdit> di ANDROID
    When Dosen tap next step material di ANDROID
    And Dosen tap share <optionShare> material di ANDROID
    Then Dosen telah membagikan material di ANDROID 

    Examples:
    | username   | password | judul | menu | opsiEdit | detailEdit| optionShare |
    | 1008078602 | 123456  | Materi1 | sesi | judul | ini via sesi | now | 
      
    # aksi : edit, delete
    #opsiEdit : judul, notes
    #detailEdit : rician yang diedit
    #optionShare : now, later
    
# NOTES!!!
    # - Saat mengganti judul, jangan lupa untuk mengganti text objectnya sesuai test case judul yg digunakan
    # - Saat ini masih belum bisa scroll to text mencari judul yang diinputkan, 
    # 	sehingga pastikan judul materi ada di halaman pertama pada aplikasi