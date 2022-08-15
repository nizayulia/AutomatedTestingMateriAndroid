Feature: Mahasiswa melihat materi yang dibagikan pada Android Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke android Edlink ANDROID
    When User tap Siakad button ANDROID
    When User input universitas, <username>, dan <password> login ANDROID
    And Click login button ANDROID
    And Mahasiswa tap button skip tutorial Edlink ANDROID
    Then Mahasiswa masuk ke beranda Edlink ANDROID
    
 #Scenario Outline: Dosen masuk ke dalam menu kelas
    Given Mahasiswa tap menu Class ANDROID
    When Mahasiswa tap Menu Academic di menu Class ANDROID
    And Mahasiswa tap periode di menu Class ANDROID
    And Mahasiswa tap periode 2020/2021 Ganjil di menu Class ANDROID
    And Mahasiswa tap List Class Bahasa A di menu Class ANDROID
    Then Mahasiswa masuk halaman Class ANDROID
    
    Given Mahasiswa tap materi <materi> yang akan dilakukan aksi di menu Class ANDROID
    
    
    Examples:
    | username   | password | materi | 
    | 1988203004 | 123456   | Materi1 |