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

#	Scenario Outline: Dosen menambahkan materi kelas dari menu diskusi
	 	Given Dosen tap materi <judul> yang akan dilakukan aksi di menu class ANDROID
	 	When Dosen tap icon aksi di detail materi di ANDROID
  	And Dosen tap opsi edit di detail materi di ANDROID  
  	
  	Given Dosen edit <opsiEdit> material <detailEdit> di ANDROID
    When Dosen tap next step material di ANDROID
    And Dosen tap share <optionShare> material di ANDROID
    Then Dosen telah membagikan material di ANDROID 

    Examples:
    # hanya bisa mengedit materi dengan judul pada halaman pertama, gabisa scroll kebawah
    | username   | password | judul | opsiEdit | detailEdit| optionShare | 
    | 1008078602 | 123456  | Test case edit | notes | test edit catatan baru | now |
    
    #opsiEdit : judul, notes
    #detailEdit : rician yang diedit
    #optionShare : now, later
    