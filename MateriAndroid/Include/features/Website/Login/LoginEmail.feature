Feature: Testing feature login pada Website Edlink

  Scenario Outline: User login dengan email
    Given User masuk ke website Edlink
    When User input email <email> di login Email
    When User input password <password> di login Email
    And Click login button
    #Then User cek Campus News email <email> password <password>
    Then User masuk ke beranda Edlink dengan nama <name> dan role <role>
    
    Examples:
    | email			 						 		 | password | name					| role  		|
    | edlink.dosen@gmail.com 		 | 123456		| Dosen EdLinkk | Dosen 		|
    | edlink.mahasiswa@gmail.com | 123456		| Tina Toon			| Mahasiswa |
    | edlink.sevima@gmail.com		 | 12345		| EdLink Sevima	| Tamu			|
    