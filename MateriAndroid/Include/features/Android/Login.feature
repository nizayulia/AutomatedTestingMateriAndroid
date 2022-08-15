Feature: Testing feature login pada Android Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke android Edlink ANDROID
    #When User tap terms condition ANDROID
    When User tap Siakad button ANDROID
    When User input universitas, <username>, dan <password> login ANDROID
    And Click login button ANDROID
    Then Mahasiswa masuk ke beranda Edlink ANDROID
    
    Examples: of judul
    | username   | password | 
    | 1008078602 | 123456   |