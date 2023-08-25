Feature: Adding all endpoints to configuration properties

  Scenario Outline: Adding endpoints
    When The user should be able to add all endpoints as "<register>" and "<generateToken>" and "<authorized>" and "<getAllBooks>" and "<addBook>" and "<getUserByID>" and "<updateBook>" and "<deleteBook>"
    Examples:
      | register         | generateToken             | authorized             | getAllBooks         | addBook             | getUserByID           | updateBook                 | deleteBook         |
      | /Account/v1/User | /Account/v1/GenerateToken | /Account/v1/Authorized | /BookStore/v1/Books | /BookStore/v1/Books | /Account/v1/User/{id} | /BookStore/v1/Books/{isbn} | /BookStore/v1/Book |
