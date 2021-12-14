Feature: Product owner and IMDB



  Scenario: a product owner should be able to consult the names of th crew

    Given I enter the title 'Carmencita'
    Then the requested data is returned


  Scenario: a product owner want return  most greteast number episodes

    Given I call the API for this
    Then the answer returned is the most greteast number episodes
