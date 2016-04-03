Feature: Documentparser
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.


  Scenario: Parse docx
    Given document of type 'docx'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse doc
    Given document of type 'doc'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse dot
    Given document of type 'dot'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse html
    Given document of type 'html'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse mht
    Given document of type 'mht'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse pdf
    Given document of type 'pdf'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse rtf
    Given document of type 'rtf'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse txt
    Given document of type 'txt'
    When the user parses document
    Then 'Hello' should be in result

  Scenario: Parse xml
    Given document of type 'xml'
    When the user parses document
    Then 'Hello' should be in result
