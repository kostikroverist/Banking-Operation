# Banking-Operation

---
##Guidelines

---
If you want to use this program we need Postman but in the future we will create application for  computers and phones
###Run the blog application
+ Clone this repository:
    >
  
  
    git clone   https://github.com/kostikroverist/Banking-Operation.git   
    
  + Go to release directory and enter mvn spring-boot:run

 >
  
  
    cd Banking-Operation 
   
   and 
   
     mvn spring-boot:run
   
   
   ##Postman
    
   + First url POST http://localhost:8080/expenses   
   that save expenses found fields body.raw.json and paste your expenses, example:
    
    {
       "date": "2021-03-25",
       "amount":10000,
       "currency":"USD",
       "product" : ["CAR"]
    }
    
  + If you want get all expenses filter by date this is url will be help you

   GET  http://localhost:8080/expenses example:
    
          
      {
             "id": 1,
             "date": "2021-03-25",
             "amount": 10.0,
             "currency": "USD",
             "product": [
                 "milk"
             ]
         },
         {
             "id": 2,
             "date": "2021-03-22",
             "amount": 100000.0,
             "currency": "USD",
             "product": [
                 "Car"
             ]
         },
         {
             "id": 3,
             "date": "2020-03-22",
             "amount": 100.0,
             "currency": "USD",
             "product": [
                 "book"
             ]
         }
           
  + Delete all expenses by date this url DELETE http://localhost:8080/expenses/ 2021-03-22 
  and paste date after that all expenses was delete 
  
  +  Total costs can be calculated under this url 
  
   http://localhost:8080/total?base= (USD,UAH) example:
    
       300.0      
        