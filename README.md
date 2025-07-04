# Project Description

This is a simple console-based e-commerce checkout system developed in Java for the **Fawry Quantum Internship Challenge**.  
It supports product management, cart operations, and a checkout workflow that generates both a shipping notice and a receipt.  
Products may or may not require shipping, and some may expire while others do not.

---


## Example Output

** **Shipment notice** **

2x Cheese 0.40 kg

1x Biscuits 0.70 kg

Total package weight: 1.10 kg

** **Checkout receipt** **

2x Cheese : 200.0 EGP

1x Biscuits : 150.0 EGP

1x Scratch Card : 50.0 EGP

---
Subtotal: 400.0

Shipping: 110.0

Amount: 510.0

Customer Balance: 490.0

---

## How to Run

1. Clone the repository.
2. Open the project using any Java IDE.
3. Ensure that your environment supports **Java 11** or higher.
4. Navigate to the `Main.java` file in the `main` package.
5. Run the application. The console will display the shipment notice and checkout receipt.

---

## Assumptions

1. Shipping cost is calculated as `50 EGP` per kilogram of total package weight.
2. Products may be:
    - Expirable (e.g., Cheese, Biscuits)
    - Non-expirable (e.g., TV, Scratch Card)
3. Some products require shipping, others do not.
4. Shippable products implement a `Shippable` interface and provide weight.
5. If a product is expired or out of stock, it cannot be added to the cart.
6. An exception is thrown if:
    - The cart is empty
    - The customer's balance is insufficient

> Note: This is a console application that runs entirely in-memory. It does **not** use any GUI or database.

---

## Technologies Used

- Java 23
- Object-Oriented Programming (OOP)
- Git + GitHub