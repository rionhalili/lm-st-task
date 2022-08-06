> #### Problem description
**PROBLEM: SALES TAXES**

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
Write an application that prints out the receipt details for these shopping baskets...

> Input 1:
> * 1 book at 12.49
> * 1 music CD at 14.99
> * 1 chocolate bar at 0.85

> Input 2:
> * 1 imported box of chocolates at 10.00 
> * 1 imported bottle of perfume at 47.50

> Input 3:
> * 1 imported bottle of perfume at 27.99 
> * 1 bottle of perfume at 18.99
> * 1 packet of headache pills at 9.75
> * 1 box of imported chocolates at 11.25


OUTPUT

> Output 1:
> * 1 book : 12.49
> * 1 music CD: 16.49
> * 1 chocolate bar: 0.85 
> * Sales Taxes: 1.50 
> * Total: 29.83

> Output 2:
> * 1 imported box of chocolates: 10.50 
> * 1 imported bottle of perfume: 54.65 
> * Sales Taxes: 7.65
> * Total: 65.15

> Output 3:
> * 1 imported bottle of perfume: 32.19 
> * 1 bottle of perfume: 20.89
> * 1 packet of headache pills: 9.75
> * 1 imported box of chocolates: 11.85 Sales Taxes: 6.70
Total: 74.68

# Tools
* Kotlin 1.7.10
* Testing: JUnit 5
* Gradle

# How to run (test) this example?
According to the challenge it allows to create and use hard coded data e.g providing those in a unit test
To fully test the inputs and outputs cases, you should run:
>PaymentCounterTest.kt

***NOTE There are 3 test cases which test every input and output from the challenge.***

# Software Design

Following OOP pillars and Clean Code practices.

Design patterns used:
* Abstract Factory
* Strategy Pattern

***Abstract Factory***

The usage of this pattern points to Product where Product is an abstract class and every other Product such as: Book, Food, Medicine and Other inherit from Product class.

| Advantages                                                                                        | Disadvantages                                                                                  |
|---------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| You can easily extend any new products in the future as you don’t need to change the client code. | 1. The code may become way too complicated if there are multiple requests to add new products. |
| Avoiding tight coupling between concrete products and client code.                                |                                                                                                |
| Single Responsibility Principle by extracting the production code in one place.                   |                                                                                                |
| Open/Closed Principle where you can add new strategies without changing the context               |                                                                                                |

***Strategy Pattern***

The usage of this pattern points to TaxCalculation as each product might have different taxes and features. By using Strategy Pattern we handle each category.

| Advantages                                                                           | Disadvantages                                                   |
|--------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| You can swap different logic inside an object at runtime.                            | 1. Defining strategies might be a bit risky on the client side. |
| Isolating the implementation details from the code that uses it.                     |                                                                 |
| Open/Closed Principle where you can add new strategies without changing the context. |                                                                 |

# Using Test-driven Development practices

Testing in this example includes different parts, different business logics.
> ProductTest.kt - tests main functions of Product class
> 
> PaymentCounterTest.kt - tests 3 cases from inputs
> 
> TaxServiceFactoryTest - tests the strategy
> 
> TaxServiceTest - tests tax calculations
> 
> RoundingOperationTest - tests rounding operations
> 
Tests are written following the best practices on TDD. A motivational example is Guided by Zombies using TDD
* Reference:
http://blog.wingman-sw.com/tdd-guided-by-zombies



