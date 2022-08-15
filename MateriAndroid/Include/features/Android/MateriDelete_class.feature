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
	 	
	 	#gabisa scroll text, kasih judul yg paling atas
	 	Given Dosen tap materi <judul> yang akan dilakukan aksi di menu Class ANDROID
	 	When Dosen tap icon aksi di detail materi di ANDROID
  	And Dosen tap opsi <aksi> di detail materi di ANDROID  


    Examples:
    | username   | password | judul | aksi | 
    | 1008078602 | 123456  | Materi3 | delete | 
    #minor : hanya bisa menghapus materi dengan judul pada halaman pertama, gabisa scroll kebawah