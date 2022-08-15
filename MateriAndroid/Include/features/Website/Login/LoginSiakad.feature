Feature: Testing feature login pada Website Edlink

  Scenario Outline: User login dengan akun siakad
    Given User masuk ke website Edlink
    When User tap Siakad button
    When User input perguruan tinggi <universitas> di login Siakad
    When User input username <username> di login Siakad
    When User input password <password> di login Siakad
    And Click login button
    Then User masuk ke beranda Edlink dengan nama <name> dan role <role>
    
    Examples:
    |universitas							 | username	 	| password 	| name								| role  		|
    |Universitas Lancang Kuning| 1008078602 | 123456		| IDEL WALDELMI, M.Si | Admin 		|
    |Universitas Lancang Kuning| 1988203004 | 123456		| RAHMAH DWI LESTARI	| Mahasiswa |
    |Demo Siakad Cloud				 | dini				| dini321		| dini								| Admin			|
    