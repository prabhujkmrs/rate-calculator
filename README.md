# Rate Calculator
It is a simple java application that calculates the rate allowing the prospective borrowers to obtain a quote from the pool of lenders for 36 months loan.This system will  take the form of a command-line application.  


## Future considerations
Convert the application to a RESTful webservice to get quote over http

## Requirements
  You will need a file containing a list of all the offers being made  by the lenders within the system in CSV format. 
  [Click here](src/main/java/resource/market-data.csv) for sample file
  
    You should strive to provide as low a rate to the borrower as is possible to  ensure that Zopa's quotes are as competitive as they can be against our  competitors'. 
  
  You should also provide the borrower with the details of the  monthly repayment amount and the total repayment amount. 
  
   Repayment amounts should be displayed to 2 decimal places and the rate of the  loan should be displayed to one decimal place. 
    
  Borrowers should be able to request a loan of any £100 increment between £1000  and £15000 inclusive.
  
  If the market does not have sufficient offers from  lenders to satisfy the loan then the system should inform the borrower that it  is not possible to provide a quote at that time.
   
     The application should take arguments in the form:  
   ```
       cmd> [application] [market_file] [loan_amount]  
   ```    
   Example: 
   ```     
       cmd> quote.exe market.csv 1500  
   ```
   The application should produce output in the form: 
   ```     
       cmd> [application] [market_file] [loan_amount]     
       Requested amount: £XXXX 
       Rate: X.X%     
       Monthly repayment: £XXXX.XX     
       Total repayment: £XXXX.XX  
   ```
   Example:  	
   ```
       cmd> quote.exe market.csv 1000 	
       Requested amount: £1000 	
       Rate: 7.0% 	
       Monthly repayment: £30.78 	
       Total repayment: £1108.10  
   ```

## Tools used
```
Java8
Junit
Gradle
```

## Build

Run the below command to build:
```
./gradlew clean build
```

## Testing
To run the unit tests, execute:
```
./gradlew test
```

## To run
To run the application, execute:
```
java -jar build/libs/rate-calculator-1.0.0.jar <path-to-the-market-data-csv-file> <required loan amount>

Example: java -jar build/libs/rate-calculator-1.0.0.jar /home/zopa/market-datah.csv 1000
```






