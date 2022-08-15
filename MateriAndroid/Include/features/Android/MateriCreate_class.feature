Feature: Testing feature materi pada Android Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke android Edlink ANDROID
    When User tap Siakad button ANDROID
    When User input universitas, <username>, dan <password> login ANDROID
    And Click login button ANDROID
    Then Dosen masuk ke beranda Edlink ANDROID
    
 #Scenario Outline: Dosen masuk ke dalam menu kelas
    Given Dosen tap menu Class ANDROID
    When Dosen tap Menu Academic di menu Class ANDROID
    And Dosen tap periode di menu Class ANDROID
    And Dosen tap periode 2020/2021 Ganjil di menu Class ANDROID
    And Dosen tap List Class Bahasa A di menu Class ANDROID
    Then Dosen masuk halaman Class ANDROID
    
 #Scenario Outline: Dosen menambahkan materi kelas dari menu discussion
    Given Dosen tap button Create di Class ANDROID
    When Dosen tap button Create Material di list Create di Class ANDROID
    Then Dosen masuk pop up Create Material di Class ANDROID
    
    When Dosen tap list Session di pop up Create Material di Class ANDROID
    And Dosen tap Session 1 di list Session Material di Class ANDROID
    And Dosen tap button next di pop up Create Material di Class ANDROID
    Then Dosen masuk halaman form Material ANDROID
    
    Given Dosen input judul material <judul> di ANDROID
    And Dosen input catatan material <notes> di ANDROID
		And Dosen choose file material <jenisFile> dengan <namaFile> di ANDROID 
    
    When Dosen tap next step material di ANDROID
    #untuk share later belum dicek buat memilih waktu tertentu
    And Dosen tap share <optionShare> material di ANDROID
    Then Dosen telah membagikan material di ANDROID 
    
    
    

    
    
    
    
    Examples:
    | username   | password | judul | notes | jenisFile | namaFile | optionShare |
    #| 1008078602 | 123456   | Materi1 | tanpa lampiran | none | none | later |
    | 1008078602 | 123456   | Materi2 | lampiran file mp4 | mp4 | Refresh form (1).mp4 | now|
    | 1008078602 | 123456   | Materi3 | lampiran file doc | doc |3 pertanyaan.docx| now|
    | 1008078602 | 123456   | materi4 | lampiran file jpg dibagikan nanti | jpg | 782538.jpg | later |